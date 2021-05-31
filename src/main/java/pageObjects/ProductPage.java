package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageComponents.Header;

public class ProductPage {

    WebDriver driver;

    By productTitleSelector = By.id("productTitle");

    Header header;
    By headerSelector = By.tagName("header");


    public ProductPage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(headerSelector);
        header = new Header(headerContainer);
    }

    public String getProductTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        return wait.until(ExpectedConditions.presenceOfElementLocated(productTitleSelector)).getText();
    }

    public SearchResultPage search(String keyword) {
        System.out.println("Search keyword [" + keyword + "]");
        header.search(keyword);
        return new SearchResultPage(driver);
    }
}
