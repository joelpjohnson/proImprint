package pagepkg;
//this is done using without page factory 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;                                  //the commented code is without page factory
public class ProImprintWithPageFactoryPage {                                  //the non commented is with page factory 
@FindBy(id="login_mail")
WebElement ProImpEmail;
	// By emailField = By.id("login_mail");
@FindBy(id="login_password")
WebElement ProImpPass;
	 // By passwordField =By.id("login_password");
	  
	@FindBy(id="login_guestproceed")
	WebElement ProImpLogin;
	 // By loginButton = By.id("login_guestproceed");
WebDriver driver;//this is an instance variable 
//driver details has to be initialized in it using constructor 
//class name and constructor name should be the same
public ProImprintWithPageFactoryPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements( driver,this );//to get element details after initializing 
}
public void setValues (String email ,String password)
{
	ProImpEmail.sendKeys(email);
	  //driver.findElement(emailField).sendKeys(email);
	ProImpPass.sendKeys(password);
    //  driver.findElement(passwordField).sendKeys(password);
}

public void login()
{
	ProImpLogin.click(); 
	// driver.findElement(loginButton).click(); 
}

}

