package kanchanaacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import kanchanaacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent
{
	
	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));

	 // ใช้ @FindBy ระบุ locator ของ WebElement
	@FindBy(css=".mb-3")
	List<WebElement> productList;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsgWait = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		
	
		waitForElementToAppear(productBy);
		return productList;
		
	}
	
//	WebElement prod	=products.stream().filter(product->
//	product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
//	.findFirst().orElse(null);
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod	=productList.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
		.findFirst().orElse(null);
	
		return prod;
	}
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

	public void addProductToCart(String productName) throws InterruptedException {
		
	
		WebElement prod =	getProductByName(productName);
	
		prod.findElement(addToCart).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waitForElementToAppear(toastMsgWait);

		waitForElementToDisappear();
		
	}
	

	
	

	
	
	

}
