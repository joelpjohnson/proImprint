package pages.user;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProImploginPage {

    WebDriver driver;
    WebDriverWait wait;

    By emailField = By.id("login_mail");
    By passwordField = By.id("login_password");
    By loginButton = By.id("login_guestproceed");

    public ProImploginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(200));
    }

//    public void setValues(String email, String password) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
//        driver.findElement(passwordField).sendKeys(password);
//    }
//    public void setValues(String email, String password) {
//
//        // Wait until email field is visible
//        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
//
//        // 🔎 Debug check
//        System.out.println("Email field displayed: " +
//                driver.findElement(emailField).isDisplayed());
//
//        System.out.println("Email field enabled: " +
//                driver.findElement(emailField).isEnabled());
//
//        // Try typing
//        driver.findElement(emailField).sendKeys(email);
//        driver.findElement(passwordField).sendKeys(password);
//    }
    public void setValues(String email, String password) {

        WebElement emailElement = wait.until(
                ExpectedConditions.elementToBeClickable(emailField));

        emailElement.click();          // 🔥 Important
        emailElement.clear();
        emailElement.sendKeys(email);

        WebElement passwordElement = wait.until(
                ExpectedConditions.elementToBeClickable(passwordField));

        passwordElement.click();       // 🔥 Important
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
//
//    public void login() {
//        driver.findElement(loginButton).click();
//    }
    public void login() {

        driver.findElement(loginButton).click();

        // Wait for login popup to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginButton));

    }

}
