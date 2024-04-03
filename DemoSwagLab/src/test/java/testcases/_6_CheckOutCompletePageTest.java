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
import Pages._5_ChekOutOverviewPage;
import Pages._6_CheckOutCompletePage;
import base.TestBase;
import utility.CaptureScreenshot;
import utility.ReadData;

public class _6_CheckOutCompletePageTest extends TestBase{
	
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_ChekOutInformationPage checkOutInfo;
	_5_ChekOutOverviewPage checkOutOverView;
	_6_CheckOutCompletePage checkOutComplete;
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
		checkOutOverView=new _5_ChekOutOverviewPage();
		checkOutComplete=new _6_CheckOutCompletePage();
		softAssert=new SoftAssert();
		login.loginToApplication();
		invent.add3LowestPriceProducts();//invent.add6Products();
		invent.clickOnCartIcon();
		cart.clickCheckOutButton();
		checkOutInfo.inputCheckOutInfo();
		checkOutOverView.clickFinishButton();
	}
	
	//Test case to verify complete page URL
	@Test(groups = {"Smoke","Sanity"})
	public void verifyCompletePageURLTest() throws Exception
	{
		String expURL=ReadData.readExcelFile(1,15);
		String actURL=checkOutComplete.verifyCompletePageURL();
		softAssert.assertEquals(expURL, actURL);
		Reporter.log("Check Out Complete Page URL is"+actURL);
		softAssert.assertAll();
	}
	
	//Test case to verify complete page CompleteLabel
	@Test(groups = "Smoke")
	public void verifyCompletePageCompleteLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1,16);
		String actLabel=checkOutComplete.verifyCompletePageCompleteLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Complete Page Complete Label is"+actLabel);
		softAssert.assertAll();
	}
	
	//Test case to verify complete page Header label
	@Test(groups = "Smoke")
	public void verifyCompletePageHeaderLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1,17);
		String actLabel=checkOutComplete.verifyCompletePageHeaderLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Complete Page Header Label is"+actLabel);
		softAssert.assertAll();
	}
	
	//Test case to verify complete page text label
	@Test(groups = "Smoke")
	public void verifyCompletePageTextLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1,18);
		String actLabel=checkOutComplete.verifyCompletePageTextLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Complete Page Text Label is"+actLabel);
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
