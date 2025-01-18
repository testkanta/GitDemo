package kanchanaacademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import kanchanaacademy.pageobject.LandingPage;

public class StandAloneTest
{

	public static void main(String[] args)
	{
		String web = "https://rahulshettyacademy.com/client";
		String productName = "qwerty";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		
		driver.get(web);
		
		String email = "anshika@gmail.com";
		String password = "Iamking@000";
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod	=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
		.findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//ng-animating
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	
	  boolean match=	cartProducts.stream().anyMatch(c->c.getText().equalsIgnoreCase(productName));
		
	  Assert.assertTrue(match);
	  
	  driver.findElement(By.cssSelector(".totalRow button")).click();
	  
	  Actions a = new Actions(driver);
	  
	  a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "tha").build().perform();
		
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	  
	  
	  driver.findElement(By.xpath("//button[@type='button'][1]")).click();
	  
	  driver.findElement(By.cssSelector(".action__submit")).click();
	  

	  String confirmMess=   driver.findElement(By.cssSelector("hero-primary")).getText();
	

	  
	  Assert.assertTrue(confirmMess.equalsIgnoreCase("Thankyou for the order."));
	 // driver.close();
	}

}
