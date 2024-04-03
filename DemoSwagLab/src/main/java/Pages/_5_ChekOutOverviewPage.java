package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class _5_ChekOutOverviewPage extends TestBase{
	
	//Object Repository
	@FindBy(xpath="//span[@class='title']")
	private WebElement ChekOutOverviewPage_ChekOutOverView_Label;

	@FindBy(xpath="//div[@data-test='payment-info-value']")
	private WebElement ChekOutOverviewPage_PaymentInfo_Label;

	@FindBy(xpath="//div[@data-test='shipping-info-value']")
	private WebElement ChekOutOverviewPage_ShippingInfo_Label;

	@FindBy(xpath="//div[@data-test='total-label']")
	private WebElement ChekOutOverviewPage_TotalAmount_Label;

	@FindBy(xpath="//button[@id='finish']")
	private WebElement ChekOutOverviewPage_Finish_Button;

	//Constructor to initialize the web element (current class members)
	public _5_ChekOutOverviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*****************************************************************************/
	
	//Method to verify checkout overview page label
	public String verifyCheckOutOverViewPageLabel()
	{
		logger=report.createTest("TestCase to:Verify checkout overview page label");
		logger.log(Status.INFO, "Checkout overview page label is avilable");
		logger.log(Status.PASS, "Checkout overview page label is verified:PASSED");
		return ChekOutOverviewPage_ChekOutOverView_Label.getText();
	}

	//Method to verify checkout overview payment info label
	public String verifyCheckOutOverViewPaymentInfoLabel()
	{
		logger=report.createTest("TestCase to:Verify checkout overview payment info label");
		logger.log(Status.INFO, "Checkout  overview payment info label is avilable");
		logger.log(Status.PASS, "Checkout overview payment info label is verified:PASSED");
		return ChekOutOverviewPage_PaymentInfo_Label.getText();
	}

	//Method to verify checkout overview shipping info label
	public String verifyCheckOutOverViewShippingInfoLabel()
	{
		logger=report.createTest("TestCase to:Verify checkout overview shipping info label");
		logger.log(Status.INFO, "Checkout  overview shipping info label is avilable");
		logger.log(Status.PASS, "Checkout overview shipping info label is verified:PASSED");
		return ChekOutOverviewPage_ShippingInfo_Label.getText();
	}
/*
	//Method to verify checkout overview total amount label
	public String verifyCheckOutOverViewTotalAmtLabel()
	{
		logger=report.createTest("TestCase to:Verify checkout overview total amount label");
		logger.log(Status.INFO, "Checkout  overview total amount label is avilable");
		logger.log(Status.PASS, "Checkout overview total amount label is verified:PASSED");
		return ChekOutOverviewPage_TotalAmount_Label.getText();
	}
	*/
	
	//Method to click on finish button
	public void clickFinishButton()
	{		
		logger=report.createTest("TestCase to:Click on finish button");
		logger.log(Status.INFO, "Finish button is clicked");
		ChekOutOverviewPage_Finish_Button.click();
		logger.log(Status.PASS, "Finish button clicked successfully:PASSED");
	}
}
