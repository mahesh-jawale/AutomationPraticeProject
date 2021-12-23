package com.flows;

import com.generic.BaseTest;

import com.pageFactory.MyAccountPage;

public class MyAccountFlow {
	private BaseTest objBaseTest;
	private MyAccountPage objMyAccountPage;

	public MyAccountFlow(BaseTest baseTest) {
		this.objBaseTest = baseTest;
		objMyAccountPage = new MyAccountPage(objBaseTest);

	}

	public void verifyTabsOnMyAccountPage() {
		objMyAccountPage.verifyTabWomenInMyAccountPageIsDisplayed();
		objMyAccountPage.verifyTabDressesInMyAccountPageIsDisplayed();
		objMyAccountPage.verifyTabTShirtsInMyAccountPageIsDisplayed();
	}

}
