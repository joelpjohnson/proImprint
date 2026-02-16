package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

    @Parameters({"username", "password"})
    @Test
    public void loginTest(String username, String password) {
          
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.proimprint.com/"); // replace with your URL
        driver.findElement(By.xpath("//b[normalize-space()='Sign in']")).click();

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();

        System.out.println("The username used is: " + username);

       // driver.quit();
    }
}
