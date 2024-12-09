package selenium.SeleniumFramework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import selenium.SeleniumFramework.AbstractComponents.AbsractComponent;


public class CartPage extends AbsractComponent{
	
	
	 WebDriver driver;
	 
	public  CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
    @FindBy(css=".cartSection h3")
    List<WebElement> cartproducts;
    
    @FindBy(css=".totalRow button")
    WebElement submit;

	public  Boolean VerifyProductDisplay(String productName) {
		
		Boolean match= cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
    public checkOutPage GoToCheckout() {
    	submit.click();
    	checkOutPage checkOutPage =new checkOutPage(driver);
    	return checkOutPage;
    }
	
}
