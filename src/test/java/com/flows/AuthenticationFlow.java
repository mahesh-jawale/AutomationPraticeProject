package com.flows;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;

import com.generic.BaseTest;
import com.pageFactory.AuthenticationPage;

public class AuthenticationFlow {

	private BaseTest objBaseTest;
	private AuthenticationPage objAuthenticationPage;
	private Hashtable<String, String> objHashtable;
	private String testData = "";
	private Properties objConfig;

	public AuthenticationFlow(BaseTest baseTest) {
		this.objBaseTest = baseTest;
		objAuthenticationPage = new AuthenticationPage(objBaseTest);
		objHashtable = new Hashtable<String, String>();
		// this.createValidUserCredentials();
		this.loadConfigProperties();

	}

	public Hashtable<String, String> createValidUserCredentials() {
		objHashtable.put("EmailId", "maheshjawale4586@gmail.com");
		objHashtable.put("Password", "9922034633");
		System.out.println("Hashtable Testdata : " + objHashtable.toString());
		return objHashtable;
	}

	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			System.out.println("Path : " + System.getProperty("user.dir")
					+ "/src/test/resources/configurations/config.properties");
			objConfig.load(new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/configurations/config.properties"));
		} catch (Exception exception) {
			System.out.println("I got exception : " + exception.getMessage());
			exception.printStackTrace();
		}
	}

	public void doLogin() {

		// testData=objHashtable.get("EmailId");
		testData = objConfig.getProperty("EmailId");
		if (!testData.equals(""))
			objAuthenticationPage.setEmailIdInAlreadyRegisteredBoxInAuthenticationPage(testData);
		// testData=objHashtable.get("Password");
		testData = objConfig.getProperty("Password");
		if (!testData.equals(""))
			objAuthenticationPage.setPasswordInAlreadyRegisteredBoxInAuthenticationPage(testData);

		objAuthenticationPage.clickOnSignInButtonInAuthenticationPage();
	}

}
