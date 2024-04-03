package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import Pages._1_LoginPage;
import Pages._2_InventoryPage;
import Pages._3_CartPage;
import Pages._4_ChekOutInformationPage;
import base.TestBase;
import utility.CaptureScreenshot;
import utility.ReadData;

public class _4_ChekOutInformationPageTest extends TestBase{
	
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_ChekOutInformationPage checkOutInfo;
	SoftAssert softAssert;
	
	//prerequisite to run the Test case 
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception
	{
		initalization();
		login=new _1_LoginPage();
		invent=new _2_InventoryPage();
		cart=new _3_CartPage();
		checkOutInfo=new _4_ChekOutInformationPage();
		softAssert=new SoftAssert();
		login.loginToApplication();
		invent.add3LowestPriceProducts();//invent.add6Products();
		invent.clickOnCartIcon();
		cart.clickCheckOutButton();
	}
	
	//Test case to verify checkout info page URL
	@Test(groups = "Smoke")
	public void verifyCheckOutInfoPageURLTest() throws Exception
	{
		String expURL=ReadData.readExcelFile(1, 8);
		String actURL=checkOutInfo.verifyCheckOutInfoPageURL();
		softAssert.assertEquals(expURL, actURL);
		Reporter.log("URL of check out info page"+actURL);
		softAssert.assertAll();
	}
	
	//Test case to verify checkout info page label
	@Test(groups = "Smoke")
	public void verifyCheckOutInfoPageLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1, 9);
		String actLabel=checkOutInfo.verifyCheckOutInfoPageLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Check out page label"+actLabel);
		softAssert.assertAll();
	}
	
	//Test case to verify user landed on Check Out Over view page
	@Test(groups = "Sanity")
	public void inputCheckOutInfoTest() throws Exception
	{
		String expURL=ReadData.readExcelFile(1,10);
		String actURL=checkOutInfo.inputCheckOutInfo();
		softAssert.assertEquals(expURL, actURL);
		Reporter.log("Verified user landed on Check Out Over view page"+actURL);
		softAssert.assertAll();
	}
	
	//Test case to close the browser
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
