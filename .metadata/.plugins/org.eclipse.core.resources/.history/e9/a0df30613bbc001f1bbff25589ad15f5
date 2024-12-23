package selenium.SeleniumFramework.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.SeleniumFramework.pageobject.LandingPage;

public class BaseTest {
 public WebDriver driver;
 public LandingPage landingPage;

	public WebDriver initializedDriver() throws IOException {
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "//src//main//java//selenium//SeleniumFramework//Resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName= System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		// above line tells if there browser details given in maven cmd
		//execute it otherewise use glbal property
		//open pom.xmfile
		//mvn test -Dbrowser=Firefox
		if(browserName.contains("chrome")) {
			
		ChromeOptions options= new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")){
		options.addArguments("headless");// from this it runs in headless mode
		}
		driver= new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));// give full screen, maximize browser so there will no failure 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	return driver;
	
	}
	public  List<HashMap<String, String>> getJsonDatatoMap(String FilePath) throws IOException {
		//read json to string
		String jsonContent= FileUtils.readFileToString(new File(FilePath),
			StandardCharsets.UTF_8);
		//string to hashmap jaksondatabind
		ObjectMapper mapper =new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	}
	
	 @BeforeMethod
	public LandingPage launchApplication() throws IOException {
		 
		driver= initializedDriver();
		 landingPage= new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	 
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
