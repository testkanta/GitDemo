package kanchanaacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kanchanaacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent
{
	
	WebDriver driver;
	
	 public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	  
	@FindBy(css = "[placeholder='Select Country']")
	private WebElement inputCountry;
	
	@FindBy(xpath = "//button[@type='button'][1]")
	private WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	private WebElement submit;
	
	private By result = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(inputCountry,countryName).build().perform();
		waitForElementToAppear(result);
		selectCountry.click();
	
	}
	
	public ConfirmationPage submitOrder() {
		
		submit.click();
		
	return	new ConfirmationPage(driver);
	}
	
	

}
