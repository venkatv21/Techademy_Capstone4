from pages.home_page import HomePage
from pages.checkbox_page import CheckboxPage

def test_checkboxes(driver):
    home_page = HomePage(driver)
    checkbox_page = CheckboxPage(driver)

    # Step 1: Launch the URL
    home_page.open_url("http://the-internet.herokuapp.com")

    # Step 2: Verify page title
    assert home_page.get_title() == "The Internet", "Page title does not match"

    # Step 3: Click Checkboxes link
    home_page.click_checkboxes()

    # Step 4: Verify header text
    assert checkbox_page.get_header_text() == "Checkboxes", "Header text does not match"

    # Step 5: Validate Checkboxes
    assert not checkbox_page.is_checkbox1_selected(), "Checkbox 1 should not be selected"
    assert checkbox_page.is_checkbox2_selected(), "Checkbox 2 should be selected"
