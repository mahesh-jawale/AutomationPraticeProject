package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import com.generic.BaseTest;

public class MyAccountPage {

	private BaseTest objBaseTest;

	public MyAccountPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	// Locators
	By loc_hdrMyAccount = By.xpath("//span[text()='My account']");
	By loc_TabWomenInMyAccount = By.xpath("//a[text()='Womenn']");
	By loc_TabDressesInMyAccount = By.xpath("//a[text()='Dresses']");
	By loc_TabTShirtsInMyAccount = By.xpath("//a[text()='T-shirts']");
	By loc_optionSignOutInMyAccount = By.xpath("//a[@class='logout']");

	public void verifyMyAccountPageIsDisplayed() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_hdrMyAccount));
		Reporter.log("Verify header logo",true);
	}

	public void verifyTabWomenInMyAccountPageIsDisplayed() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_TabWomenInMyAccount));
		Reporter.log("Verify Women tab",true);
	}

	public void verifyTabDressesInMyAccountPageIsDisplayed() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_TabDressesInMyAccount));
		Reporter.log("Verify Dresses tab",true);
	}

	public void verifyTabTShirtsInMyAccountPageIsDisplayed() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_TabTShirtsInMyAccount));
		Reporter.log("Verify TShirts tab",true);
	}

	public void verifyUserIsLoggedInSucessfully() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_optionSignOutInMyAccount));
		Reporter.log("Verify user is logged in successfully",true);
	}

}
