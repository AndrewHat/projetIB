import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    By searchTextboxSelector = By.id("twotabsearchtextbox");
    By searchButtonSelector = By.id("nav-search-submit-button");
    By hamburgerButtonSelector = By.id("nav-hamburger-menu");
    By amazonPrimeVideoSelector = By.cssSelector(".hmenu-item[data-menu-id='2']");
    By filmsButtonSelector = By.cssSelector(".hmenu-visible[data-parent-menu-id='1'] li:nth-of-type(4)");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openAllCategories() {
        driver.findElement(hamburgerButtonSelector).click();
        return this;
    }

    public HomePage openAmazonPrimeVideo() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(amazonPrimeVideoSelector));
        driver.findElement(amazonPrimeVideoSelector).click();
        return this;
    }

    public PrimeVideoHomePage openFilms() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(filmsButtonSelector));
        driver.findElement(filmsButtonSelector).click();
        return new PrimeVideoHomePage(driver);
    }

    public SearchResultPage search(String keyword) {
        driver.findElement(searchTextboxSelector).sendKeys(keyword);
        driver.findElement(searchButtonSelector).click();
        return new SearchResultPage(driver);
    }
}
