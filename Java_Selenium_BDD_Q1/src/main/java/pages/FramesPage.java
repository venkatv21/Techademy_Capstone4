package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FramesPage {
    WebDriver driver;
    WebDriverWait wait;
    By nestedFrames = By.xpath("//a[normalize-space()='Nested Frames']");
    By iFrame = By.xpath("//a[normalize-space()='iFrame']");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean verifyFramesLinks() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nestedFrames));
        wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame));
        return driver.findElement(nestedFrames).isDisplayed() &&
                driver.findElement(iFrame).isDisplayed();
    }
}
