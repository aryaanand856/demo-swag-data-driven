package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {
	
	//Method automate the drop down using Select classes
	public static void handleSelectClass(WebElement ele,String value)
	{
		Select objSelect=new Select(ele);
		objSelect.selectByVisibleText(value);
	}
}
