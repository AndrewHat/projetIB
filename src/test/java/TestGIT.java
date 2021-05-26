import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGIT {
    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();

        By cookiesSelector = By.name("accept");
        driver.findElement(cookiesSelector).click();
    }

    @AfterMethod
    public void fermerChrome() {
        driver.quit();
    }

    @Test
    public void testAmazon() {
        // Arrange

        // Act
        By hamburgerButtonSelector = By.id("nav-hamburger-menu");
        driver.findElement(hamburgerButtonSelector).click();

        By amazonPrimeVideoSelector = By.cssSelector(".hmenu-item[data-menu-id='2']");

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(amazonPrimeVideoSelector));
        driver.findElement(amazonPrimeVideoSelector).click();

        By filmsButtonSelector = By.cssSelector(".hmenu-visible[data-parent-menu-id='1'] li:nth-of-type(4)");
        wait.until(ExpectedConditions.elementToBeClickable(filmsButtonSelector));
        driver.findElement(filmsButtonSelector).click();

        // Asserts

        WebElement accueilButton = driver.findElement(By.id("pv-nav-home"));
        Assert.assertTrue(accueilButton.isDisplayed(), "Le button accueil n'est pas visible");
    }

    @Test
    public void testLuis() {
        By barreRecherche = By.id("twotabsearchtextbox");
        driver.findElement(barreRecherche).sendKeys("Playstation 5" + Keys.ENTER);
    }
}
