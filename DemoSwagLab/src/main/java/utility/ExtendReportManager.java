package utility;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportManager {
	
	public static ExtentReports report;
	
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
		Date date=new Date();
		String reporterName=date.toString();
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("/Users/laljose/Documents/AryasWorkSpace/DemoSwagLab/ExtentReports/"+reporterName+".html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Mac");
		report.setSystemInfo("Browser", "Chrome");
		
		htmlReporter.config().setDocumentTitle("Swag Labs UI Automation");
		htmlReporter.config().setReportName("Swag Labs UI Report");
		}
		return report;
	}

}
