package hat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Child {


	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
		Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Java']/parent::div/following-sibling::div[1]/p[2]/a")).click();
        
		
       Thread.sleep(3000);
        driver.quit();
	}


}
