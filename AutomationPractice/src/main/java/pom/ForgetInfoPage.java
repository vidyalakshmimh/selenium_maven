package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.PageBaseClass;
import utilities.ExcelUtil;

public class ForgetInfoPage extends PageBaseClass {

	public ForgetInfoPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@id='firstName']")
	public WebElement firstName;

	@FindBy(xpath = "//*[@id='lastName']")
	public WebElement lastName;

	@FindBy(xpath = "//*[@id='address.street']")
	public WebElement address;

	@FindBy(xpath = "//*[@id='address.city']")
	public WebElement city;

	@FindBy(xpath = "//*[@id='address.state']")
	public WebElement state;

	@FindBy(xpath = "//*[@id='address.zipCode']")
	public WebElement zipCode;

	@FindBy(xpath = "//*[@id='ssn']")
	public WebElement SSN;

	@FindBy(xpath = "//*[@id='lookupForm']/table/tbody/tr[8]/td[2]/input")
	public WebElement findMyInfoButton;

	public void enterDetails() throws Exception {
		ExcelUtil.setExcelPath(System.getProperty("user.dir")+"\\Excel\\Input Data.xlsx", "Sheet1");
		try {
			firstName.sendKeys(ExcelUtil.getCellData(0, 1));
			lastName.sendKeys(ExcelUtil.getCellData(1, 1));
			address.sendKeys(ExcelUtil.getCellData(2, 1));
			city.sendKeys(ExcelUtil.getCellData(3, 1));
			state.sendKeys(ExcelUtil.getCellData(4, 1));
			zipCode.sendKeys(ExcelUtil.getCellData(5, 1));
			SSN.sendKeys(ExcelUtil.getCellData(6, 1));
			reportPass("Details entered on forget info page successfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Details entry on forget info page got failed");
			Assert.fail();
		}
	}

	public ForgetInfoResultPage findMyInfoButton() {
		
		try {
			findMyInfoButton.click();
			reportPass("Clicked on forget info button successfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportPass("Click on forget info button failed");
			Assert.fail();
		}
		
		ForgetInfoResultPage forgetInfoResultPage = new ForgetInfoResultPage(driver, logger);
		PageFactory.initElements(driver, forgetInfoResultPage);
		return forgetInfoResultPage;

	}

}