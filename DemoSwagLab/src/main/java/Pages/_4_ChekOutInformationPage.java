package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class _4_ChekOutInformationPage extends TestBase{
	
	//Object Repository
	@FindBy (xpath="//span[@class='title']")
	private WebElement checkOutInfoPage_CheckOutInfo_Label;

	@FindBy (xpath="//input[@id='first-name']")
	private WebElement checkOutInfoPage_FirstName_TextBox;

	@FindBy (xpath="//input[@id='last-name']")
	private WebElement checkOutInfoPage_LastName_TextBox;

	@FindBy (xpath="//input[@id='postal-code']")
	private WebElement checkOutInfoPage_ZipCode_TextBox;

	@FindBy (xpath="//input[@id='continue']")
	private WebElement checkOutInfoPage_Continue_Button;

	//Constructor to initialize the web element (current class members)
	public _4_ChekOutInformationPage()
	{
		PageFactory.initElements(driver, this);
	}

	/*****************************************************************************/
	
	//Method to verify Checkout info page URL
	public String verifyCheckOutInfoPageURL()
	{
		logger=report.createTest("TestCase to:Verify Checkout info page URL");
		logger.log(Status.INFO, "Checkout info page URL is avilable");
		logger.log(Status.PASS, "Checkout info page URL is verified:PASSED");
		return driver.getCurrentUrl();
	}
	
	//Method to verify Checkout info page label
	public String verifyCheckOutInfoPageLabel()
	{
		logger=report.createTest("TestCase to:Verify Checkout info page label");
		logger.log(Status.INFO, "Checkout info page label is avilable");
		logger.log(Status.PASS, "Checkout info page label is verified:PASSED");
		return checkOutInfoPage_CheckOutInfo_Label.getText();
	}

	//Method to input checkout info
	public String  inputCheckOutInfo() throws Exception
	{
		logger=report.createTest("TestCase to:Input checkout info");
		checkOutInfoPage_FirstName_TextBox.sendKeys(ReadData.readExcelFile(0, 1));
		logger.log(Status.INFO, "First Name is entered");
		checkOutInfoPage_LastName_TextBox.sendKeys(ReadData.readExcelFile(0, 2));
		logger.log(Status.INFO, "Last Name is entered");
		checkOutInfoPage_ZipCode_TextBox.sendKeys(ReadData.readExcelFile(0, 3));
		logger.log(Status.INFO, "Zip code is entered");
		checkOutInfoPage_Continue_Button.click();
		logger.log(Status.INFO, "Continue button is clicked");
		logger.log(Status.PASS, "Continue button clicked  successfully:PASSED");
		return driver.getCurrentUrl();
	}
}
