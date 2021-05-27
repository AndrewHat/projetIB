import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAllCategories() {
        By hamburgerButtonSelector = By.id("nav-hamburger-menu");
        driver.findElement(hamburgerButtonSelector).click();
    }

    public void openAmazonPrimeVideo() {
        By amazonPrimeVideoSelector = By.cssSelector(".hmenu-item[data-menu-id='2']");

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(amazonPrimeVideoSelector));
        driver.findElement(amazonPrimeVideoSelector).click();
    }

    public void openFilms() {
        By filmsButtonSelector = By.cssSelector(".hmenu-visible[data-parent-menu-id='1'] li:nth-of-type(4)");

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(filmsButtonSelector));
        driver.findElement(filmsButtonSelector).click();
    }
}
