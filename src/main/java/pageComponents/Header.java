package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

public class Header {
    WebElement container;

    By searchTextboxSelector = By.id("twotabsearchtextbox");
    By searchButtonSelector = By.id("nav-search-submit-button");
    By linkAccountSelector = By.id("nav-link-accountList");

    public Header(WebElement container) {
        this.container = container;
    }

    public void search(String keyword) {
        container.findElement(searchTextboxSelector).clear();
        container.findElement(searchTextboxSelector).sendKeys(keyword);
        container.findElement(searchButtonSelector).click();
    }

    public void openAccountAndListMenu() {
        RemoteWebElement remoteElement = (RemoteWebElement)container;
        WebDriver driver = remoteElement.getWrappedDriver();

        WebElement menuButton = container.findElement(linkAccountSelector);
        Actions action = new Actions(driver);
        action.moveToElement(menuButton).build().perform();
    }
}
