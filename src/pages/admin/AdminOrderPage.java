package pages.admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

}