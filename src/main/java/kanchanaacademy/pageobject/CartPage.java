package kanchanaacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import kanchanaacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent
{
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public CheckoutPage goToCheckOut() {
		
		checkoutEle.click();
		
		return new CheckoutPage(driver);

	}
	
	
	public boolean VerifyProductDisplay(String productName) {
		
		
		return cartProducts.stream().anyMatch(c->c.getText().equalsIgnoreCase(productName));
		
	}


	
//	 List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		
//	  boolean match=	cartProducts.stream().anyMatch(c->c.getText().equalsIgnoreCase(productName));
//		
//	  Assert.assertTrue(match);


	
	

	
	
	

}
