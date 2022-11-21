package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import pom.HomePage;
import utilities.DateUtil;

public class PageBaseClass extends BaseClass {

	public ExtentTest logger;

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public HomePage openWebsite() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		HomePage homePage = new HomePage(driver, logger);
		PageFactory.initElements(driver, homePage);
		return homePage;
	}

	// Report for pass status
	public void reportPass(String message) {
		logger.pass(message);
	}

	// Report for fail status
	public void reportFail(String message) {
		takeScreenshotOnFailure();
		logger.fail(message);
	}

	// Screenshot function
	public void takeScreenshotOnFailure() {

		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + DateUtil.timeStamp() + ".png");

		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\Screenshots\\" + DateUtil.timeStamp() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
