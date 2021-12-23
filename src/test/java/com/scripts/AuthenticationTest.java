package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.flows.AuthenticationFlow;
import com.flows.MyAccountFlow;
import com.generic.BaseTest;
import com.pageFactory.AuthenticationPage;
import com.pageFactory.HomePage;
import com.pageFactory.MyAccountPage;

public class AuthenticationTest extends BaseTest {

	private AuthenticationFlow objAuthenticationFlow;
	private HomePage objHomePage;
	private AuthenticationPage objAuthenticationPage;
	private MyAccountPage objMyAccountPage;

	private MyAccountFlow objMyAccountFlow;

	public void initializeWebPagesAndFlows() {
		objAuthenticationFlow = new AuthenticationFlow(this);
		objHomePage = new HomePage(this);
		objAuthenticationPage = new AuthenticationPage(this);
		objMyAccountPage = new MyAccountPage(this);
		objMyAccountFlow = new MyAccountFlow(this);

	}

	@BeforeClass
	public void beforeMainMethod() {
		this.initializeWebEnvironment();
		this.initializeWebPagesAndFlows();

	}

	@AfterClass
	public void afterMainMethod() {
		// tearDown();
	}

	@Test(priority = 1)
	public void TCID_101_LoginFuctionality() {
		// verify HomePage is Displayed
		objHomePage.verifyLogoInHomePage();
		// Click On SignIn Option in Home Page
		objHomePage.clickOnSignInOptionInHomePage();
		// verify Authentication Page is Displayed
		objAuthenticationPage.verifyAuthenticationPageIsDisplayed();
		// Verify Flows
		objAuthenticationFlow.doLogin();
		// verification point
		objMyAccountPage.verifyUserIsLoggedInSucessfully();

	}

	@Test(priority = 2)
	public void TCID_101_VerifyTabs() {
		// Verify My Account is Displayed
		objMyAccountPage.verifyMyAccountPageIsDisplayed();
		// Verify Tabs On My Account Page
		objMyAccountFlow.verifyTabsOnMyAccountPage();
	}

}
