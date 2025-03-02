import os
from pages.home_page import HomePage
from pages.file_upload_page import FileUploadPage

def test_file_upload(driver):
    home_page = HomePage(driver)
    upload_page = FileUploadPage(driver)

    # Step 1: Launch the URL
    home_page.open_url("http://the-internet.herokuapp.com")

    # Step 2: Click File Upload link
    home_page.click_file_upload()

    # Step 3: Verify header text
    assert upload_page.get_header_text() == "File Uploader", "Header text does not match"

    # Step 4: Upload a file
    file_path = os.path.abspath("test_file.txt")
    with open(file_path, "w") as f:
        f.write("Test File Upload")

    upload_page.upload_file(file_path)
    upload_page.click_upload()
