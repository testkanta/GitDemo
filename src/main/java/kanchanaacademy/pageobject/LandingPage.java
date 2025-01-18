package kanchanaacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kanchanaacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent
{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//PageFactory
	//WebElement userEmails =	driver.findElement(By.id("userEmail"));

	 // ใช้ @FindBy ระบุ locator ของ WebElement
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPasswordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMsg;
	
	public ProductCatalogue loginApplication(String email,String password) {
		
		userEmail.sendKeys(email);
		userPasswordEle.sendKeys(password);
		submit.click();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);

		return productCatalogue;
		
	}
	
	public String getErrorMessage() {
		
		waitForElementToAppear(errorMsg);
		return errorMsg.getText();
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

	
	
	

}
