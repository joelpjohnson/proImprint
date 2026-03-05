package pages.user;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class CheckoutSuccessPage extends BaseClass {

    WebDriver driver;
    WebDriverWait wait;

    By orderIdText = By.cssSelector("span.feedbackorder");

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getOrderId() {

        WebElement orderElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(orderIdText));

        String orderText = orderElement.getText();

        String orderId = orderText.replace("Order No:", "").trim();

        System.out.println("Captured Order ID: " + orderId);

        return orderId;
    }
}