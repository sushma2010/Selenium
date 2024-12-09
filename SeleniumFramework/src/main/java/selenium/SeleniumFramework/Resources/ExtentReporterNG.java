package selenium.SeleniumFramework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	
	public static ExtentReports getReoprtObject() {
		String path= System.getProperty("user.dir")+"//report//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("TestResult");
		reporter.config().setReportName("Web Automation");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Sushma S Prabhu");
		return extent;
	}
}
