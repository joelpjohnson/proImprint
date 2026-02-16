package pagepkg;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setValues(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void login() {
        driver.findElement(loginButton).click();
    }
}
