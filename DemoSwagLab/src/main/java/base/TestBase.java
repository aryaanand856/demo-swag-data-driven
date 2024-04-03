package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtendReportManager;
import utility.ReadData;

public class TestBase {
	
	public ExtentReports report=ExtendReportManager.getReportInstance();
	public ExtentTest logger;
	//driver is defined globally by which it can be use all page and test class
	//driver is defined as static because only single copy of driver should be used across the project. 
	public static WebDriver driver;
	
	//This method open the browser and enter the URL of the application
	public void initalization() throws Exception
	{
		String browser=ReadData.readPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();;
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(ReadData.readPropertyFile("url"));
		Thread.sleep(3000);
	}

}
