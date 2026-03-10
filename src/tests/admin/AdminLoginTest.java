package tests.admin;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.admin.AdminLoginPage;
import pages.admin.AdminOrderPage;
import utils.OrderDataManager;

public class AdminLoginTest extends BaseClass {

    @Test(priority = 1)
    public void adminLogin() {

        handleBasicAuth("admin", "$ecure!t");

        driver.get("https://www.proimprint.com/admin/index.php");

        AdminLoginPage login = new AdminLoginPage(driver);
        login.login("joel.j", "q2Zzods0xm");

        System.out.println("Admin login successful");
    }

    @Test(priority = 2, dependsOnMethods = "adminLogin")
    public void searchAndOpenOrder() {

        String orderId = OrderDataManager.getOrderId();

        AdminOrderPage orderPage = new AdminOrderPage(driver);

        orderPage.searchOrder(orderId);

        orderPage.openOrder(orderId);

        System.out.println("Order opened in admin: " + orderId);
    }
}