package selenium.Actionselenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assignment {

	@Test
	public  void  assignme(){
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://only-testing-blog.blogspot.com/2014/09/selectable.html");
		Actions a= new  Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		a.doubleClick(driver.findElement(By.cssSelector("[ondblclick='myFunction()']"))).build().perform();
		driver.switchTo().alert().accept();
		
		driver.close();
	}
}
