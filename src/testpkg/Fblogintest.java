package testpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.FbloginPage;

public class Fblogintest {
	WebDriver driver;
	@BeforeTest 
	public void setUp()
	{
		driver =new ChromeDriver ();
		driver.get("https://www.proimprint.com/");
		   driver.findElement(By.xpath("//b[normalize-space()='Sign in']")).click();
	}
	
	@Test 
	public void test()
	{
		FbloginPage ob=new FbloginPage(driver) ;
		ob.setValues("joel.j@sbsol.in", "43fd312d89");
		ob.login();
		
	}

}
