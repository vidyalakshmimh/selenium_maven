package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.PageBaseClass;

public class HomePage extends PageBaseClass {

	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@id='rightPanel']/ul[3]/li[2]/a")
	public WebElement option;
	
	@FindBy(xpath = "//*[@id='loginPanel']/p[1]/a")
	public WebElement forgetInfoLink;

	public NextPage clickOption() {
		try {
			option.click();
			reportPass("Clicked on HomePage successfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Click on HomePage failed");
			Assert.fail();
		}

		NextPage nextPage = new NextPage(driver, logger);
		PageFactory.initElements(driver, nextPage);
		return nextPage;
	}
	
	public ForgetInfoPage clickForgetInfo() {
		try {
			forgetInfoLink.click();
			reportPass("Clicked on forget Info Link successfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Click on forget Info Link failed");
			Assert.fail();
		}

		ForgetInfoPage forgetInfoPage = new ForgetInfoPage(driver, logger);
		PageFactory.initElements(driver, forgetInfoPage);
		return forgetInfoPage;
	}

}