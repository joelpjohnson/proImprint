package pages.admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminOrderPage {

    WebDriver driver;
    WebDriverWait wait;

    public AdminOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    By searchField = By.name("filters_order_id");
    
    
    
    public void searchAndOpenOrder(String orderId) {

        // Wait for search field
        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchField));

        // Enter order ID
        search.clear();
        search.sendKeys(orderId);
        search.sendKeys(Keys.ENTER);

        System.out.println("Searching order in admin: " + orderId);

        // Wait for result row
        By orderLink = By.xpath("//a[contains(@href,'order_id=" + orderId + "')]");

        WebElement order = wait.until(
                ExpectedConditions.visibilityOfElementLocated(orderLink));

        // Scroll to the element
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", order);

        // Small wait for admin table rendering
        try { Thread.sleep(1200); } catch (InterruptedException e) {}

        // JS click (avoids tooltip overlay issues)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", order);

        System.out.println("Order opened in admin: " + orderId);
    }

    // ================= SEARCH ORDER =================
    public void searchOrder(String orderId) {

        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchField));

        search.clear();
        search.sendKeys(orderId);
        search.sendKeys(Keys.ENTER);

        // wait until the order appears in the table
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href,'order_id=" + orderId + "')]")));

        System.out.println("Order searched in admin: " + orderId);
    }
    //===========open order==============
    public void openOrder(String orderId) {

        By orderLink = By.xpath("//a[contains(@href,'order_id=" + orderId + "') and contains(text(),'" + orderId + "')]");

        WebElement order = wait.until(
                ExpectedConditions.elementToBeClickable(orderLink));

        System.out.println("Current URL before click: " + driver.getCurrentUrl());

        // Scroll to element
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", order);

        // Click the order
        order.click();

        // Wait for order page
        wait.until(ExpectedConditions.urlContains("route=sale/order/update"));

        System.out.println("Current URL after click: " + driver.getCurrentUrl());
    }
 // ================= OPEN ORDER HISTORY TAB =================
    public void openOrderHistory() {

        By orderHistoryTab = By.id("order_his");

        WebElement tab = wait.until(
                ExpectedConditions.elementToBeClickable(orderHistoryTab));

        tab.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("tab-orderhis")));

        System.out.println("Order History tab opened");
    }
 // ================= UPLOAD ARTWORK PROOFS =================
    public void uploadArtworkProofs(int productCount, String approveFile, String rejectFile) {

        int defaultDropdowns = productCount;
        int requiredDropdowns = productCount * 2;
        int addMoreClicks = requiredDropdowns - defaultDropdowns;

        By addMoreBtn = By.xpath("//input[@value='Add More']");

        // Add required dropdowns
        for (int i = 1; i <= addMoreClicks; i++) {

            WebElement addMore = wait.until(
                    ExpectedConditions.elementToBeClickable(addMoreBtn));

            addMore.click();

            System.out.println("Clicked Add More to create extra slot " + (defaultDropdowns + i));
        }

        // Now upload files
        for (int i = 1; i <= requiredDropdowns; i++) {

            // Select dropdown
            By dropdownLocator = By.id("productassign" + i);

            WebElement dropdown = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(dropdownLocator));

            Select select = new Select(dropdown);

            // Determine product number
            int productIndex = (i % productCount == 0) ? productCount : (i % productCount);

            select.selectByIndex(productIndex);

            System.out.println("Product selected in dropdown " + i);

            // Wait for file upload field
            By fileLocator = By.id("artwork_proof" + i);

            WebElement upload = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(fileLocator));

            // mandatory wait (as you required)
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Upload correct file
            if (i % 2 != 0) {

                upload.sendKeys(approveFile);
                System.out.println("Approval file uploaded in slot " + i);

            } else {

                upload.sendKeys(rejectFile);
                System.out.println("Rejection file uploaded in slot " + i);
            }
        }
    }
 // ================= UPLOAD ARTWORK PROOFS =================
//    public void uploadArtworkProofs(int productCount, String approveFile, String rejectFile) {
//
//        for (int i = 1; i <= productCount; i++) {
//
//            // Select product dropdown
//            By dropdownLocator = By.id("productassign" + i);
//
//            WebElement dropdown = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
//
//            Select select = new Select(dropdown);
//
//            select.selectByIndex(1);
//
//            System.out.println("Product selected in dropdown " + i);
//
//            // Wait for file upload input to appear
//            By fileLocator = By.id("artwork_proof" + i);
//
//            WebElement upload = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(fileLocator));
//
//            // 🔵 ALWAYS wait 2 seconds after it becomes visible
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            // Upload approval file
//            upload.sendKeys(approveFile);
//
//            System.out.println("Approval file uploaded for product " + i);
//
//            // Select again for rejection
//            select.selectByIndex(1);
//
//            upload = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(fileLocator));
//
//            // 🔵 Again wait 2 seconds
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            // Upload rejection file
//            upload.sendKeys(rejectFile);
//
//            System.out.println("Rejection file uploaded for product " + i);
//        }
//    }
}