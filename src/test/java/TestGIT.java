import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class TestGIT {
    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome() {
        var options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.addArguments("disable-popup-blocking");
        options.addArguments("no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("acceptSslCerts=true");
        options.addArguments("unexpectedAlertBehaviour=accept");

        try {
            driver = new RemoteWebDriver(new
                    URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

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
        boolean isHomeButtonDisplayed = amazonHomePage
                .openAllCategories()
                .openAmazonPrimeVideo()
                .openFilms()
                .isHomeButtonDisplayed();

        // Asserts
        Assert.assertTrue(isHomeButtonDisplayed, "Le button accueil n'est pas visible");
    }

    @Test
    public void testComponent() {
        System.out.println("Starting test");
        HomePage homePage = new HomePage(driver);

        System.out.println("Home page is loaded");

        homePage.search("Nintendo Switch")
                .openProduct(2)
                .search("Playstation 5")
                .search("Xbox s")
                .search("Mac")
                .search("iPhone")
                .openProduct(0)
                .search("Android");

        System.out.println("Test is finished");
    }

    @Test
    public void testNintendoSwitch() {
        String keyword = "Nintendo Switch";

        HomePage homePage = new HomePage(driver);
        String productTitle = homePage.search(keyword).openProduct(0).getProductTitle();

        Assert.assertTrue(productTitle.contains(keyword), "The product title [" + productTitle + "] does not contain the keyword [" + keyword + "]");
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

    @Test
    public void testHover() {
        HomePage homePage = new HomePage(driver);
        homePage.openAccountAndListMenu();
    }
}
