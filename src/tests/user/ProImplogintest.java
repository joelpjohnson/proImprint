package tests.user;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.user.CartTextFinderPage;
import pages.user.CheckoutPage;
import pages.user.CheckoutSuccessPage;
import pages.user.ProImploginPage;
import pages.user.ProductPage;
import pages.user.QuickContactPage;
import pages.user.SearchPage;
import pages.user.SignUpPage;
import utils.OrderDataManager;
import utils.TestDataStore;

public class ProImplogintest extends BaseClass  {

  

	@Test(priority=0)
	public void loginTest() {

	    driver.get("https://www.proimprint.com/");
	    driver.findElement(By.xpath("//b[normalize-space()='Sign in']")).click();
	    ProImploginPage ob = new ProImploginPage(driver);
	    ob.setValues("joel.j@sbsol.in", "d67ad174bf");
	    ob.login();
	}
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
	@Test(priority = 1)
	public void searchTest() {

	    Scanner scanner = new Scanner(System.in);

	    String defaultProduct = "PI22906";
	    String productToSearch = defaultProduct;

	    System.out.println("Do you wish to search for any particular product?");
	    System.out.println("Press Y to enter product ID OR N to continue with default product (PI22906)");

	    String choice = scanner.nextLine().trim().toUpperCase();

	    if (choice.equals("Y")) {
	        System.out.println("Enter Product ID:");
	        productToSearch = scanner.nextLine().trim();
	    }

	    SearchPage search = new SearchPage(driver);
	    search.searchProduct(productToSearch);

	    System.out.println("Product searched: " + productToSearch);
	}
    @Test(priority = 2)
    public void productSelectionTest() {

        ProductPage product = new ProductPage(driver);

        product.selectColor();
        product.selectImprintColor("Yellow 116");
        product.enterQuantity("101");
        product.clickAddToCart();
        product.clickProceedToCheckout();
    }
    @Test(priority = 3)
    public void shippingSelectionTest() {

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.selectBestShippingMethod();
    //  checkout.clickSaveAndContinueAndSelectPayAfter();
      checkout.completeCheckoutFlow();
      //  checkout.clickSaveAndContinueRobust();
       // checkout.selectPayAfterArtwork();
      //  checkout.selectPayAfterApprovalOfArtwork();
    }
    @Test(priority=4)
    public void CheckoutSuccessPage() {

        CheckoutSuccessPage success = new CheckoutSuccessPage(driver);

        String orderId = success.getOrderId();

        OrderDataManager.saveOrderId(orderId);

        System.out.println("Order ID saved: " + orderId);
    }
//    @Test(priority = 1, dependsOnMethods = "loginTest")
//    public void searchTest() {
//
//        SearchPage search = new SearchPage(driver);
//        search.searchProduct("PI22906");
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
//	@Test(priority = 1)
//	public void signUp() {
//
//	    SignUpPage signup = new SignUpPage(driver);
//
//	    signup.clickPopupSignUp();   // 🔥 FIRST CLICK POPUP BUTTON
//
//	    String uniqueEmail = "joel" + System.currentTimeMillis() + "@sbsol.in";
//	    String altEmail = "alt" + System.currentTimeMillis() + "@sbsol.in";
//
//	    signup.registerUser(
//	            "Joel",
//	            "Tester",
//	            uniqueEmail,
//	            altEmail,
//	            "9876543210",
//	            "9123456780",
//	            "04842556677",
//	            "Test@123",
//	            "Test@123"
//	    );
//
//	    Assert.assertTrue(driver.getCurrentUrl().contains("account"),
//	            "Sign up failed - user not redirected");
//	}



    
}
