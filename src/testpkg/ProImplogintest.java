package testpkg;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagepkg.CartTextFinderPage;
import pagepkg.ProImploginPage;
import pagepkg.QuickContactPage;
import pagepkg.SearchPage;
import pagepkg.SignUpPage;

public class ProImplogintest extends BaseClass {

//    @Test(priority = 0)
//    public void loginTest() {
//
//        ProImploginPage ob = new ProImploginPage(driver);
//        ob.setValues("joel.j@sbsol.in", "d67ad174bf");
//        ob.login();
//    }

//    @Test(priority = 2)
//    public void cartTest() {
//
//        CartTextFinderPage cart = new CartTextFinderPage(driver);
//
//        cart.clickUploadArt();
//
//        String pageSrc = cart.textVerification();
//
//        Assert.assertTrue(pageSrc.contains("Update"),
//                "Title comparison failed");
//    }
//    @Test(priority = 1)
//    public void searchTest() {
//
//        SearchPage search = new SearchPage(driver);
//        search.searchProduct("PI22906");
//
//    }
//    @Test(priority = 3)
//    public void contactUS() {
//
//        QuickContactPage contact = new QuickContactPage(driver);
//
//        contact.scrollToFooter();
//        contact.fillQuickContact(
//                "joel",
//                "9876543210",
//                "joel.j@sbsol.in",
//                "Automation testing message"
//        );
//    }
//    
	@Test(priority = 1)
	public void signUp() {

	    SignUpPage signup = new SignUpPage(driver);

	    signup.clickPopupSignUp();   // 🔥 FIRST CLICK POPUP BUTTON

	    String uniqueEmail = "joel" + System.currentTimeMillis() + "@sbsol.in";
	    String altEmail = "alt" + System.currentTimeMillis() + "@sbsol.in";

	    signup.registerUser(
	            "Joel",
	            "Tester",
	            uniqueEmail,
	            altEmail,
	            "9876543210",
	            "9123456780",
	            "04842556677",
	            "Test@123",
	            "Test@123"
	    );

	    Assert.assertTrue(driver.getCurrentUrl().contains("account"),
	            "Sign up failed - user not redirected");
	}



    
}
