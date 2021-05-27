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
        HomePage amazonHomePage = new HomePage(driver);
        amazonHomePage.openAllCategories();
        amazonHomePage.openAmazonPrimeVideo();
        amazonHomePage.openFilms();

        // Asserts
        PrimeVideoHomePage primeVideoHomePage = new PrimeVideoHomePage(driver);
        Assert.assertTrue(primeVideoHomePage.isHomeButtonDisplayed(), "Le button accueil n'est pas visible");
    }

    @Test
    public void testLuis() {
        By barreRecherche = By.id("twotabsearchtextbox");
        driver.findElement(barreRecherche).sendKeys("Playstation 5" + Keys.ENTER);
    }
  
    @Test
    public void testXbox() {
        By meilleuresVentes = By.cssSelector("#nav-xshop > a");
        driver.findElement(meilleuresVentes).click();
    }
}
