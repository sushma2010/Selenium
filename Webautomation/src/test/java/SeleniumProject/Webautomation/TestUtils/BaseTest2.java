package SeleniumProject.Webautomation.TestUtils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class BaseTest2 {
	public WebDriver driver;
	@Test
	public void project2() throws InterruptedException, IOException {
	 driver= new ChromeDriver();
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\selenium\\Webautomation\\src\\test\\java\\resources\\chromedriver.exe");
	 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	Thread.sleep(3000);
	//-----------------staticdropdown---------
	WebElement SaticDown= driver.findElement(By.id("dropdown-class-example"));
	Select dropdown=new Select(SaticDown);
	dropdown.selectByIndex(1);
	//-------------------dinamicdropdown--------------
	driver.findElement(By.id("autocomplete")).sendKeys("Ind");
	List<WebElement> options=  driver.findElements(By.cssSelector("ui-menu-item"));
	options.stream().filter(s->s.getText().equalsIgnoreCase("India")).peek(s->s.click());
	
	//---------------------------alert--------
	driver.findElement(By.name("enter-name")).sendKeys("Sushma");
	driver.findElement(By.id("alertbtn")).click();
	driver.switchTo().alert().accept();
	//--------------window---------
	driver.findElement(By.cssSelector("#openwindow")).click();
	Set<String>tab= driver.getWindowHandles();
	Iterator<String>it= tab.iterator();
	String parentid= it.next();
	String childid= it.next();
	driver.switchTo().window(childid);
	String mailid= driver.findElement(By.xpath("//div[@class='support float-left']/div[2]/span")).getText();
	Assert.assertEquals(mailid, "info@qaclickacademy.com");
	driver.switchTo().window(parentid);
	//--------------------mouseover--//
	WebElement mouse=driver.findElement(By.cssSelector("#mousehover"));
	Actions actions = new Actions(driver);
	actions.moveToElement(mouse).build().perform();
	driver.findElement(By.xpath("//a[contains(text(),'Top')]")).isDisplayed();
	//-----------scroll-----------
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500);");
	js.executeScript("document.querySelector('.tableFixHead').scrollTop=500;");
	List<WebElement> value= driver.findElements(By.xpath("//div[contains(@class, 'tableFixHead')]//td[4]"));
	
	int sum = value.stream()
            .mapToInt(element -> Integer.parseInt(element.getText())) // Convert each WebElement's text to an integer
            .sum();
	
	int totalamontDisplayed= Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	Assert.assertEquals(totalamontDisplayed, sum );
	//////////////////tabletext///
	System.out.println(driver.findElements(By.cssSelector(".table-display tbody tr")).size());
	System.out.println(driver.findElements(By.cssSelector(".table-display tbody tr th")).size());
	List<WebElement> texts= driver.findElements(By.cssSelector(".table-display tbody tr:nth-child(3) td"));
	
	
	for (int i=0;i<texts.size();i++) {
		System.out.println(texts.get(i).getText());
	}
	//------------screenshot
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("C:\\Users\\User\\Desktop\\sushma.png"));
	///---------link is broken or not & soft asserstion--
	List<WebElement> links= driver.findElements(By.cssSelector(".gf-li a"));
	SoftAssert a = new SoftAssert();
	
	for(WebElement link: links) {
		String url= link.getAttribute("href");
	HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responcecode= conn.getResponseCode();
		//a.assertTrue(responcecode<400, "linked withbroken "+link.getText()+responcecode);	
	}
	
	a.assertAll();
	driver.quit();
	
	}}
