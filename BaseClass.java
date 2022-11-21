package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class BaseClass {

	public ExtentTest logger;
	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();

	// Give one of the following arguments while calling the method: "Headless" or
	// "Normal"
	@SuppressWarnings("deprecation")
	public void invokeBrowser(String executionMode, String browserName) {

		try {
			System.out.println("Running in " + executionMode + " mode");
			System.out.println("Running in " + browserName);

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");

			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("headless");

			if (executionMode.equalsIgnoreCase("headless")) {
				try {
					if (browserName.equalsIgnoreCase("Chrome")) {
						System.setProperty("webdriver.chrome.driver",
								System.getProperty("user.dir") + "\\Drivers\\chromedriver2.exe");
						driver = new ChromeDriver(chromeOptions);
						
						logger.pass("Chrome browser invoked successfully in headless mode");
					} else if (browserName.equalsIgnoreCase("Edge")) {
						System.setProperty("webdriver.edge.driver",
								System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
						driver = new EdgeDriver(edgeOptions);
						
						logger.pass("Edge browser invoked successfully in headless mode");
					} else {
						System.out.println("no browser selected");
						System.exit(0);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					
					logger.fail("Browser invokation failed");
				}
			} else if (executionMode.equalsIgnoreCase("normal")) {
				try {
					if (browserName.equalsIgnoreCase("Chrome")) {
						System.setProperty("webdriver.chrome.driver",
								System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
						driver = new ChromeDriver();
						
						logger.pass("Chrome browser invoked successfully");
					} else if (browserName.equalsIgnoreCase("Edge")) {
						System.setProperty("webdriver.edge.driver",
								System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
						driver = new EdgeDriver();
						
						logger.pass("Edge browser invoked successfully");
					} else {
						System.out.println("no browser selected");
						System.exit(0);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					
					logger.fail("Browser invokation failed");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	/*
	 * public void takeScreenshot() {
	 * 
	 * TakesScreenshot takeScreenshot = (TakesScreenshot) driver; File sourceFile =
	 * takeScreenshot.getScreenshotAs(OutputType.FILE);
	 * 
	 * File destFile = new File(System.getProperty("user.dir") +
	 * "\\Screenshots\\" + DateUtil.timeStamp() + ".png");
	 * 
	 * try { FileUtils.copyFile(sourceFile, destFile); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	@AfterMethod
	public void close() {
		driver.close();
	}

	@AfterSuite
	public void endingReport() {
		report.flush();
	}

}