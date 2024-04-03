package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import utility.ReadData;

public class _1_LoginPage extends TestBase{
	
	//Object Repository
	@FindBy(xpath="//div[@class='login_logo']") 
	private WebElement loginPage_Logo;
	
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement loginPage_UsrName_TextBox;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement loginPage_Paswd_TextBox;
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement loginPage__Login_Button;
	
	//Constructor to initialize the web element (current class members)
	public _1_LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*****************************************************************************/
	
	//Method to login in application
	public String loginToApplication() throws Exception
	{
		logger=report.createTest("TestCase to:Login to Swag Labs Application");
		loginPage_UsrName_TextBox.sendKeys(ReadData.readPropertyFile("username"));
		logger.log(Status.INFO, "User Name is entered");
		loginPage_Paswd_TextBox.sendKeys(ReadData.readPropertyFile("password"));
		logger.log(Status.INFO, "Password is entered");
		loginPage__Login_Button.click();
		logger.log(Status.INFO, "Login button is clicked");
		logger.log(Status.PASS, "Login successfull:PASSED");
		return driver.getCurrentUrl();
	}
	
	//Method to verify LoginLogo
	public boolean verifyLoginLogo()
	{
		logger=report.createTest("TestCase to:Verify LoginLogo");
		logger.log(Status.INFO, "Logo is displayed");
		logger.log(Status.PASS, "LoginLogo verification is PASSED");
		return loginPage_Logo.isDisplayed();
	}
	
	//Method to verify title of Application under test
	public String verifyTitleOfApp()
	{
		logger=report.createTest("TestCase to:Verify Application Title");
		logger.log(Status.INFO, "Application Tittle is avilable");
		logger.log(Status.PASS, "Application Tittle is verified:PASSED");
		return driver.getTitle();
	}
	
	//Method to verify URL of Application under test
	public String verifyURLOfApp()
	{
		logger=report.createTest("TestCase to:Verify URL of the Application");
		logger.log(Status.INFO, "URL of Application is avilable");
		logger.log(Status.PASS, "URL of Application is verified:PASSED");
		return driver.getCurrentUrl();
	}
	
	//Method to verify multiple set of data
	public String loginToAppWithMultipleCred(String Uname,String pwd) throws Exception
	{
		logger=report.createTest("TestCase to:Login to Swag Labs Application");
		loginPage_UsrName_TextBox.sendKeys(Uname);
		logger.log(Status.INFO, "User Name is entered");
		loginPage_Paswd_TextBox.sendKeys(pwd);
		logger.log(Status.INFO, "Password is entered");
		loginPage__Login_Button.click();
		logger.log(Status.INFO, "Login button is clicked");
		logger.log(Status.PASS, "Login button successfully:PASSED");
		return driver.getCurrentUrl();
	}
}
