package selenium.SeleniumFramework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.SeleniumFramework.AbstractComponents.AbsractComponent;


public class LandingPage extends AbsractComponent{
	
	
	 WebDriver driver;
	 
	public  LandingPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
    @FindBy(id="userEmail")
    WebElement userEmail;
    
    @FindBy(id="userPassword")
    WebElement passwardEle;
    
    @FindBy(id="login")
    WebElement submit;
    
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMesssage;
    
    public  ProductCatalog loginApplication (String email,String passward) {
    	userEmail.sendKeys(email);
    	passwardEle.sendKeys(passward);
    	submit.click();
    	ProductCatalog ProductCatalog= new ProductCatalog(driver);
   return ProductCatalog;
    }
    
    public String geterrormessage() {
    	waitForElementToWebEleAppear(errorMesssage);
    	return errorMesssage.getText();
    }
    public void goTo() {
    	driver.get("https://rahulshettyacademy.com/client/");
    }
    
}
