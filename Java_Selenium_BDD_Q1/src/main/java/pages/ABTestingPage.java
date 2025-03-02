package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ABTestingPage {
    WebDriver driver;
    private By abText = By.xpath("//h3[normalize-space()='A/B Test Variation 1']");

    public ABTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getABTestingText() {
        return driver.findElement(abText);
    }

    public boolean verifyABTestingText() {
        return getABTestingText().isDisplayed();
    }
}
