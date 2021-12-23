package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.BaseTest;

public class AuthenticationPage {
	
	private BaseTest objBaseTest;
	
	public AuthenticationPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}
	
	//Locators (Login)
	By loc_hdrAuthentication= By.xpath("//span[text()='	Authentication']");
	By loc_inpEmailIdInAlreadyRegisteredBox =By.xpath("//input[@id='email']");
	By loc_inpPasswordInAlreadyRegisteredBox =By.xpath("//input[@id='passwd']");
	By loc_btnSigninInAlreadyRegisteredBox =By.xpath("//button[@id='SubmitLogin']");
	

	
	//Login
	public void verifyAuthenticationPageIsDisplayed()
	{
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().isDisplayed(loc_hdrAuthentication));
	}
	
	public void setEmailIdInAlreadyRegisteredBoxInAuthenticationPage(String strUserName)
	{
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().setText(loc_inpEmailIdInAlreadyRegisteredBox,strUserName));
	}
	
	public void setPasswordInAlreadyRegisteredBoxInAuthenticationPage(String strPassword)
	{
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().setText(loc_inpPasswordInAlreadyRegisteredBox,strPassword));
	}
	
	public void clickOnSignInButtonInAuthenticationPage() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().click(loc_btnSigninInAlreadyRegisteredBox));
	}
	
	
	
	
}
