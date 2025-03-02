package stepDefinitions;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static base.BaseTest.quitDriver;

public class StepDefinitions {
    WebDriver driver = BaseTest.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    HomePage home = new HomePage(driver);
    ABTestingPage abTest = new ABTestingPage(driver);
    DropdownPage dropdown = new DropdownPage(driver);
    FramesPage frames = new FramesPage(driver);

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    @When("User verifies the page title as {string}")
    public void user_verifies_the_page_title_as(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title does not match!");
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String page) {
        switch (page) {
            case "A/B Testing":
                wait.until(ExpectedConditions.elementToBeClickable(home.getABTestingLink())).click();
                break;
            case "Dropdown":
                wait.until(ExpectedConditions.elementToBeClickable(home.getDropdownLink())).click();
                break;
            case "Frames":
                wait.until(ExpectedConditions.elementToBeClickable(home.getFramesLink())).click();
                break;
            default:
                Assert.fail("Invalid page selection!");
        }
    }

    @Then("User verifies the text on the page as {string}")
    public void user_verifies_the_text_on_the_page_as(String expectedText) throws InterruptedException {
        // Define possible XPaths for the A/B test text variations
        By variation1XPath = By.xpath("//h3[contains(text(), 'A/B Test Variation 1')]");
        By controlXPath = By.xpath("//h3[contains(text(), 'A/B Test Control')]");

        WebElement element = null;

        try {
            // Check if Variation 1 exists and is visible
            if (!driver.findElements(variation1XPath).isEmpty() && driver.findElement(variation1XPath).isDisplayed()) {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(variation1XPath));
            }
            // If Variation 1 is not found, check for Control
            else if (!driver.findElements(controlXPath).isEmpty() && driver.findElement(controlXPath).isDisplayed()) {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(controlXPath));
            }
        } catch (Exception e) {
            Assert.fail("Neither 'A/B Test Variation 1' nor 'A/B Test Control' was found.");
        }

        // Ensure the element is found
        Assert.assertNotNull(element, "No valid A/B Testing text found!");

        // Get and print the actual text
        String actualText = element.getText();
        System.out.println("Actual Text Found: " + actualText);

        // Define possible expected variations
        List<String> expectedVariations = Arrays.asList("A/B Test Variation 1", "A/B Test Control");

        // Validate the text
        Assert.assertTrue(expectedVariations.contains(actualText),
                "Text verification failed! Found: " + actualText + ", but expected one of: " + expectedVariations);
    }


    @When("User navigates back to the home page")
    public void user_navigates_back_to_the_home_page() {
        driver.navigate().back();
        wait.until(ExpectedConditions.titleIs("The Internet"));
    }

    @Then("User selects {string} from the dropdown and verifies selection")
    public void user_selects_from_the_dropdown_and_verifies_selection(String option) {
        dropdown.selectOption(option);
        Assert.assertTrue(dropdown.isOptionSelected(option), "Dropdown selection failed!");
    }

    @Then("User verifies {string} and {string} links exist")
    public void verifyFrames(String nested, String iframe) {
        Assert.assertTrue(frames.verifyFramesLinks(), "Frames links verification failed!");
        quitDriver();
    }
}
