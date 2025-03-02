from selenium.webdriver.common.by import By

class CheckboxPage:
    def __init__(self, driver):
        self.driver = driver
        self.header = (By.TAG_NAME, "h3")
        self.checkbox1 = (By.XPATH, "//form[@id='checkboxes']/input[1]")
        self.checkbox2 = (By.XPATH, "//form[@id='checkboxes']/input[2]")

    def get_header_text(self):
        return self.driver.find_element(*self.header).text

    def is_checkbox1_selected(self):
        return self.driver.find_element(*self.checkbox1).is_selected()

    def is_checkbox2_selected(self):
        return self.driver.find_element(*self.checkbox2).is_selected()
