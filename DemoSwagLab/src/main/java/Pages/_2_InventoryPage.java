package Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import utility.HandleDropDown;
import utility.ReadData;


public class _2_InventoryPage extends TestBase{
	
	//Object Repository
	@FindBy(xpath="//span[@class='title']")
	private WebElement inventoryPage_Product_Label;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement inventoryPage_ProductSort_DropDown;
	
	@FindBy(xpath="//li[@class='social_twitter']/a")
	private WebElement inventoryPage_Twitter_Logo;
	
	@FindBy(xpath="//li[@class='social_facebook']/a")
	private WebElement inventoryPage_FB_Logo;
	
	@FindBy(xpath="//li[@class='social_linkedin']/a")
	private WebElement inventoryPage_LinkedIn_Logo;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement inventoryPage_BackBag_AddToCart_Button;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement inventoryPage_BikeLight_AddToCart_Button;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement inventoryPage_BoltShirt_AddToCart_Button;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement inventoryPage_FleeceJacket_AddToCart_Button;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement inventoryPage_Onesie_AddToCart_Button;
	
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	private WebElement inventoryPage_RedTShirt_AddToCart_Button;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement inventoryPage_CartCount;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
	private WebElement inventoryPage_BackBag_Remove_Button;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")
	private WebElement inventoryPage_BikeLight_Remove_Button;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")
	private WebElement inventoryPage_BoltShirt_Remove_Button;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")
	private WebElement inventoryPage_FleeceJacket_Remove_Button;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")
	private WebElement inventoryPage_Onesie_Remove_Button;
	
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']")
	private WebElement inventoryPage_RedTShirt_Remove_Button;
	
	@FindBy(xpath="//button[text()='Add to cart'][position() >= 1 and position() < 4]")
	private List<WebElement> inventoryPage_AddToCart_Button;
	
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	private List<WebElement> inventoryPage_ProductList_Label;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	private List<WebElement> inventoryPage_ProductPriceList_Label;
	
	public _2_InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*****************************************************************************/

	//Method to verify the label
	public String verifyInventoryPageProductLabel()
	{
		logger=report.createTest("TestCase to:Verify Inventory Page Product Label");
		logger.log(Status.INFO, "Inventory Page Product Label is present");
		logger.log(Status.PASS, "Inventory Page Product Label verification is PASSED");
		return inventoryPage_Product_Label.getText();
	}
	
	//Method to verify the TwitterLogo
	public boolean verifyInventoryPageTwitterLogo()
	{
		logger=report.createTest("TestCase to:Verify Inventory Page TwitterLogo");
		logger.log(Status.INFO, "TwitterLogo is displayed");
		logger.log(Status.PASS, "TwitterLogo verification is PASSED");
		return inventoryPage_Twitter_Logo.isDisplayed();
	}
	
	//Method to verify the FBLogo
	public boolean verifyInventoryPageFbLogo()
	{
		logger=report.createTest("TestCase to:Verify Inventory Page FBLogo");
		logger.log(Status.INFO, "FBLogo is displayed");
		logger.log(Status.PASS, "FBLogo verification is PASSED");
		return inventoryPage_FB_Logo.isDisplayed();
	}
	
	//Method to verify the LinkedInLogo
	public boolean verifyInventoryPageLinkedInLogo()
	{
		logger=report.createTest("TestCase to:Verify Inventory Page LinkedInLogo");
		logger.log(Status.INFO, "LinkedInLogo is displayed");
		logger.log(Status.PASS, "LinkedInLogo verification is PASSED");
		return inventoryPage_LinkedIn_Logo.isDisplayed();
	}
	
	//Method to verify products properly displayed in inventory page or not
	public String verifyInventoryPageDisplaysProductsOrNot()
	{
		logger=report.createTest("TestCase to:Verify products properly displayed in inventory page or not");
		logger.log(Status.INFO, "Products listed properly");
		logger.log(Status.PASS, "Product listing verification is PASSED");
		return String.valueOf(inventoryPage_ProductList_Label.size());
     }
	
	//Method to add 3 lowest price product to a cart
	public String add3LowestPriceProducts() throws Exception
	{
	logger=report.createTest("TestCase to:Add 3 lowest price product to cart");
	HandleDropDown.handleSelectClass(inventoryPage_ProductSort_DropDown,ReadData.readExcelFile(0, 0));
	logger.log(Status.INFO, "Clicked on droped down menu and options selected");
	logger.log(Status.INFO, "About to enter in for loop");
	for(int i=1; i<=3; i++) 
		{
		inventoryPage_AddToCart_Button.get(i).click();
		
	    }
	logger.log(Status.INFO, "Added 3 lowest price product to cart");
	logger.log(Status.PASS, "Added 3 lowest price product to cart successfull:PASSED");
	return inventoryPage_CartCount.getText();
	}
	
	//Method to get product name ascending order list
	public List<String> ProductName_AscendingOrder()
	{
		logger=report.createTest("TestCase to:Get product name ascending order list");
		List<String> productList = new ArrayList<String>();
		productList.add("Sauce Labs Bike Light");
		productList.add("Sauce Labs Bolt T-Shirt");
		productList.add( "Sauce Labs Fleece Jacket");
		productList.add("Sauce Labs Backpack");
		productList.add("Test.allTheThings() T-Shirt (Red)");
		productList.add( "Sauce Labs Onesie");
		logger.log(Status.INFO, "Products are added to a Product List");
		// Sorts ArrayList in ascending order
		Collections.sort(productList);
		logger.log(Status.INFO, "Products are sorted in ascending order of product name");
		System.out.println("Modified ArrayList : \n" + productList);
		List<String> AscOrderProductList = new ArrayList<String>();
		AscOrderProductList.addAll(productList);
		logger.log(Status.INFO, "Copies the value of ascending order list to Ascorderproduct list");
		System.out.println("Ascending Order List : \n" + AscOrderProductList);
		logger.log(Status.PASS, "Acsending order list returned successfully");
		return AscOrderProductList;
	}
	
