import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrimeVideoHomePage {
    WebDriver driver;

    public PrimeVideoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomeButtonDisplayed() {
        WebElement accueilButton = driver.findElement(By.id("pv-nav-home"));
        return accueilButton.isDisplayed();
    }
}
