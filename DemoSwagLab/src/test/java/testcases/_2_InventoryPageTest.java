package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.util.List;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import Pages._1_LoginPage;
import Pages._2_InventoryPage;
import base.TestBase;
import utility.CaptureScreenshot;
import utility.ReadData;

public class _2_InventoryPageTest extends TestBase{

	_1_LoginPage login;
	_2_InventoryPage invent;
	SoftAssert softAssert;
	
	//prerequisite to run the Test case 
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception
	{
		initalization();
		login=new _1_LoginPage();
		invent=new _2_InventoryPage();
		login.loginToApplication();
		softAssert=new SoftAssert();
	}
		
	//Test Case to verify product label
	@Test(enabled = false)		
	public void verifyInventoryPageProductLabelTest() throws Exception
	{
		String actLabel=invent.verifyInventoryPageProductLabel();
		String expLabel=ReadData.readExcelFile(1, 3);
		softAssert.assertEquals(expLabel, actLabel);
		Reporter.log("Inventory Page label:-"+actLabel);
		softAssert.assertAll();
	}
		
	//Test Case to verify Twitter Logo
	@Test(enabled = false)
	public void verifyInventoryPageTwitterLogoTest()
	{
		boolean result=invent.verifyInventoryPageTwitterLogo();
		softAssert.assertEquals(result, true);
		Reporter.log("Visibility of TwitterLogo:-"+result);
		softAssert.assertAll();
	}
	
	//Test Case to verify FB Logo
	@Test(enabled = false,groups = "Smoke")
	public void verifyInventoryPageFbLogoTest()
	{
		boolean result=invent.verifyInventoryPageFbLogo();
		softAssert.assertEquals(result, true);
		Reporter.log("Visibility of FbLogo:-"+result);
		softAssert.assertAll();
	}
		
	//Test Case to verify LinkedIn Logo
	@Test(enabled = false,groups = "Smoke")
	public void verifyInventoryPageLinkedInLogoTest()
	{
		boolean result=invent.verifyInventoryPageLinkedInLogo();
		softAssert.assertEquals(result, true);
		Reporter.log("Visibility of LinkedInLogo:-"+result);
		softAssert.assertAll();
	}
	
	//Test Case to verify inventory page listing products properly
	@Test(enabled = true)
	public void verifyInventoryPageDisplaysProductsOrNotTest() throws Exception
	{
		String expCount=ReadData.readExcelFile(1, 4);
		String actCount=invent.verifyInventoryPageDisplaysProductsOrNot();
		softAssert.assertEquals(expCount, actCount);
		Reporter.log("Inventory page listing products properly:-"+actCount);
		softAssert.assertAll();
	}
	
	//Data Provider
	@DataProvider(name="OptionsInAcsendingOrder_Name")
	public Object[][] getOption1()
	{
		return new Object[][] {
			{"Name (A to Z)"}
		};
	}
	
	//Test Case to validate Products are displayed in ascending order of product name
	@Test(enabled = false,dataProvider="OptionsInAcsendingOrder_Name")
	public void validateProductInAscendingOrderTest(String option) throws Exception
	{
		invent.selectDropDown_InventoryPage(option);
		List<String> actualProductList = invent.productNameFromUi();
		List<String> expectedProductList = invent.ProductName_AscendingOrder();
		softAssert.assertEquals(actualProductList, expectedProductList);
		Reporter.log("Inventory page listing products in ascending order:-"+actualProductList);
		softAssert.assertAll();
	}
	
	//Data Provider
	@DataProvider(name="OptionsInDesendingOrder_Name")
	public Object[][] getOption2()
	{
		return new Object[][] {
			{"Name (Z to A)"}
		};
	}
	
	//Test Case to validate Products are displayed in descending order of product name
	@Test(enabled = false,dataProvider="OptionsInDesendingOrder_Name")
	public void validateProductInDescendingOrderTest(String option) throws Exception
	
	{
		invent.selectDropDown_InventoryPage(option);
		List<String> actualProductList = invent.productNameFromUi();
		List<String> expectedProductList = invent.ProductName_DescendingOrder();
		softAssert.assertEquals(actualProductList, expectedProductList);
		Reporter.log("Inventory page listing products in Descending order:-"+actualProductList);
		softAssert.assertAll();
	}
	
	//Data Provider
	@DataProvider(name="OptionsInIncreasingOrder_Price")
	public Object[][] getOption3()
	{
		return new Object[][] {
			{"Price (low to high)"}
		};
	}
	
	//Test Case to validate Products price are displayed in increasing order of product price
	@Test(enabled = true,dataProvider="OptionsInIncreasingOrder_Price")
	public void validateProductPriceInIncreasingOrderTest(String option) throws Exception
	
	{
		invent.selectDropDown_InventoryPage(option);
		List<Double> actualProductList = invent.productPriceFromUi();
		List<Double> expectedProductList = invent.ProductPrice_IncreasingOrder();
		softAssert.assertEquals(actualProductList, expectedProductList);
		Reporter.log("Inventory page listing products price in increasing order:-"+actualProductList);
		softAssert.assertAll();
	}
	
	//Test Case to add 3 lowest price product to cart
	@Test(enabled = true,dataProvider="OptionsInIncreasingOrder_Price")
	public void add3LowestPriceProductsTest(String option) throws Exception
	{
		String expCount=ReadData.readExcelFile(1, 5);
		String actCount=invent.add3LowestPriceProducts();
		softAssert.assertEquals(expCount, actCount);
		Reporter.log("Total product added:-"+actCount);
		softAssert.assertAll();
	}
	
	//Data provider
	@DataProvider(name="OptionsInDecreasingOrder_Price")
	public Object[][] getOption4()
	{
		return new Object[][] {
			{"Price (high to low)"}
		};
	}
	
	//Test Case to validate Products price are displayed in decreasing order of product price
	@Test(enabled = true,dataProvider="OptionsInDecreasingOrder_Price")
	public void validateProductPriceInDecreasingOrderTest(String option) throws Exception
	
	{
		invent.selectDropDown_InventoryPage(option);
		List<Double> actualProductList = invent.productPriceFromUi();
		List<Double> expectedProductList = invent.ProductPrice_DecreasingOrder();
		softAssert.assertEquals(actualProductList, expectedProductList);
		Reporter.log("Inventory page listing products price in decreasing order:-"+actualProductList);
		softAssert.assertAll();
	}
	
	//Browser close
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
