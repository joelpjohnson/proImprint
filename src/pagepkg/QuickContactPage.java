package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class QuickContactPage {

    WebDriver driver;

    public QuickContactPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Scroll Method (Add here)
    public void scrollToFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Locators
    By nameField = By.id("quickcontactname");
    By phoneField = By.name("quickcontactphone");
    By emailField = By.name("quickcontactemail");
    By commentField = By.name("quickcontactcomments");
    By submitButton = By.cssSelector("#quickcontact .pim-btn.btn--blue");

    // Actions
    public void enterName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }
    
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    
    public void enterComments(String comments) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comments);
    }

//    public void clickSubmit() {
//        driver.findElement(submitButton).click();
//    }
//    public void clickSubmit() {
//        System.out.println("Clicking submit button...");
//        driver.findElement(submitButton).click();
//        System.out.println("Submit button clicked.");
//    }
//    public void clickSubmit() {
//
//        WebElement button = driver.findElement(submitButton);
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(button).click().perform();
//    }
//    public void clickSubmit() {
//
//        WebElement button = driver.findElement(submitButton);
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", button);
//    }
    public void clickSubmit() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
    }

    public void fillQuickContact(String name, String phone, String email ,String comments) {
        enterName(name);
        enterPhone(phone);
        enterEmail(email);
        enterComments(comments);
        clickSubmit();
    }
}
