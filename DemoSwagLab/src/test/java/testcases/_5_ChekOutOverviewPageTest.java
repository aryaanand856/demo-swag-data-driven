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
import base.TestBase;
import utility.CaptureScreenshot;
import utility.ReadData;

public class _5_ChekOutOverviewPageTest extends TestBase{
	
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_ChekOutInformationPage checkOutInfo;
	_5_ChekOutOverviewPage checkOutOverView;
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
		softAssert=new SoftAssert();
		login.loginToApplication();
		invent.add3LowestPriceProducts();//invent.add6Products();
		invent.clickOnCartIcon();
		cart.clickCheckOutButton();
		checkOutInfo.inputCheckOutInfo();
	}
	
	//Test Case to verify Checkout Overview page label
	@Test(groups = "Smoke")
	public void verifyCheckOutOverViewPageLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1,11);
		String actLabel=checkOutOverView.verifyCheckOutOverViewPageLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Check Out OverView Page Label is"+actLabel);
		softAssert.assertAll();
	}
	
	//Test Case to verify Checkout Overview Payment Info label
	@Test(groups = "Smoke")
	public void verifyCheckOutOverViewPaymentInfoLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1,12);
		String actLabel=checkOutOverView.verifyCheckOutOverViewPaymentInfoLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Check Out OverView Payment Info Label is"+actLabel);
		softAssert.assertAll();
	}
	
	//Test Case to verify Checkout Overview Shipping Info label
	@Test(groups = "Smoke")
	public void verifyCheckOutOverViewShippingInfoLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1,13);
		String actLabel=checkOutOverView.verifyCheckOutOverViewShippingInfoLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Check Out OverView shippingInfoLabel is"+actLabel);
		softAssert.assertAll();
	}
	/*
	//Test Case to verify Checkout Overview TotalAmt Info label
	@Test(groups = "Smoke")
	public void verifyCheckOutOverViewTotalAmtLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1,14);
		String actLabel=checkOutOverView.verifyCheckOutOverViewTotalAmtLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Check Out OverView Total Amt Label is"+actLabel);
		softAssert.assertAll();
	}
	*/
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
