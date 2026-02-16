package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartTextFinderPage {

    WebDriver driver;

    By uploadArt = By.xpath("//a[contains(@class,'update') and normalize-space()='Update']");

    public CartTextFinderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUploadArt() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(uploadArt));

        driver.findElement(uploadArt).click();
        System.out.println("uploadArt page");
    }

    public String textVerification() {
        System.out.println("textVerification page");
        return driver.getPageSource();
    }
}
