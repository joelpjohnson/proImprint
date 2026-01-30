package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
public class FbloginPage {

	  By emailField = By.id("login_mail");
	  By passwordField =By.id("login_password");
	  By loginButton = By.id("login_guestproceed");
WebDriver driver;//this is an instance variable 
//driver details has to be initialzed in it using constructor 
//class name and constructor name should be the same
public FbloginPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	
}
public void setValues (String email ,String password)
{
	  driver.findElement(emailField).sendKeys(email);
      driver.findElement(passwordField).sendKeys(password);
}

public void login()
{
	 driver.findElement(loginButton).click(); 
}

}
