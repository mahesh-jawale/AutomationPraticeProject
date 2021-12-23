package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flows.MyAccountFlow;
import com.generic.BaseTest;

import com.pageFactory.MyAccountPage;

public class MyAccountTest extends BaseTest {
	
	private MyAccountFlow objMyAccountFlow;
	private MyAccountPage objMyAccountPage;
	
	
/*	public void initializeWebPagesAndFlows()
	{
		objMyAccountFlow =new MyAccountFlow(this);
		objMyAccountPage=new MyAccountPage(this);
	}
	
	
	
	@BeforeTest
	public void beforeMainMethod()
	{
		
		this.initializeWebPagesAndFlows();
	
	}
	
	@AfterClass
	public void afterMainMethod()
	{
		//tearDown();
	}
	
	@Test(priority=2)
	public void TCID_101_VerifyTabs()
	{
		//Verify My Account is Displayed
		objMyAccountPage.verifyMyAccountPageIsDisplayed();
		//Verify Tabs On My Account Page
		objMyAccountFlow.verifyTabsOnMyAccountPage();
	}
*/
}
