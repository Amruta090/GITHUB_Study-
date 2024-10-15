package CoverFoxPOM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage {
	@FindBy(xpath = "//div[contains(text(),'matching Health')]")
	private WebElement resultText;
	@FindBy(className = "plan-card-container")
	private List<WebElement> planList;

	public CoverFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getCountFromText() {
		Reporter.log("getting policy count from text displayed ..", true);
		String resultInString = resultText.getText().substring(0, 2);
		int countFromText = Integer.parseInt(resultInString);
		return countFromText;
	}

	public int getCountFromBanner() {
		Reporter.log("getting policy count from banners displayed ..", true);
		int countFromBanner = planList.size();
		return countFromBanner;
	}
}