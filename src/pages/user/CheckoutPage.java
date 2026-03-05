package pages.user;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // ================= LOCATORS =================

    private By shippingRadios = By.xpath("//input[@type='radio' and contains(@name,'shipping_method')]");
    private By groundShippingRadios = By.xpath("//input[@type='radio' and @value='Ground Home Delivery (2 to 4 Business Days)']");
    private By fallbackShipping = By.xpath("//input[@type='radio' and contains(@name,'shipping')]");

    private By saveAndContinueBtn = By.id("button-shipping");

    private By paymentCards = By.className("payment_card-content-wrapper");
    private By payAfterArtworkLabel = By.xpath("//label[.//div[normalize-space()='Pay after Approval of Artwork']]");
    private By confirmSection = By.id("confirm_proceed_content");

    private By couponPopup = By.cssSelector(".coupon_popup");
    private By couponCloseBtn = By.cssSelector(".coupon_popup .close_popup");

    // ================= CONSTRUCTOR =================

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

//    // ================= SHIPPING =================
//
//    public void selectBestShippingMethod() {
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(shippingRadios));
//
//        List<WebElement> groundOptions = driver.findElements(groundShippingRadios);
//
//        if (!groundOptions.isEmpty()) {
//
//            for (int i = 0; i < groundOptions.size(); i++) {
//
//                List<WebElement> freshGround = driver.findElements(groundShippingRadios);
//                WebElement radio = freshGround.get(i);
//
//                if (!radio.isSelected()) {
//                    js.executeScript("arguments[0].click();", radio);
//                    wait.until(ExpectedConditions.elementToBeSelected(radio));
//                    System.out.println("Selected Ground shipping for item " + (i + 1));
//                }
//            }
//
//        } else {
//            System.out.println("Ground shipping not available. Selecting fallback.");
//            selectFirstAvailableShipping();
//        }
//    }
//
    private void selectFirstAvailableShipping() {

        List<WebElement> allOptions = driver.findElements(fallbackShipping);

        if (!allOptions.isEmpty()) {
            js.executeScript("arguments[0].click();", allOptions.get(0));
            System.out.println("Fallback shipping selected.");
        } else {
            throw new RuntimeException("No shipping methods available.");
        }
    }
    public void selectBestShippingMethod() {

        wait.until(ExpectedConditions.presenceOfElementLocated(shippingRadios));

        // ALWAYS wait 2 seconds after shipping section appears
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<WebElement> groundOptions = driver.findElements(groundShippingRadios);

        if (!groundOptions.isEmpty()) {

            for (int i = 0; i < groundOptions.size(); i++) {

                List<WebElement> freshGround = driver.findElements(groundShippingRadios);
                WebElement radio = freshGround.get(i);

                if (!radio.isSelected()) {
                    js.executeScript("arguments[0].click();", radio);
                    wait.until(ExpectedConditions.elementToBeSelected(radio));
                    System.out.println("Selected Ground shipping for item " + (i + 1));
                }
            }

        } else {
            System.out.println("Ground shipping not available. Selecting fallback.");
            selectFirstAvailableShipping();
        }
    }
    
    // ================= CHECKOUT FLOW =================

    public void completeCheckoutFlow() {

        System.out.println("----- Starting Checkout Flow -----");

        clickSaveAndContinue();
       // handleCouponPopupIfPresent();
      //  selectPayAfterApproval();
        selectPayAfterApproval();
       // selectCardPayment();
        clickPlaceOrder();
        System.out.println("----- Checkout Flow Completed -----");
    }
//    private void clickSaveAndContinue() {
//
//        By saveAndContinue = By.id("button-shipping");
//
//        try {
//            Thread.sleep(6000);  // ALWAYS waits 2 seconds before
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        WebElement button = wait.until(
//                ExpectedConditions.elementToBeClickable(saveAndContinue));
//
//        js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);
//        js.executeScript("arguments[0].click();", button);
//
//        System.out.println("Save & Continue clicked.");
//
//        try {
//            Thread.sleep(6000);  // ALWAYS waits 2 seconds after
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(paymentCards));
//
//        System.out.println("Payment section loaded.");
//    }
//    private void clickSaveAndContinue() {
//
//        By saveAndContinue = By.id("button-shipping");
//
//        try {
//            Thread.sleep(2000);  // 2 sec BEFORE clicking
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        WebElement button = wait.until(
//                ExpectedConditions.elementToBeClickable(saveAndContinue));
//
//        js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);
//        js.executeScript("arguments[0].click();", button);
//
//        System.out.println("Save & Continue clicked.");
//
//        try {
//            Thread.sleep(2000);  // 2 sec AFTER clicking
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(paymentCards));
//
//        System.out.println("Payment section loaded.");
//    }

    private void clickSaveAndContinue() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(saveAndContinueBtn));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);
        js.executeScript("arguments[0].click();", button);

        wait.until(ExpectedConditions.presenceOfElementLocated(paymentCards));

        System.out.println("Save & Continue clicked. Payment section loaded.");
    }
    private void selectPayAfterApproval() {

        System.out.println("Waiting for Pay After label...");

        By payAfterLabel = By.cssSelector("label[for='cod']");
        By payAfterRadio = By.id("cod");

        WebElement label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(payAfterLabel));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", label);

        WebElement oldRadio = driver.findElement(payAfterRadio);

        // First click
        js.executeScript("arguments[0].click();", label);
        System.out.println("First click done.");

        try {
            // Wait max 3 sec to see if it becomes stale
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.stalenessOf(oldRadio));

            System.out.println("DOM re-render detected.");

        } catch (Exception e) {
            System.out.println("No DOM re-render detected. Continuing...");
        }

        // Re-locate fresh elements always
        label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(payAfterLabel));

        js.executeScript("arguments[0].click();", label);
        System.out.println("Second click done.");

        wait.until(driver ->
                (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return document.getElementById('cod').checked;")
        );

        System.out.println("Pay after Approval selected successfully.");
    }
