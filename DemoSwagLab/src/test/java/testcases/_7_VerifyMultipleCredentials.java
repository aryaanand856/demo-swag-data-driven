package testcases;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Pages._1_LoginPage;
import base.TestBase;
import utility.CaptureScreenshot;
import utility.ReadData;

public class _7_VerifyMultipleCredentials extends TestBase{

	_1_LoginPage login;
	SoftAssert softAssert;
	
	//prerequisite to run the Test case 
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception
	{
		initalization();
		login=new _1_LoginPage();
		softAssert=new SoftAssert();
	}
	
	//TestCase to login the application and verify the current URL(Inventory Page URL)
	@Test(dataProvider="credentials")
	public void loginToAppWithMultipleCredTest(String Uname,String pwd) throws Exception
	{
		String expURL=ReadData.readExcelFile(1,2);
		String actURL=login.loginToAppWithMultipleCred(Uname, pwd);
		softAssert.assertNotEquals(actURL, expURL, "Not valid credentials");
		Reporter.log("Current URL of the application is:- "+actURL);
		softAssert.assertAll();
	}
	
	//Data provider
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][] {
			{"standard_user","standard_user"},
			{"secret_sauce","secret_sauce"},
			{"",""}
		};
	}
	
	//Close browser
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult it) throws Exception
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenShot(it.getName());
		}
		report.flush();
		driver.close();
	}
	
}
