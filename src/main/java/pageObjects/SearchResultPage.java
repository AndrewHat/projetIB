package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageComponents.Header;

public class SearchResultPage {

    WebDriver driver;

    Header header;
    By headerSelector = By.tagName("header");

    private static final int MAX_ITEMS = 50;

    By productResultSelector = By.cssSelector("[data-component-type='s-search-result']");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(headerSelector);
        header = new Header(headerContainer);
    }

    public ProductPage openProduct(int index) {

        if(index < 0 || index >= MAX_ITEMS) {
            throw new IndexOutOfBoundsException("The index must be between 0 and " + MAX_ITEMS);
        }

        driver.findElements(productResultSelector).get(index).click();
        return new ProductPage(driver);
    }

    public SearchResultPage search(String keyword) {
        header.search(keyword);
        return new SearchResultPage(driver);
    }
}
