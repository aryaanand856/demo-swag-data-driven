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
import base.TestBase;
import utility.CaptureScreenshot;
import utility.ReadData;

public class _3_CartPageTest extends TestBase{
	
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	SoftAssert softAssert;

	//prerequisite to run the Test case 
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception
	{
		initalization();
		login=new _1_LoginPage();
		invent=new _2_InventoryPage();
		cart=new _3_CartPage();
		softAssert=new SoftAssert();
		login.loginToApplication();
		invent.add3LowestPriceProducts();//invent.add6Products();
		invent.clickOnCartIcon();
	}
	
	//Test case to verify Cart Page URL
	@Test(groups = {"Smoke","Sanity"})
	public void verifyCartPageURLTest() throws Exception
	{
		String expURL=ReadData.readExcelFile(1, 6);;
		String actURL=cart.verifyCartPageURL();
		softAssert.assertEquals(expURL, actURL);
		Reporter.log("Cart Page URL is:-"+actURL);
		softAssert.assertAll();
	}
	
	//Test case to verify Cart Page Label
	@Test(groups = "Smoke")
	public void verifyCartLabelTest() throws Exception
	{
		String expLabel=ReadData.readExcelFile(1, 7);;
		String actLabel=cart.verifyCartLabel();
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Cart Page Label is:-"+actLabel);
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
