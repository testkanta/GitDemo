package kanchanaacademy.stepDefinittions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kanchanaacademy.TestComponents.BaseTest;
import kanchanaacademy.pageobject.CartPage;
import kanchanaacademy.pageobject.CheckoutPage;
import kanchanaacademy.pageobject.ConfirmationPage;
import kanchanaacademy.pageobject.LandingPage;
import kanchanaacademy.pageobject.ProductCatalogue;
public class StepDefinittionImpl extends BaseTest
{

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
		landingPage =	launchApplication();
		//code 
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_username_and_password(String username,String password) {
		
		
		productCatalogue = landingpage.loginApplication(username,password);	
	}
	
	
	
	  @When("^I add product (.+) to Cart$")
	  public void i_add_product_to_cart(String productName) throws InterruptedException {
		  
		  	//List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
		  
	  }
	  
	  
	  @And("^Checkout (.+) and submit the order$")
	  public void checkout_and_submit_the_order(String productName) {
		  
			CartPage cartPage = productCatalogue.goToCartPage();
			boolean match = cartPage.VerifyProductDisplay(productName);

			Assert.assertTrue(match);
			CheckoutPage checkOutPage = cartPage.goToCheckOut();

			checkOutPage.selectCountry("thai");
			confirmationPage = checkOutPage.submitOrder();
			  
	  }
	  
	  	//ข้อความนี้มีอยู่แล้ว เลยไม่ทำเป็นตัวแปร
	  
	    @When("{string} message is displayed on ConfirmationPage")
	    public void message_displayed_confirmationPage(String string) {
	    
	    	String confirmMess = confirmationPage.verifyConfirmationMessage();
			Assert.assertTrue(confirmMess.equalsIgnoreCase(string));
	    	driver.close();
	    }
	    
		  @And("{string} message is displayed")
		  public void message_is_displayed(String string) {
			  
			Assert.assertEquals(string, landingpage.getErrorMessage());
			driver.close();
				  
		  }
	    
	    
	  
	
}
