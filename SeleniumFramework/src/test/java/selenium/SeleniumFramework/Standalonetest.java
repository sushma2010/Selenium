package selenium.SeleniumFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import selenium.SeleniumFramework.TestComponent.BaseTest;
import selenium.SeleniumFramework.pageobject.CartPage;
import selenium.SeleniumFramework.pageobject.ConformationPage;
import selenium.SeleniumFramework.pageobject.LandingPage;
import selenium.SeleniumFramework.pageobject.ProductCatalog;
import selenium.SeleniumFramework.pageobject.checkOutPage;

public class Standalonetest extends BaseTest{	
	private WebDriver driver;
	@Test(dataProvider= "getdata")
	public void submitorder(HashMap<String ,String> input) throws IOException, InterruptedException  {
	
		ProductCatalog productCatalog= landingPage.loginApplication(input.get("email"), input.get("password"));
		
		//String productName="ZARA COAT 3";
		String CountryName="India";
		
		productCatalog.addProductToCart(input.get("product"));
		CartPage CartPage= productCatalog.GoToCartPage();
		
		Thread.sleep(2000);
		Boolean match= CartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CartPage.zoomOutBrowser();
		checkOutPage checkOutPage= CartPage.GoToCheckout();
	
		
		checkOutPage.Selectcountry(CountryName);
		ConformationPage ConformationPage=checkOutPage.SubmitOrder();
		Thread.sleep(500);
		String conformmessage=ConformationPage.getconfmessage();

	
	Assert.assertTrue(conformmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
	@DataProvider
	public Object[][] getdata() throws IOException {
		List<HashMap<String, String>> data= getJsonDatatoMap(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\SeleniumFramework\\data\\PurchaseOrder.json");
		return new Object[][] { {data.get(0)}};
	}

}
