package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseClass;
import base.PageBaseClass;
import pom.ForgetInfoPage;
import pom.ForgetInfoResultPage;
import pom.HomePage;
import pom.NextPage;

public class TestCases extends BaseClass{
	
	HomePage homePage;
	NextPage nextPage;
	ForgetInfoPage forgetInfoPage;
	ForgetInfoResultPage forgetInfoResultPage;

	@Test(priority = 0)
	public void BankWebSiteNavigation() {
		
		logger = report.createTest("Bank Website Navigation", "This test case is to validate through bank website");
		
		invokeBrowser("normal","chrome"); //invoking browser
		PageBaseClass pageBase = new PageBaseClass(driver,logger);
		PageFactory.initElements(driver, pageBase);
		homePage = pageBase.openWebsite();
		nextPage = homePage.clickOption();
		nextPage.clickOption2();
	}
	
	@Test(priority = 1)
	public void ForgetInfoPage() throws Exception {
		
		logger = report.createTest("Forget Info Page", "This test case is to enter details on Forget info page");
		
		invokeBrowser("normal","chrome"); //invoking browser
		PageBaseClass pageBase = new PageBaseClass(driver,logger);
		PageFactory.initElements(driver, pageBase);
		homePage = pageBase.openWebsite();
		forgetInfoPage = homePage.clickForgetInfo();
		forgetInfoPage.enterDetails();
		forgetInfoResultPage = forgetInfoPage.findMyInfoButton();
		forgetInfoResultPage.erorrMessage();
	}
}