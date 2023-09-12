package base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	
	
public class BaseTest {
public static WebDriver driver;
public ExtentSparkReporter sparkReporter;
public ExtentReports extent;
public ExtentTest logger;
	@BeforeTest
	//main before test method
	public void beforeTestMethod() {
    //Initializing extent report
		sparkReporter = new ExtentSparkReporter (System.getProperty("user.dir") + File.separator+"reports"+File.separator+"SDETADDAEXtentReport.html"); 
		extent = new ExtentReports ();
		extent.attachReporter (sparkReporter);
		sparkReporter.config().setTheme (Theme. DARK);
		extent.setSystemInfo ("HostName", "RHEL8");
		extent.setSystemInfo ("UserName", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName ("Automation Tests Results by SDET ADDA");
		
		
	}
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod (String browser)
	{
		setupDriver(browser);
		
	}
	@AfterMethod
	@AfterTest
	
	
}

public void setupDriver (String browser){
if (browser.equalsIgnoreCase ("chrome")){ 
WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();}
else if (browser.equalsIgnoreCase ("firefox")) {
WebDriverManager.firefoxdriver().setup();
driver= new FirefoxDriver(); }
else if (browser.equalsIgnoreCase ("edge")) {
WebDriverManager.edgedriver ().setup(); 
driver= new EdgeDriver(); } }	
