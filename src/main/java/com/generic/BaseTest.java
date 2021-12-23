package com.generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	private WebDriver driver=null;
	private String strURL="http://automationpractice.com/index.php";
	private Properties objConfig;

	private SeleniumWrapperFunctions objseleniumWrapperFunctions;
	
	public void initializeWebEnvironment()
	{
		//this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		setObjseleniumWrapperFunctions(new SeleniumWrapperFunctions(this));
		//strURL=objConfig.getProperty("AUT_URL");
		System.out.println("Opening URL : "+strURL);
		driver.get(strURL);
		driver.manage().window().maximize();
		
	}
	public void loadConfigProperties(){
		try {
		objConfig = new Properties();
		System.out.println("Path : "+System.getProperty("user.dir")+"/configuration/config.properties");
		objConfig.load(new FileInputStream(System.getProperty("user.dir")+"/configuration/config.properties"));
		} catch (Exception exception) {
		System.out.println("I got exception : "+exception.getMessage());
		exception.printStackTrace();
		}
	}
	
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void tearDown()
	{
		System.out.println("Closing Browser");
		driver.close();
	}


	public SeleniumWrapperFunctions getObjseleniumWrapperFunctions() {
		return objseleniumWrapperFunctions;
	}


	public void setObjseleniumWrapperFunctions(SeleniumWrapperFunctions objseleniumWrapperFunctions) {
		this.objseleniumWrapperFunctions = objseleniumWrapperFunctions;
	}

}
