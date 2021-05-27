import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver driver;

    private static final int MAX_ITEMS = 50;

    By productResultSelector = By.cssSelector("[data-component-type='s-search-result']");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openProduct(int index) {

        if(index < 0 || index >= MAX_ITEMS) {
            throw new IndexOutOfBoundsException("The index must be between 0 and " + MAX_ITEMS);
        }

        driver.findElements(productResultSelector).get(index).click();
        return new ProductPage(driver);
    }
}
