package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartTextFinderPage {
	WebDriver driver;
	@FindBy(xpath="//a[contains(@class,'update') and normalize-space()='Update']")
	WebElement uploadArt;
	
	
	
	public CartTextFinderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements( driver,this );//to get element details after initializing 
	}
	
	//public void clickUploadArt(){
	//	uploadArt.click();
	//	System.out.println("uploadArt page ");
		
	//}
	public void clickUploadArt() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	    wait.until(ExpectedConditions.elementToBeClickable(uploadArt));
	    uploadArt.click();
	    System.out.println("uploadArt page");
	}
	
	public String  textVerification() {// to check if a text is present or not 
	String src=	driver.getPageSource();//we get return string 
	
	System.out.println("textVerification page");

	return src;

	
	}

}
