from selenium import selenium
import unittest, time, re

class sample(unittest.TestCase):
    def setUp(self):
        self.verificationErrors = []
        self.selenium = selenium("localhost", 4444, "*chrome", "http://a810-bisweb.nyc.gov/")
        self.selenium.start()
    
    def testSample(self):
        sel = self.selenium
        sel.open("/bisweb/bispi00.jsp")
        # TODO make 'passdevicenumber' dynamic
        sel.type("passdevicenumber", "4p10707")
        sel.click("go26")
        sel.wait_for_page_to_load("30000")
        sel.click("link=regexp:[0-9]{7}")
        sel.wait_for_page_to_load("30000")
        sel.click("link=Violations-ECB (DOB)")
        while 1:
            try: 
                sel.wait_for_page_to_load("30000")
                for i in range(1,8):
                    id = sel.get_table("//table[3].%s.1" % i)
                    status = sel.get_table("//table[3].%s.5" % i)
                    print "id %s, status %s " % (id, status)
                    if status == "CURED": self._processHit(id)
                sel.click("next")
            except Exception as e:
                print "error or end of processing encountered"
                #print e
                break
    
    def _processHit(self, id):
        print "process %s" % id
        sel = self.selenium
        sel.click("link=%s" % id)
        sel.wait_for_page_to_load("30000")
        print "found %s" % sel.get_table("//table[3].6.2")

    def tearDown(self):
        self.selenium.stop()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()
