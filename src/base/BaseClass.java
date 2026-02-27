package base;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    protected ChromeDriver driver;

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void handleBasicAuth(String username, String password) {

        ((HasAuthentication) driver).register(
            uri -> uri.getHost().contains("proimprint.com"),
            UsernameAndPassword.of(username, password)
        );
    }

//    @AfterClass
//    public void tearDown() {
//
//        if (driver != null)
//            driver.quit();
//    }
}