package tests.admin;

import org.testng.annotations.Test;
import base.BaseClass;
import pages.admin.AdminLoginPage;

public class AdminLoginTest extends BaseClass {

    @Test
    public void adminLogin() {

        // 🔐 REQUIRED: handle browser authentication FIRST
        handleBasicAuth("admin", "$ecure!t");

        // 🌐 Then open admin URL
        driver.get("https://www.proimprint.com/admin/index.php");

        // 🧾 Then HTML login form
        AdminLoginPage login = new AdminLoginPage(driver);
        login.login("joel.j", "q2Zzods0xm");
    }
}