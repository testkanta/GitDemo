package kanchanaacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kanchanaacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent
{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmmationMessage;
	
	public String verifyConfirmationMessage() {
		
		
		
	  return confirmmationMessage.getText();
	}
	
	 // String confirmMess=   driver.findElement(By.cssSelector(".hero-primary")).getText();

}
