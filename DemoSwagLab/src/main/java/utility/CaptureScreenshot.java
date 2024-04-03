package utility;

import java.io.File;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import base.TestBase;

public class CaptureScreenshot extends TestBase{
	//Method to take screen shot when Test case get failed
	public static void screenShot(String nameOfMethod) throws Exception
	{
		Date date=new Date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("/Users/laljose/Documents/AryasWorkSpace/DemoSwagLab/Screenshots/" +nameOfMethod+"_"+date + ".jpeg");
		FileHandler.copy(source, dest);
	}
}
