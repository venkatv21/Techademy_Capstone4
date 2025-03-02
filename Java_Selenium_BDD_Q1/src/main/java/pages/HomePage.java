package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    private By abTestingLink = By.xpath("//a[normalize-space()='A/B Testing']");
    private By dropdownLink = By.xpath("//a[normalize-space()='Dropdown']");
    private By framesLink = By.xpath("//a[normalize-space()='Frames']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getABTestingLink() {
        return driver.findElement(abTestingLink);
    }

    public WebElement getDropdownLink() {
        return driver.findElement(dropdownLink);
    }

    public WebElement getFramesLink() {
        return driver.findElement(framesLink);
    }
}
