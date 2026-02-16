package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CopyPaste {
	ChromeDriver driver ;
@BeforeTest 
public void setUp() {
	 driver = new ChromeDriver ();
     driver.get("https://www.proimprint.com/"); // replace with your URL
     driver.findElement(By.xpath("//b[normalize-space()='Sign in']")).click();
}
@Test
public void copyPaste() {
	
}

}
