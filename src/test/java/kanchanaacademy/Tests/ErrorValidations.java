package kanchanaacademy.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import kanchanaacademy.TestComponents.BaseTest;
import kanchanaacademy.TestComponents.Retry;
import kanchanaacademy.pageobject.CartPage;
import kanchanaacademy.pageobject.ProductCatalogue;


public class ErrorValidations extends BaseTest
{

	
	
	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void loginErrorValidataion() throws IOException, InterruptedException 
	{
		
		
		String email = "anshika@gmail.com";
		String password = "Iamki0000";	
		landingpage.loginApplication(email, password);
		
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException {
		
		String productName = "qwerty";
		String email = "anshika@gmail.com";
		String password = "Iamking@000";	
		
		ProductCatalogue productCatalogue = landingpage.loginApplication(email, password);
		productCatalogue.addProductToCart(productName);
		
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.VerifyProductDisplay("qwerty3");

		Assert.assertFalse(match);
		
		
	}

	@Test
	public void CheckAllError()  {
		
			
		System.out.println("Hello i am team x");
		System.out.println("I'm test from Thai");

		
		
	}

}
