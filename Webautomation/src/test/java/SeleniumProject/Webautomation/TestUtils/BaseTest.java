package SeleniumProject.Webautomation.TestUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	public WebDriver driver;
	@SuppressWarnings("deprecation")
	@Test
	public void Config() throws InterruptedException {
		 driver= new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\selenium\\Webautomation\\src\\test\\java\\resources\\chromedriver.exe");
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		//----------------cart--------------------------------
		String[] itemsNedded= {"Cucumber", "Tomato","Beans"};
		additems(driver,itemsNedded);
		driver.findElement(By.cssSelector("[alt='Cart']")).click();	
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//--------------------------------checkout-----------------
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		String actaltext =driver.findElement(By.cssSelector(".promoInfo")).getText();;
		Assert.assertEquals(actaltext, "Code applied ..!");
		//https://rahulshettyacademy.com/AutomationPractice/
	}
		
		public static void additems(WebDriver driver,String[]itemsNedded) {
			List<WebElement> products=  driver.findElements(By.cssSelector(".product-name"));
			int j=0;
			for(int i=0;i<products.size();i++)
			{
				
				String[] name= products.get(i).getText().split("-");
				String formatedname= name[0].trim();
				List itemsNededlist = Arrays.asList(itemsNedded);
				if (itemsNededlist.contains(formatedname))
				{
					driver.findElements(By.cssSelector(".product-action")).get(i).click();
					
				j++;
				if(j==itemsNedded.length)
				 {
					break;
				 }
			    }
				
				
				
		  }
		}
		
		
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
