package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;

    By searchBox = By.id("filter_keyword");
    By searchButton = By.cssSelector("span.button-search");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productId) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

      //  driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productId);

        // Option 1: Press Enter
        driver.findElement(searchBox).sendKeys(Keys.ENTER);

        // Option 2: Click search button (if needed)
        // driver.findElement(searchButton).click();
    }
}
