package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.PageBaseClass;
import utilities.ExcelUtil;

public class ForgetInfoResultPage extends PageBaseClass{
	
	public ForgetInfoResultPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath = "//*[@id='rightPanel']/p")
	public WebElement errorMessage;
	
	public void erorrMessage() throws Exception {
		
		ExcelUtil.setExcelPath(System.getProperty("user.dir")+"\\Excel\\Output Data.xlsx", "Sheet1");
		
		try {
			String errorMsg = errorMessage.getText();
			reportPass("Retrieved error message successfully");
			ExcelUtil.setCellData(errorMsg, 0, 0);
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Error message retrival failed");
			Assert.fail();
		}
	}

}