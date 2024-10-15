package CoverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
// variables
	@FindBy (className="mp-input-text") private WebElement  pincodeField;

	@FindBy(id ="want-expert")private WebElement mobNumField;
	@FindBy(className ="next-btn")private WebElement continueButton;

// constructor
	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
// methods

	public void enterPinCode(String pinCode) {
		Reporter.log("enetring pincode..", true);
		pincodeField.sendKeys(pinCode);
	}

	public void enterMobNum(String mobNum) {
		Reporter.log("enetring mobile number..", true);
		mobNumField.sendKeys(mobNum);
	}

	public void clickOnContinueButton() {
		Reporter.log("clicking on continue button..", true);
		continueButton.click();
	}
}