  package testpkg;
  ///this is done using without page factory 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.CartTextFinderPage;
import pagepkg.ProImprintWithPageFactoryPage;

public class ProImploginWithPageFactorytest  extends BaseClass{

	
	@Test (priority =1)
	public void test()
	{
		ProImprintWithPageFactoryPage ob=new ProImprintWithPageFactoryPage(driver) ;
		ob.setValues("joel.j@sbsol.in", "d67ad174bf");
		ob.login();
		
	}
	@Test (priority =2)
	public void cart() 
	{
		CartTextFinderPage ob= new CartTextFinderPage(driver);
		ob.clickUploadArt();
		
		System.out.print("clickUploadArt test ");
		String pageSrc =ob.textVerification();
		System.out.println("stting compare test ");
		
	//Assert.assertTrue(pageSrc contains ("Update"),"tite compaison failed");
	Assert.assertTrue(pageSrc.contains("Update"), "title comparison failed");

	
	}

}

