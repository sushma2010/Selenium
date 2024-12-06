package basic;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		public WebDriver driver;
		driver= new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\selenium\\Webautomation\\src\\test\\java\\resources\\chromedriver.exe");
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		 String[] itemsNedded= {"Cucumber", "Tomato","Beans"};
			
			List<WebElement> products=  driver.findElements(By.cssSelector(".product-image"));
			int j=0;
			for(int i=0;i<products.size();i++)
			{
				
				String[] name= products.get(i).getText().split("-");
				String formatedname= name[0].trim();
				List itemsNededlist = Arrays.asList(itemsNedded);
				if (itemsNededlist.contains(formatedname))
				{
					driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				}
			j++;
				if(j==products.size()) {
					break;
				}
				
			}
		

	}

}
