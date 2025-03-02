from selenium.webdriver.common.by import By

class FileUploadPage:
    def __init__(self, driver):
        self.driver = driver
        self.header = (By.TAG_NAME, "h3")
        self.choose_file = (By.ID, "file-upload")
        self.upload_button = (By.ID, "file-submit")

    def get_header_text(self):
        return self.driver.find_element(*self.header).text

    def upload_file(self, file_path):
        self.driver.find_element(*self.choose_file).send_keys(file_path)

    def click_upload(self):
        self.driver.find_element(*self.upload_button).click()
