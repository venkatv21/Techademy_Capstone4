from selenium.webdriver.common.by import By

class HomePage:
    def __init__(self, driver):
        self.driver = driver

    def open_url(self, url):
        self.driver.get(url)

    def get_title(self):
        return self.driver.title

    def click_checkboxes(self):
        self.driver.find_element(By.LINK_TEXT, "Checkboxes").click()

    def click_file_upload(self):
        self.driver.find_element(By.LINK_TEXT, "File Upload").click()
