'''
   Process binary log and replicate changes. You will need to have a
   database called "repl" on the receiving database to track the position
   from the sending binary log. Here are required command line options:

   -l - the local log directory location, must be readable
   -f - the local database name. used to filter statements from the logs
   -u - the receiving connection username 
   -p - the receiving connection password. should be BASE64 encoded 
        (for minimal security)
   -h - the receiving hostname
   -d - the receiving database name

'''

from __future__ import with_statement
from os import path
import getopt, re, sys
import MySQLdb

class transaction:
    '''database transaction'''

    def __init__(self, options, db):
        self.db = db
        self.options = options
    
    def __enter__(self):
        print "connection to database [%s]" % self.db
        self.conn = MySQLdb.connect(db=self.db, **self.options)
        self.cursor = self.conn.cursor()
        self.cursor.commit = False
        self.cursor.execute("BEGIN")
        return self.cursor

    def __exit__(self, exc_type, exc_value, traceback):
        #print "connection close. commit? %s" % self.cursor.commit
        self.conn.commit() if self.cursor.commit else self.conn.rollback()
        self.conn.close()

class replicate():
    '''replication object'''

    FINDSQL = "select position, logfile from lastup where db = %s"
    POSRE = re.compile("# at ([0-9]*)")
    SKIP = ("use", "BEGIN", "COMMIT", "ROLLBACK", "DELIMITER", "SET", "#", "/*")
    TABLESQL = '''
        create table lastup (db varchar(255), position bigint not null, 
            logfile varchar(255), primary key(db),
            lastupdate timestamp default current_timestamp)
    '''
    UPDSQL = "insert into lastup (db, position, logfile) values (%s, %s, %s)"

    position = None

    def __init__(self, options):
        import base64, commands, copy
        self.options = copy.copy(options)
        for option in ["logdir", "db", "filter"]:
            setattr(self, option, self.options[option])
            del self.options[option]
        # decrypt password
        if "passwd" in self.options:
            try:
                pwd = self.options["passwd"]
                self.options["passwd"] = base64.b64decode(pwd);
            except:
                print "unable to decrypt password, should be encoded in base64"
        # find binlog command
        self.mysqlbinlog = commands.getstatusoutput("which mysqlbinlog")
        if self.mysqlbinlog[0] is not 0: 
            raise Exception("unable to find mysqlbinlog command")
        self.mysqlbinlog = self.mysqlbinlog[1]

    def _connect(self, db=None):
        '''create a database connection'''
        if not db: db = self.db
        return transaction(self.options, db)

    def _replicationtables(self):
        '''check to make sure replication tables exist'''
        with self._connect("repl") as cursor:
            cursor.execute("show tables")
            if not cursor.fetchone():
                print "creating replication tables"
                cursor.execute(self.TABLESQL)
            cursor.execute(self.FINDSQL, self.db)
            res = cursor.fetchone()
            return (res[0], res[1]) if res else (None, None)

    def _logfiles(self, last):
        '''list log files names'''
        indexfile = self.logdir + "/mysql-bin.index"
        if not path.exists(indexfile): raise Exception("no index file")
        with file(self.logdir + "/mysql-bin.index") as idx:
            return [line.strip() for line in idx.readlines() if line >= last]

    def _extractstatement(self, str):
        '''extract the sql statement from a long binary string'''
        res = ""
        for line in str.split("\n"):
            if not line or line.startswith(self.SKIP): continue
            res += "%s " % line
        return res.strip()

    def _updateposition(self, file):
        '''update last replication timestamp'''
        if not self.position: return
        with self._connect("repl") as cursor:
            cursor.execute("delete from lastup where db = %s", self.db)
            cursor.execute(self.UPDSQL, (self.db, self.position, file))
            cursor.commit = True

    def run(self):
        position, logfile = self._replicationtables()
        if position and logfile:
            print "running from position %i on log [%s]" % (position, logfile)
        count = 0
        lastfile = logfile
        with self._connect() as cursor: 
            from subprocess import PIPE, Popen
            for lastfile in self._logfiles(logfile):
                print "process log [%s]" % lastfile
                if path.exists(lastfile): file = lastfile
                else: file = self.logdir + "/" + lastfile
                if not path.exists(file): 
                    raise Exception("unable to find file %s" % file)
                args = [self.mysqlbinlog, "--database=%s" % self.filter]
                if position and logfile == lastfile:
                    args.append("--start-position=%s" % position)
                args.append(file)
                for res in Popen(args, stdout=PIPE).communicate():
                    if not res: continue
                    res = self.POSRE.split(res)
                    for next in zip(res[1::2],res[2::2]):
                        if int(next[0]) == position and logfile == lastfile: 
                            continue
                        self.position = next[0]
                        next = self._extractstatement(next[1])
                        if not next: continue
                        try: 
                            cursor.execute(next)
                            print "processed [%s]" % self.position
                            count += 1
                        except:
                            print "\n---\nunable to execute [%s]\n---\n" % next
                            count = 0
                            raise
            if count > 0: cursor.commit = True
        if count > 0: self._updateposition(lastfile)
        print "completed %i statement(s)" % count

def usage():
    exitmessage(("Usage: %s -l <log directory> -f <log database> -u " + \
            "<update user> -p <encoded update password> -h <update host> " + \
            "-d <update database>") % sys.argv[0])

def exitmessage(str):
    print str
    sys.exit(1)

def keyrename(dict):
    '''expand keywords into full values, add to list for additional vals'''
    for i in ["host", "user", "passwd", "db", "logdir", "filter"]:
        key = "-" + i[0]
        dict[i] = dict[key]
        del dict[key]
    return dict

if __name__ == '__main__':
    try:
        optlist = getopt.getopt(sys.argv[1:], 'f:d:l:u:h:p:')[0]
        if len(optlist) < 5: usage()
        optlist = keyrename(dict(optlist))
    except getopt.GetoptError:
        usage()
    replicate(optlist).run()
