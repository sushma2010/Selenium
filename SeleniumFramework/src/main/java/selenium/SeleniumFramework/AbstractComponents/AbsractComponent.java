package selenium.SeleniumFramework.AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.SeleniumFramework.pageobject.CartPage;

public class AbsractComponent {
	WebDriver driver;

	 @FindBy(css="[routerlink*='cart']")
	    WebElement Cart;
	
	public AbsractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}
	public void zoomOutBrowser() {
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='0.7';"); // Adjust the value as needed
	}

	

	public CartPage GoToCartPage() {
		Cart.click();
		CartPage CartPage= new CartPage(driver);
		return CartPage;
	}
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(18));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
public void waitForElementToWebEleAppear(WebElement findBy) {
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(18));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public void waitForElementToDissappear(WebElement ele) {
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(18));
		wait.until(ExpectedConditions.invisibilityOf(ele));		
	}

}
