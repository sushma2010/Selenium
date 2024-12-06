package selenium.SeleniumFramework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import selenium.SeleniumFramework.AbstractComponents.AbsractComponent;


public class checkOutPage extends AbsractComponent{
	
	
	 WebDriver driver;
	 
	public  checkOutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
    @FindBy(css="[placeholder='Select Country']")
    WebElement Country;
    
    @FindBy(css=".action__submit")
    WebElement submit;
    
    @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement SelectCountry;
	 
    public void Selectcountry(String CountryName) {
    	Actions a=  new Actions(driver);
    	a.sendKeys(Country, CountryName).build().perform();
    	waitForElementToAppear(By.cssSelector(".ta-results"));
    	 SelectCountry.click();
    	 
    }

	public ConformationPage SubmitOrder() {
		submit.click();
		ConformationPage ConformationPage = new ConformationPage(driver);
		return ConformationPage;
	}
	
}
