package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import com.generic.BaseTest;

public class HomePage {

	private BaseTest objBaseTest;

	public HomePage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	// Locators
	By loc_hdrLogo = By.xpath("//div[@id='header_logo']");
	By loc_linkSigninOption = By.xpath("//a[@class='login']");

	public void verifyLogoInHomePage() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_hdrLogo));
		Reporter.log("Verify header logo",true);
	}

	public void clickOnSignInOptionInHomePage() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().click(loc_linkSigninOption));
		Reporter.log("Click on Sign in option",true);
	}

}
