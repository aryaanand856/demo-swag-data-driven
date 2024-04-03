package utility;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	//This method read the data from property file.
	public static String readPropertyFile(String value) throws Exception 
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("/Users/laljose/Documents/AryasWorkSpace/DemoSwagLab/TestData/config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	//This method read data from Excel
	public static String readExcelFile(int rowNum,int colNum) throws Exception
	{
		FileInputStream file=new FileInputStream("/Users/laljose/Documents/AryasWorkSpace/DemoSwagLab/TestData/TestData.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();		
		return value;
	}
}
