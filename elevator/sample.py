from selenium import selenium
import unittest, time, re

class firstsuite(unittest.TestCase):
    def setUp(self):
        self.verificationErrors = []
        self.selenium = selenium("localhost", 4444, "*chrome", "http://a810-bisweb.nyc.gov/")
        self.selenium.start()
    
    def test_firstsuite(self):
        sel = self.selenium
        sel.open("/bisweb/bispi00.jsp")
        sel.type("passdevicenumber", "4p10707")
        sel.click("go26")
        sel.wait_for_page_to_load("30000")
        sel.click("link=4075221")
        sel.wait_for_page_to_load("30000")
        sel.click("link=Violations-ECB (DOB)")
        sel.wait_for_page_to_load("30000")
        sel.click("next")
        sel.wait_for_page_to_load("30000")
        sel.click("next")
        sel.wait_for_page_to_load("30000")
        sel.click("//tr[3]/td[2]/a/b")
        sel.wait_for_page_to_load("30000")
    
    def tearDown(self):
        self.selenium.stop()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()
