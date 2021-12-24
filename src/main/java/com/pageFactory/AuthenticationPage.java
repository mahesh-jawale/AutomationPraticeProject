package com.pageFactory;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.generic.BaseTest;

public class AuthenticationPage {

	private BaseTest objBaseTest;

	public AuthenticationPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	// Locators (Login)
	By loc_hdrAuthentication = By.xpath("//span[text()='	Authentication']");
	By loc_inpEmailIdInAlreadyRegisteredBox = By.xpath("//input[@id='email']");
	By loc_inpPasswordInAlreadyRegisteredBox = By.xpath("//input[@id='passwd']");
	By loc_btnSigninInAlreadyRegisteredBox = By.xpath("//button[@id='SubmitLogin']");

	// Login
	public void verifyAuthenticationPageIsDisplayed() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_hdrAuthentication));
		Reporter.log("Verify Authentication Page is Displayed", true);// if you
																		// pass
																		// true
																		// then
																		// you
																		// will
																		// see
																		// log
																		// in
																		// report
	}

	public void setEmailIdInAlreadyRegisteredBoxInAuthenticationPage(String strUserName) {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().setText(loc_inpEmailIdInAlreadyRegisteredBox,
				strUserName));
		Reporter.log("Set Email Id", true);
	}

	public void setPasswordInAlreadyRegisteredBoxInAuthenticationPage(String strPassword) {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().setText(loc_inpPasswordInAlreadyRegisteredBox,
				strPassword));
		Reporter.log("Set Password", true);
	}

	public void clickOnSignInButtonInAuthenticationPage() {
		// objBaseTest.getObjseleniumWrapperFunctions().implicitWait(10);
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().click(loc_btnSigninInAlreadyRegisteredBox));
		Reporter.log("Click On Sign in button", true);
	}

	public void getAllLinksOfLoginPage() {
		objBaseTest.getObjseleniumWrapperFunctions().implicitWait(10);
		List<WebElement> allLinkLists = objBaseTest.getDriver().findElements(By.tagName("a"));
		System.out.println("Link List Size --> " + allLinkLists.size());
		for (WebElement webElement : allLinkLists) {

			Reporter.log("All Links----> " + webElement.getText(), true);

		}

	}

	public void getIdAttributeValueOfSignInButtonFromAuthenticationPage() {
		String strSignInButtonTxt = objBaseTest.getDriver().findElement(loc_btnSigninInAlreadyRegisteredBox)
				.getAttribute("id");
		System.out.println("Id Attribute value of Sign In Button -->" + strSignInButtonTxt);
	}

}
