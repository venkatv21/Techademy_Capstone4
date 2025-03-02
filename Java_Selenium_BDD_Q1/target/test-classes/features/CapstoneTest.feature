Feature: Verify The Internet App Functionalities

  Scenario: Validate different functionalities on the web application
    Given User navigates to "http://the-internet.herokuapp.com"
    When User verifies the page title as "The Internet"
    And User clicks on "A/B Testing"
    Then User verifies the text on the page as "A/B Test Variation 1"
    When User navigates back to the home page
    And User clicks on "Dropdown"
    Then User selects "Option 1" from the dropdown and verifies selection
    When User navigates back to the home page
    And User clicks on "Frames"
    Then User verifies "Nested Frames" and "iFrame" links exist
