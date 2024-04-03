package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class _3_CartPage extends TestBase{
	
	//Object Repository
	@FindBy(xpath="//span[@class='title']") 
	private WebElement CartPage_Cart_Label;
	
	@FindBy(xpath="//button[@id='checkout']") 
	private WebElement CartPage_CheckOut_Button;
	
	//Constructor to initialize the web element (current class members)
	public _3_CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*****************************************************************************/
	
	//Method to verify Cart-page URL
	public String verifyCartPageURL()
	{		
		logger=report.createTest("TestCase to:Verify Cart-page URL");
		logger.log(Status.INFO, "Cart-page URL is avilable");
		logger.log(Status.PASS, "Cart-page URL of Application is verified:PASSED");
		return driver.getCurrentUrl();
	}

	//Method to verify Cart label
	public String verifyCartLabel()
	{
		logger=report.createTest("TestCase to:Verify CartLabel");
		logger.log(Status.INFO, "CartLabel is avilable");
		logger.log(Status.PASS, "CartLabel is verified:PASSED");
		return CartPage_Cart_Label.getText();
	}
	
	//Method to click CheckOut button
	public void clickCheckOutButton()
	{
		logger=report.createTest("TestCase to:Click on CheckOut button");
		logger.log(Status.INFO, "Click on CheckOut button");
		CartPage_CheckOut_Button.click();
		logger.log(Status.PASS, "Click on CheckOut button successfully:PASSED");
	}
}
