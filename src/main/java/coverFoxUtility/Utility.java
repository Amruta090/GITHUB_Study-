package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void takeScreenShot(WebDriver driver,String fileName) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		File dest = new File("C:\\Users\\s\\eclipse-workspace\\java basics\\Maven_Project_Study\\src\\main\\java\\CoverFoxPOM\\coverFoxUtility\\screenShot"+timeStamp + ".png");

		FileHandler.copy(source, dest);
		}
	public static String readDataFromExcel(String excelpath,String sheetName,int rowNum,int cellNum ) throws EncryptedDocumentException, IOException {
		FileInputStream myfile= new FileInputStream ("C:\\Users\\s\\eclipse-workspace\\java basics\\Maven_Project_Study\\src\\main\\java\\CoverFoxPOM\\Datareading.xlsx");	
		String value= WorkbookFactory.create(myfile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
		
	}
	public static String readDataFromPropertyFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream myfile = new FileInputStream("C:\\Users\\s\\eclipse-workspace\\java basics\\Maven_Project_Study\\src\\main\\java\\CoverFoxPOM\\PropertiesFile_config.properties");
		prop.load(myfile);
		String value=prop.getProperty(key);
	return value;
			
	}
}