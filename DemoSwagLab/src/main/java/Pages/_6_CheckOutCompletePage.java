package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;

public class _6_CheckOutCompletePage extends TestBase{
	
	//Object Repository
	@FindBy(xpath="//span[@class='title']") 
	private WebElement checkOutCompletePage_Complete_Label;

	@FindBy(xpath="//h2[@class='complete-header']") 
	private WebElement checkOutCompletePage_CompleteHeader_Label;

	@FindBy(xpath="//div[@class='complete-text']") 
	private WebElement checkOutCompletePage_CompleteText_Label;

	//Constructor to initialize the web element (current class members)
	public _6_CheckOutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}

	/*****************************************************************************/
	
	//Method to verify complete page URL
	public String verifyCompletePageURL()
	{
		logger=report.createTest("TestCase to:Verify complete page URL");
		logger.log(Status.INFO, "Complete page URL of Application is avilable");
		logger.log(Status.PASS, "Complete page URL of Application is verified:PASSED");
		return driver.getCurrentUrl();
	}
	
	//Method to verify complete page complete label
	public String verifyCompletePageCompleteLabel()
	{
		logger=report.createTest("TestCase to:Verify complete page complete label");
		logger.log(Status.INFO, "Complete page complete label is present");
		logger.log(Status.PASS, "Complete page complete label verification is PASSED");
		return checkOutCompletePage_Complete_Label.getText();
	}
	
	//Method to verify complete page header label
	public String verifyCompletePageHeaderLabel()
	{
		logger=report.createTest("TestCase to:Verify complete page header label");
		logger.log(Status.INFO, "Complete page header label is present");
		logger.log(Status.PASS, "Complete page header label verification is PASSED");
		return checkOutCompletePage_CompleteHeader_Label.getText();
	}
	
	//Method to verify complete page text label
	public String verifyCompletePageTextLabel()
	{
		logger=report.createTest("TestCase to:Verify complete page text label");
		logger.log(Status.INFO, "Complete page text label is present");
		logger.log(Status.PASS, "Complete page text label verification is PASSED");
		return checkOutCompletePage_CompleteText_Label.getText();
	}
}
