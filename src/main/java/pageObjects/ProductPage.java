package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        return driver.findElement(productTitleSelector).getText();
    }

    public SearchResultPage search(String keyword) {
        System.out.println("Search keyword [" + keyword + "]");
        header.search(keyword);
        return new SearchResultPage(driver);
    }
}
