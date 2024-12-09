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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
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
