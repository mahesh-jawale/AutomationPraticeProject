package com.flows;

import java.util.Hashtable;

import com.generic.BaseTest;
import com.pageFactory.AuthenticationPage;


public class AuthenticationFlow {
	
	private BaseTest objBaseTest;
	private AuthenticationPage objAuthenticationPage;
	private Hashtable<String,String> objHashtable;
	private String testData="";
	
	public AuthenticationFlow(BaseTest baseTest) {
		this.objBaseTest = baseTest;
		objAuthenticationPage=new AuthenticationPage(objBaseTest);
		objHashtable=new Hashtable<String,String>();
		this.createValidUserCredentials();
	}

	
	
	public Hashtable<String,String> createValidUserCredentials()
	{
		objHashtable.put("EmailId", "maheshjawale4586@gmail.com");
		objHashtable.put("Password", "9922034633");
		System.out.println("Hashtable Testdata : "+objHashtable.toString());
		return objHashtable;
	}
	
	public void doLogin()
	{
		testData=objHashtable.get("EmailId");
		if(!testData.equals(""))
			objAuthenticationPage.setEmailIdInAlreadyRegisteredBoxInAuthenticationPage(testData);
		testData=objHashtable.get("Password");
		if(!testData.equals(""))
		objAuthenticationPage.setPasswordInAlreadyRegisteredBoxInAuthenticationPage(testData);
		
		objAuthenticationPage.clickOnSignInButtonInAuthenticationPage();
	}
	
	



}
