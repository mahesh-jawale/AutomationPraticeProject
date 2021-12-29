package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseTest {
	
	private static WebDriver driver=null;
	private String strURL="";
	private Properties objConfig;

	private SeleniumWrapperFunctions objseleniumWrapperFunctions;
	
	public void initializeWebEnvironment()
	{
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		setObjseleniumWrapperFunctions(new SeleniumWrapperFunctions(this));
		strURL=objConfig.getProperty("AUT_URL");
		System.out.println("Opening URL : "+strURL);
		driver.get(strURL);
		driver.manage().window().maximize();
		
	}
	public void loadConfigProperties(){
		try {
		objConfig = new Properties();
		System.out.println("Path : "+System.getProperty("user.dir")+"/src/test/resources/configurations/config.properties");
		objConfig.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configurations/config.properties"));
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
	
	public void getScreenShotPath(String testCaseName) throws IOException
	{
		TakesScreenshot screenShot	=(TakesScreenshot)getDriver();
		System.out.println(screenShot);
		File source=screenShot.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+".png";
		System.out.println(destinationFile);
		FileUtils.copyFile(source,new File(destinationFile));
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("<a href="+destinationFile+">Screenshot link</a>");
	
	}

}
