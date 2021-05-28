package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.SearchResultPage;

public class Header {
    WebElement container;

    By searchTextboxSelector = By.id("twotabsearchtextbox");
    By searchButtonSelector = By.id("nav-search-submit-button");

    public Header(WebElement container) {
        this.container = container;
    }

    public void search(String keyword) {
        container.findElement(searchTextboxSelector).clear();
        container.findElement(searchTextboxSelector).sendKeys(keyword);
        container.findElement(searchButtonSelector).click();
    }
}
