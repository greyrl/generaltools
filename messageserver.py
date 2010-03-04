#!/usr/bin/python

import asyncore, httplib, libxml2, smtplib, smtpd, socket

class messageserver(smtpd.SMTPServer):
    '''Process SMTP search requests'''

    def process_message(self, peer, mailfrom, rcpttos, data):
        query = ('\n').join(data.split(":")[-1].split("\n")[1:]).strip()
        print "query %s" % query
        query = '/search?page=sr-00-00&post=1&start=0&skiptransform=y&search=' \
            + query
        h = httplib.HTTP('hivinsite.ucsf.edu')
        h.putrequest('GET', query)
        h.putheader('Host', 'hivinsite.ucsf.edu')
        h.putheader('User-agent', 'chi-sms-query')
        h.endheaders()
        returncode, returnmsg, headers = h.getreply()
        if returncode != 200: return
        result = libxml2.parseDoc(h.getfile().read())
        result = result.xpathEval("//result-row/first-paragraph")
        if not len(result) > 0: return
        body = result[0].get_content()
        server = smtplib.SMTP('pmtct.org', 22)
        #server.login('rgrey', 'blaa')
        server.sendmail(rcpttos[0], (mailfrom), body)
        server.quit()

if __name__ == '__main__':
    messageserver(('127.0.0.1', 8080), 0)
    try: asyncore.loop()
    except KeyboardInterrupt: pass
