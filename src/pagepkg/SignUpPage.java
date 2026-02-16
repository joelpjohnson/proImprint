package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Popup Sign Up
    By popupSignUpBtn = By.id("login_guestproceednew");

    // Registration Form Fields
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email");
    By altemail = By.id("alt_email");
    By primaryPhone = By.id("telephone");
    By cellphone = By.id("cellphone");
    By fax = By.id("fax");
    By password = By.id("password");
    By confirmPassword = By.id("cpassword");
    By registerBtn = By.id("button-register");
//    public void clickPopupSignUp() {
//
//        WebElement btn = driver.findElement(popupSignUpBtn);
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", btn);
//    }
    public void clickPopupSignUp() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(popupSignUpBtn));

        btn.click();

        // Wait until registration form is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
    }




    public void registerUser(String fname, String lname,
                             String mail, String altmail,
                             String phone, String cell, String faxno,
                             String pwd, String cpwd) {

        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(altemail).sendKeys(altmail);
        driver.findElement(primaryPhone).sendKeys(phone);
        driver.findElement(cellphone).sendKeys(cell);
        driver.findElement(fax).sendKeys(faxno);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(cpwd);
        driver.findElement(registerBtn).click();
    }
}
