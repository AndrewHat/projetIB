package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageComponents.Header;

public class HomePage {

    WebDriver driver;

    By hamburgerButtonSelector = By.id("nav-hamburger-menu");
    By amazonPrimeVideoSelector = By.cssSelector(".hmenu-item[data-menu-id='2']");
    By filmsButtonSelector = By.cssSelector(".hmenu-visible[data-parent-menu-id='1'] li:nth-of-type(4)");
    By headerSelector = By.tagName("header");

    Header header;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(headerSelector);
        header = new Header(headerContainer);
    }

    public HomePage openAllCategories() {
        driver.findElement(hamburgerButtonSelector).click();
        return this;
    }

    public HomePage openAmazonPrimeVideo() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(amazonPrimeVideoSelector)).click();
        return this;
    }

    public PrimeVideoHomePage openFilms() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(filmsButtonSelector)).click();
        return new PrimeVideoHomePage(driver);
    }

    public SearchResultPage search(String keyword) {
        System.out.println("Search keyword [" + keyword + "]");
        header.search(keyword);
        return new SearchResultPage(driver);
    }
}
