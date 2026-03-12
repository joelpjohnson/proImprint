package pages.user;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

   // By colorGreen = By.xpath("//div[@data-name='Green']");
    By allColors = By.cssSelector("div.clrsecone");
//    By imprintMethod = By.id("imprint_method");   // inspect actual ID
  //  By imprintColor = By.id("imprint_color");     // inspect actual ID
   By quantityBox = By.id("quantity");           // inspect actual ID
    By addToCartBtn = By.id("button-cart");       // inspect actual ID
    By imprintColorDropdown = By.id("pmsoption140486_msdd");
    By yellowOption = By.xpath("//span[text()='Yellow 116']");
    By proceedToCheckoutBtn = By.id("proceedtocheckout");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

//    public void selectColor() {
//        wait.until(ExpectedConditions.elementToBeClickable(colorGreen)).click();
//    }
    public void selectColor() {

        try {

            By allColors = By.cssSelector("div.clrsecone");

            wait.until(ExpectedConditions.presenceOfElementLocated(allColors));

            java.util.List<WebElement> colors = driver.findElements(allColors);

            if (colors.size() > 0) {

                WebElement firstColor = colors.get(0);
                String colorName = firstColor.getAttribute("title");

                wait.until(ExpectedConditions.elementToBeClickable(firstColor)).click();

                System.out.println("Color selected: " + colorName);
            }

        } catch (Exception e) {

            System.out.println("No product color selection available - skipping");

        }
    }
    public void selectImprintColor(String colorName) {

        try {

            WebElement dropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(imprintColorDropdown));

            dropdown.click();

            By colorOption = By.xpath("//span[text()='" + colorName + "']");

            WebElement option = wait.until(
                    ExpectedConditions.elementToBeClickable(colorOption));

            option.click();

            System.out.println("Imprint color selected: " + colorName);

        } catch (Exception e) {

            System.out.println("Imprint color option not available - skipping");

        }
    }


    public void enterQuantity(String qty) {

        try {

            WebElement qtyField = wait.until(
                    ExpectedConditions.elementToBeClickable(quantityBox));

            qtyField.click();
            qtyField.sendKeys(Keys.CONTROL + "a");
            qtyField.sendKeys(Keys.DELETE);
            qtyField.sendKeys(qty);

            wait.until(ExpectedConditions.attributeToBe(quantityBox, "value", qty));

            System.out.println("Quantity entered: " + qty);

        } catch (Exception e) {

            System.out.println("Quantity field not available - skipping");

        }
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
//    public void clickProceedToCheckout() {
//
//        WebElement checkoutBtn = wait.until(
//                ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
//
//        checkoutBtn.click();
//    }
    public void clickProceedToCheckout() {

        By checkoutBtn = By.id("proceedtocheckout");

        WebElement btn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(checkoutBtn));

        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }
}