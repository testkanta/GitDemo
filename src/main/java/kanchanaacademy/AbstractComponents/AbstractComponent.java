package kanchanaacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kanchanaacademy.pageobject.CartPage;
import kanchanaacademy.pageobject.OrderPage;

public class AbstractComponent
{
	WebDriver driver;

	public AbstractComponent(WebDriver driver)
	{

		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy) {
		
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	

	
	public void waitForElementToAppear(WebElement findBy) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public CartPage goToCartPage() {
		

		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		
		return cartPage;
		
	}
	
	public OrderPage goToOrderHistory() {
		

		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		
		return orderPage;
		
	}
	
	public void waitForElementToDisappear() throws InterruptedException {
		
		Thread.sleep(1000);
		//4 seconds Application
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		
//		wait.until(ExpectedConditions.invisibilityOf(webelement));

	}
	
}
