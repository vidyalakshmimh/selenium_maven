package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.PageBaseClass;

public class NextPage extends PageBaseClass {

	public NextPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@id='headerPanel']/ul[2]/li[2]/a")
	public WebElement visitWebsite;

	public void clickOption2() {
		try {
			visitWebsite.click();
			reportPass("clicked on next page successfully");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("click on next page failed");
			Assert.fail();
		}
	}

}