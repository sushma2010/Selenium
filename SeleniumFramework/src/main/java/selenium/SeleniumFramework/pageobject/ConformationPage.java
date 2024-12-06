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


public class ConformationPage extends AbsractComponent{
	
	
	 WebDriver driver;
	 
	public  ConformationPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
   
    
    @FindBy(css=".hero-primary")
    WebElement confmsg;
    
	 
    public String getconfmessage() {
    	return confmsg.getText();
    	
    	
    	 
    }

	
	
}
