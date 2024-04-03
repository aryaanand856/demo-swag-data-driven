package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import Pages._1_LoginPage;
import base.TestBase;
import utility.CaptureScreenshot;
import utility.ReadData;

public class _1_LoginPageTest extends TestBase{

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
	@Test(enabled=true)
	public void loginToApplicationTest() throws Exception
	{
		String expURL=ReadData.readExcelFile(1,2);
		String actURL=login.loginToApplication();
		softAssert.assertEquals(expURL, actURL);
		Reporter.log("Current URL of the application is:- "+actURL);
		softAssert.assertAll();
	}
	
	//Test case to verify login logo of application
	@Test(enabled=true)
	public void verifyLoginLogoTest()
	{
		boolean result=login.verifyLoginLogo();
		softAssert.assertEquals(result, true);
		Reporter.log("Visibility of login logo is:-"+result);
		softAssert.assertAll();
	}
	
	//Test case to verify URL of  the application
	@Test(enabled=true)
	public void verifyURLOfAppTest() throws Exception
	{
		String expURL=ReadData.readExcelFile(1, 1);//1,1
		String actURL=login.verifyURLOfApp();
		softAssert.assertEquals(expURL, actURL);
		Reporter.log("Original URL of the application is:-"+actURL);
		softAssert.assertAll();
	}
	
	//Test case to verify title of the application
	@Test(enabled=true)
	public void verifyTitleOfAppTest() throws Exception
	{
		String expTitle=ReadData.readExcelFile(1, 0);//1,0
		String actTitle=login.verifyTitleOfApp();
		softAssert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of the application is:-"+actTitle);
		softAssert.assertAll();
	}
	
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
