package kanchanaacademy.Tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kanchanaacademy.TestComponents.BaseTest;
import kanchanaacademy.pageobject.CartPage;
import kanchanaacademy.pageobject.CheckoutPage;
import kanchanaacademy.pageobject.ConfirmationPage;
import kanchanaacademy.pageobject.OrderPage;
import kanchanaacademy.pageobject.ProductCatalogue;

public class SubmitOrderTest extends BaseTest
{
	String productName = "qwerty";

	@Test(dataProvider = "getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> datas) throws IOException, InterruptedException {
		
		
	
		ProductCatalogue productCatalogue = landingpage.loginApplication(datas.get("email"), datas.get("password"));
	  	List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(datas.get("product"));
		
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.VerifyProductDisplay(datas.get("product"));

		Assert.assertTrue(match);
		CheckoutPage checkOutPage = cartPage.goToCheckOut();

		checkOutPage.selectCountry("thai");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String confirmMess = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMess.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		System.out.println("hellow");
		//insert close
		
		//orders
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		driver.manage().window().maximize();
//
//		LandingPage landingpage = new LandingPage(driver);
//		landingpage.goTo();	
// 		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
// 		List<WebElement> products = productCatalogue.getProductList();
//		driver.findElement(By.id("userEmail")).sendKeys(email);
//		driver.findElement(By.id("userPassword")).sendKeys(password);
//		driver.findElement(By.id("login")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

//		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));

//		WebElement prod	=products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
//		.findFirst().orElse(null);
//		
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		// ng-animating

//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

// 		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

// 		CartPage cartPage = new CartPage(driver);

//	  	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));	
//	  	boolean match=	cartProducts.stream().anyMatch(c->c.getText().equalsIgnoreCase(productName));
//	  	driver.findElement(By.cssSelector(".totalRow button")).click();

		// a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select
		// Country']")), "tha").build().perform();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		// driver.findElement(By.xpath("//button[@type='button'][1]")).click();

		// driver.findElement(By.cssSelector(".action__submit")).click();

		// String confirmMess=
		// driver.findElement(By.cssSelector(".hero-primary")).getText();

		// driver.close();
	}
	
	//To verify Zara coat 3 is display in orders page
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
		
		//qwerty
		
		String email = "anshika@gmail.com";
		String password = "Iamking@000";

		ProductCatalogue productCatalogue = landingpage.loginApplication(email, password);
		OrderPage ordersPage=  productCatalogue.goToOrderHistory();
		
		Assert.assertTrue(ordersPage.VerifyProductDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
			
	List<HashMap<String, String>> data =	getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\kanchanaacademy\\data\\PurchaseOrder.json");
		
		return	 new Object[][] {{data.get(0)},{data.get(1)}};
	}
	

	
	
//	@DataProvider 2
//	public Object[][] getData(){
//	
//		HashMap<String, String> map = new HashMap<String,String>();
//		map.put("email", "anshika@gmail.com");
//		map.put("password", "Iamking@000");
//		map.put("product", "QWERTY");
//		
//		HashMap<String, String> map1 = new HashMap<String,String>();
//
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "IPHONE 13 PRO");
//		
//	return	 new Object[][] {{map},{map1}};
//		
//	}
	
	
	
	//scan data in file json
	
	
//	@DataProvider 1
//	public Object[][] getData(){
//	
//		
//	return	 new Object[][] {{"anshika@gmail.com","Iamking@000","QWERTY"},{"shetty@gmail.com","Iamking@000","IPHONE 13 PRO"}};
//		
//	}
}
