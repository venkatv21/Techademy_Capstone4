import pytest
from selenium import webdriver
import chromedriver_autoinstaller
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

@pytest.fixture(scope="function")
def driver():
    chromedriver_autoinstaller.install()

# Initialize Chrome WebDriver
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()
