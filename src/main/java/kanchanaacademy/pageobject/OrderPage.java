package kanchanaacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kanchanaacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent
{
	WebDriver driver;
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> ProductNames;
	

	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean VerifyProductDisplay(String productName) {
		
		
		return ProductNames.stream().anyMatch(c->c.getText().equalsIgnoreCase(productName));
		
	}

	

}
