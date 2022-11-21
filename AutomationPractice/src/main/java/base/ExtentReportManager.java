package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.DateUtil;

public class ExtentReportManager {

	public static ExtentReports report;

	// Extent report manager
	public static ExtentReports getReportInstance() {
		if (report == null) {

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\Test Reports\\" + DateUtil.timeStamp() + ".html");
			// create ExtentReports and attach reporter(s)
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

		}
		return report;
	}
}