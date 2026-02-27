package pages.user;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    By colorGreen = By.xpath("//div[@data-name='Green']");
//    By imprintMethod = By.id("imprint_method");   // inspect actual ID
  //  By imprintColor = By.id("imprint_color");     // inspect actual ID
   By quantityBox = By.id("quantity");           // inspect actual ID
    By addToCartBtn = By.id("button-cart");       // inspect actual ID
    By imprintColorDropdown = By.id("pmsoption140486_msdd");
    By yellowOption = By.xpath("//span[text()='Yellow 116']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void selectColor() {
        wait.until(ExpectedConditions.elementToBeClickable(colorGreen)).click();
    }
    public void selectImprintColor(String colorName) {

        // Click dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(imprintColorDropdown));
        dropdown.click();

        // Wait for option to appear
        By colorOption = By.xpath("//span[text()='" + colorName + "']");
        
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(colorOption));
        option.click();
    }


    public void enterQuantity(String qty) {

        WebElement qtyField = wait.until(
                ExpectedConditions.elementToBeClickable(quantityBox));

        qtyField.click();
        qtyField.sendKeys(Keys.CONTROL + "a");
        qtyField.sendKeys(Keys.DELETE);
        qtyField.sendKeys(qty);
       // qtyField.sendKeys(Keys.TAB);

        wait.until(ExpectedConditions.attributeToBe(quantityBox, "value", qty));
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
}