package com.pageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		Reporter.log("Verify header logo", true);
	}

	public void clickOnSignInOptionInHomePage() {
		Assert.assertTrue(objBaseTest.getObjseleniumWrapperFunctions().click(loc_linkSigninOption));
		Reporter.log("Click on Sign in option", true);
	}

	public void getAllLinksOfHomePage() {
		objBaseTest.getObjseleniumWrapperFunctions().implicitWait(10);
		List<WebElement> allLinkLists = objBaseTest.getDriver().findElements(By.tagName("a"));
		//System.out.println("Link List Size --> " + allLinkLists.size());
		for (WebElement webElement : allLinkLists) {

			Reporter.log("All Links----> " + webElement.getText(), true);

		}
	}

	public void verifyAllLinksOfHomePage() {
		objBaseTest.getObjseleniumWrapperFunctions().implicitWait(10);
		List<WebElement> allLinkLists = objBaseTest.getDriver().findElements(By.tagName("a"));
		//System.out.println("Link List Size --> " + allLinkLists.size());

		for (int i = 0; i < allLinkLists.size(); i++) {
			WebElement element = allLinkLists.get(i);
			objBaseTest.getObjseleniumWrapperFunctions().implicitWait(5);
			String strURL = element.getAttribute("href");
			//System.out.println("verify link---> " + strURL);

			try {

				URL link = new URL(strURL);
				// create a connection using URL object 'link'
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				// wait time 5 seconds
				objBaseTest.getObjseleniumWrapperFunctions().implicitWait(5);
				// establish connection
				httpConn.connect();

				int resCode = httpConn.getResponseCode();// return response code
															// if response code
															// is above 400 then
															// link is broken
				if (resCode >= 400) {
					System.out.println(strURL + " - " + " link is broken");
				} else {
					System.out.println(strURL + " - " + " link is working");
				}

			}

			catch (Exception e) {
				System.out.println("I got exception : " + e.getMessage());
			}

		}
	}
}
