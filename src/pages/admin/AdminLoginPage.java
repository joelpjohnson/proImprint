package pages.admin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class AdminLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.name("username");
    By password = By.name("password");
   // By loginBtn = By.cssSelector("input[type='submit'], button[type='submit']");
    By loginBtn = By.xpath("//a[contains(@class,'button') and normalize-space()='Login']");


    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String user, String pass) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).clear();
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
}