//    private void selectPayAfterApproval() {
//
//        System.out.println("Waiting for Pay After label...");
//
//        By payAfterLabel = By.cssSelector("label[for='cod']");
//        By payAfterRadio = By.id("cod");
//
//        WebElement label = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(payAfterLabel));
//
//        js.executeScript("arguments[0].scrollIntoView({block:'center'});", label);
//
//        // First click
//        js.executeScript("arguments[0].click();", label);
//        System.out.println("First click done.");
//
//        // 🔥 Wait for DOM to refresh by waiting for staleness
//        wait.until(ExpectedConditions.stalenessOf(
//                driver.findElement(payAfterRadio)));
//
//        // Re-locate after re-render
//        label = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(payAfterLabel));
//
//        js.executeScript("arguments[0].click();", label);
//        System.out.println("Second click done.");
//
//        // Now wait until new radio becomes selected
//        wait.until(driver -> 
//            (Boolean) ((JavascriptExecutor) driver)
//                .executeScript("return document.getElementById('cod').checked;")
//        );
//
//        System.out.println("Pay after Approval selected successfully.");
//    }
//    public void clickPlaceOrder() {
//
//        By placeOrder = By.id("button-confirm");
//
//        WebElement button = wait.until(
//                ExpectedConditions.elementToBeClickable(placeOrder));
//
//        js.executeScript("arguments[0].click();", button);
//
//        System.out.println("Place Order clicked. Waiting for success page...");
//
//        wait.until(ExpectedConditions.urlContains("checkout/success"));
//
//        System.out.println("Success page loaded.");
//    }
//    public void clickPlaceOrder() {
//
//        By placeOrder = By.id("button-confirm");
//
//        WebElement button = wait.until(
//                ExpectedConditions.elementToBeClickable(placeOrder));
//
//        js.executeScript("arguments[0].click();", button);
//        System.out.println("Current URL: " + driver.getCurrentUrl());
//        System.out.println("Place Order clicked. Waiting for success page...");
//
//        // Wait for success page element (change locator accordingly)
//        By successHeader = By.xpath("//h1[contains(text(),'Your Order')]");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader));
//
//        System.out.println("Order success page loaded.");
//    }
//    public void clickPlaceOrder() {
//
//        By placeOrder = By.id("button-confirm");
//
//        try {
//            Thread.sleep(1000);  // 1 second delay for testing
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        driver.findElement(placeOrder).click();
//
//        System.out.println("Place Order clicked after 1 sec delay.");
//    }
    public void clickPlaceOrder() {

        By placeOrder = By.id("button-confirm");

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(placeOrder));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        js.executeScript("arguments[0].click();", button);

        System.out.println("Place Order clicked.");
    }
//    public void clickPlaceOrder()
//    {
//        By placeOrder = By.id("button-confirm");
//        driver.findElement(placeOrder).click();
//    }
    
    // ================= POPUP HANDLER =================

//    private void handleCouponPopupIfPresent() {
//
//        By popupOuter = By.id("coupon_popup_outer");
//        By closeBtn = By.cssSelector("#coupon_popup_outer .close_popup");
//
//        try {
//
//            List<WebElement> popupList = driver.findElements(popupOuter);
//
//            if (!popupList.isEmpty() && popupList.get(0).isDisplayed()) {
//
//                System.out.println("⚠ Coupon popup is visible and blocking UI.");
//
//                WebElement close = wait.until(
//                        ExpectedConditions.elementToBeClickable(closeBtn));
//
//                js.executeScript("arguments[0].click();", close);
//
//                // Wait until popup disappears completely
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(popupOuter));
//
//                System.out.println("✅ Coupon popup closed successfully.");
//
//            } else {
//                System.out.println("No coupon popup blocking checkout.");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Popup not present or already closed.");
//        }
//    }
}