	//Method to get products name descending order list
	public List<String> ProductName_DescendingOrder()
	{
		logger=report.createTest("TestCase to:Get product name descending order list");
		List<String> productList = new ArrayList<String>();
		productList.add("Sauce Labs Bike Light");
		productList.add("Sauce Labs Bolt T-Shirt");
		productList.add( "Sauce Labs Fleece Jacket");
		productList.add("Sauce Labs Backpack");
		productList.add("Test.allTheThings() T-Shirt (Red)");
		productList.add( "Sauce Labs Onesie");
		logger.log(Status.INFO, "Products are added to a Product List");
		// Sorts ArrayList in descending order
		Collections.sort(productList, Collections.reverseOrder());
		logger.log(Status.INFO, "Products are sorted in reverse order of product name");
		System.out.println("Modified ArrayList : \n" + productList);
		List<String> DescOrderProductList = new ArrayList<String>();
		DescOrderProductList.addAll(productList);
		logger.log(Status.INFO, "Copies the value of ascending order list to DescOrderProductList list");
		System.out.println("Descending Order List : \n" + DescOrderProductList);
		logger.log(Status.PASS, "Descending order list returned successfully");
		return DescOrderProductList;
	}
	
	//Method to get products price in increasing order 
	public List<Double> ProductPrice_IncreasingOrder()
	{
		logger=report.createTest("TestCase to:Get products price in increasing order ");
		List<Double> productList = new ArrayList<Double>();
		productList.add(49.99);
		productList.add(29.99);
		productList.add(15.99);
		productList.add(15.99);
		productList.add(9.99);
		productList.add(7.99);
		logger.log(Status.INFO, "Products price  are added to a productList List");
		// Sorts ArrayList in descending order
		Collections.sort(productList);
		logger.log(Status.INFO, "Products price are sorted in price increasing order");
		System.out.println("Modified ArrayList : \n" + productList);
		List<Double> IncreasingProductList = new ArrayList<Double>();
		IncreasingProductList.addAll(productList);
		logger.log(Status.INFO, "Copies the list of price in increasing order to IncreasingProductList list");
		System.out.println("Descending Order List : \n" + IncreasingProductList);
		logger.log(Status.PASS, "Price increasing order list returned successfully");
		return IncreasingProductList;
	}
	
	//Method to get products price in decreasing order 
	public List<Double> ProductPrice_DecreasingOrder()
	{
		logger=report.createTest("TestCase to:Get products in price decreasing order ");
		List<Double> productList = new ArrayList<Double>();
		productList.add(49.99);
		productList.add(29.99);
		productList.add(15.99);
		productList.add(15.99);
		productList.add(9.99);
		productList.add(7.99);
		logger.log(Status.INFO, "Products price  are added to a productList List");
		// Sorts ArrayList in decreasing order
		Collections.sort(productList, Collections.reverseOrder());
		logger.log(Status.INFO, "Products price are sorted in price decreasing order");
		System.out.println("Modified ArrayList : \n" + productList);
		List<Double> DecreasingOrderProductList = new ArrayList<Double>();
		DecreasingOrderProductList.addAll(productList);
		logger.log(Status.INFO, "Copies the list of price in decreasing order to DecreasingOrderProductList list");
		System.out.println("Descending Order List : \n" + DecreasingOrderProductList);
		logger.log(Status.PASS, "Price decreasing order list returned successfully");
		return DecreasingOrderProductList;

	}
	
	//Method to get product price from UI by sorting products by price
	public List<Double> productPriceFromUi() throws Exception
	{
		logger=report.createTest("TestCase to:Get products from UI by sorting products by price");
		List<Double> UIProductList = new ArrayList<>();
		for(WebElement objProductList:inventoryPage_ProductPriceList_Label)
			{
			Double productOneByOne=Double.valueOf(objProductList.getText().replaceAll("[^0-9\\\\.]", ""));
			UIProductList.add(productOneByOne);
			}
		logger.log(Status.PASS, "Product price from UI is added to UIProductList successfully");
		System.out.println("Prdoduct List from UI : \n" + UIProductList);
		return UIProductList;
	}
	
	//Method to get products from UI by sorting products by products name
	public List<String> productNameFromUi() throws Exception
	{
		logger=report.createTest("TestCase to:Get products from UI by sorting products by products name");
		List<String> UIProductList = new ArrayList<>();
		for(WebElement objProductList:inventoryPage_ProductList_Label)
			{
			String productOneByOne=objProductList.getText();
			UIProductList.add(productOneByOne);
			}
		logger.log(Status.INFO,"Product name from UI is added to UIProductList successfully");
		System.out.println("Prdoduct List from UI : \n" + UIProductList);
		return UIProductList;
	}
		
	//Method to call drop down functionality
	public void selectDropDown_InventoryPage(String Option) throws Exception
	{
		logger=report.createTest("TestCase to:Select Inventory drop down values");
		HandleDropDown.handleSelectClass(inventoryPage_ProductSort_DropDown,Option);
		logger.log(Status.PASS, "Call pass to drop down functionality");

	}
	
	//Method to click on Cart Button
	public void clickOnCartIcon()
	{
		logger=report.createTest("TestCase to:Click on Cart Button");
		inventoryPage_CartCount.click();
		logger.log(Status.PASS, "Click on cart button successfully");

	}
}
