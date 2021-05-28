package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrimeVideoHomePage {
    WebDriver driver;

    By accueilButtonSelector = By.id("pv-nav-home");

    public PrimeVideoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomeButtonDisplayed() {
        return driver.findElement(accueilButtonSelector).isDisplayed();
    }
}
