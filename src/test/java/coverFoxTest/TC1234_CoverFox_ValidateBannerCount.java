package coverFoxTest;

import java.beans.PropertyEditor;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CoverFoxPOM.CoverFoxAddressDetailsPage;
import CoverFoxPOM.CoverFoxHealthPlanPage;
import CoverFoxPOM.CoverFoxHomePage;
import CoverFoxPOM.CoverFoxMemberDetailsPage;
import CoverFoxPOM.CoverFoxResultPage;
import coverFoxBase.Base;
import coverFoxUtility.Utility;

public class TC1234_CoverFox_ValidateBannerCount extends Base {
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxMemberDetailsPage memberDetailsPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxResultPage resultPage;

	String excelpath="C:\\Users\\s\\eclipse-workspace\\java basics\\Maven_Project_Study\\src\\main\\java\\excel\\Datareading.xlsx";

	String sheetName="Sheet1";
	public static Logger logger;
	@BeforeClass
	public void openApplication() throws IOException {
		launchBorwser();
	logger = Logger.getLogger("Maven_Project_Study");
	PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Application ");
	}
	@BeforeMethod
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException {

		homePage = new CoverFoxHomePage(driver);
		healthPlanPage = new CoverFoxHealthPlanPage(driver);
		memberDetailsPage = new CoverFoxMemberDetailsPage(driver);
		addressDetailsPage = new CoverFoxAddressDetailsPage(driver);
		resultPage = new CoverFoxResultPage(driver);
		homePage.clickOnGenderButton();
		logger.info("clicking On Gender Button ");
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		logger.info("clicking On Next Button ");
		Thread.sleep(1000);
		memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excelpath,sheetName, 0, 0));
		logger.info("Handling Age Dropdown ");
		memberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);
		logger.info("clicking On Next Button ");
		logger.warning("Enter correct Pincode ");
		addressDetailsPage.enterPinCode(Utility.readDataFromExcel(excelpath,sheetName, 0, 1));
		logger.info("Entering Pincode ");
		logger.warning("Enter correct Mobile Number ");
		addressDetailsPage.enterMobNum(Utility.readDataFromExcel(excelpath,sheetName, 0, 2));
		logger.info("Entering Mobile Number ");
		addressDetailsPage.clickOnContinueButton();
		Thread.sleep(3000);
		logger.warning("Check Address Details");
		logger.info("clicking On Continue Button ");
	}
	@Test
	public void valiadatePolicyCount() {
		int textCount = resultPage.getCountFromText();
		int bannerCount = resultPage.getCountFromBanner();
		Assert.assertEquals(textCount, bannerCount, "text count not matching with banner count, TC failed");
		logger.info("valiadating Policy Count ");
	}
	@AfterClass
	public void closeApplication() {
		closeBrowser();
		logger.info("closing Application");
	}
	
}