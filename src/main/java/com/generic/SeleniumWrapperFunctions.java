package com.generic;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrapperFunctions {

	private BaseTest objBaseTest;

	public SeleniumWrapperFunctions(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	public boolean setText(By locator, String strInputValue) {
		try{
		objBaseTest.getDriver().findElement(locator).sendKeys(strInputValue);
		
		return true;
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}
	
	public boolean selectDropDown(By locator,String strDropDownOption)
	{
		try{
			
		WebElement dropDown=objBaseTest.getDriver().findElement(locator);
		Select selectDropDown=new Select(dropDown);
		selectDropDown.selectByVisibleText(strDropDownOption);
			
		WebElement option = selectDropDown.getFirstSelectedOption();
		String selectedOption = option.getText();
		System.out.println("Selected option:"+selectedOption);
		verifySelectedDropDownOption(selectedOption, strDropDownOption);
		return true;
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}
	
	public boolean selectRadioButton(By locator)
	{
		try{
		WebElement radioButton=objBaseTest.getDriver().findElement(locator);
		radioButton.click();
		verifyRadioButtonIsSelected(radioButton);
		return true;
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}
	
	
	public void verifyRadioButtonIsSelected(WebElement radioButton)
	{
		boolean bolVar=radioButton.isSelected();
		System.out.println(bolVar);
		if(bolVar==true)
		{
			System.out.println("Radiobutton selected");
		}
		else
		{
			System.out.println("Radiobutton not selected");
		}
	}
	
	
	public void verifySelectedDropDownOption(String selectedOption,String strDate)
	{
		if(selectedOption.equals(strDate))
		{
			System.out.println("Selected option is equal to required option");
		}
		else
		{
			
			System.out.println("Selected option is equal not to required option");
			
		}
	}
	
	
	public String getText(By locator)
	{
		try
		{
			String strReturnVal=objBaseTest.getDriver().findElement(locator).getText();
			return strReturnVal;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return null;
		}
	}
	//new method
	public boolean click(By locator)
	{
		try
		{ 
			/*//Normal Selenium Code
			objBaseTest.getDriver().findElement(locator).click();
			return true;*/
			
			//JavaScript Code
			WebElement element=objBaseTest.getDriver().findElement(locator);
			JavascriptExecutor executor=(JavascriptExecutor)objBaseTest.getDriver();
			executor.executeScript("arguments[0].click();", element);
			return true;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return false;
		}
	}
	
	//new method
	public boolean isSelected(By locator)
	{
		try
		{
			Boolean bolVar=objBaseTest.getDriver().findElement(locator).isSelected();
			return bolVar;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return false;
		}
	}
	
	//new method
	public boolean navigateBack()
	{
		try
		{
			objBaseTest.getDriver().navigate().back();
			return true;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return false;
		}
	}
	
	
	//new method
	public boolean navigateForward()
	{
		try
		{
			objBaseTest.getDriver().navigate().forward();
			return true;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return false;
		}
	}
	
	//new method
	public boolean navigateRefresh()
	{
		try
		{
			objBaseTest.getDriver().navigate().refresh();
			return true;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return false;
		}
	}
	
	//new method
	public boolean switchToAlert()
	{
		try
		{
			objBaseTest.getDriver().switchTo().alert();
			return true;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return false;
		}
	}
	
	//new method
	public boolean sendKeysToAlert(String strText)
	{
		try
		{
			objBaseTest.getDriver().switchTo().alert().sendKeys(strText);;
			return true;
			
		}
		catch(Exception exception)
		{
			System.out.println("I got exception : "+exception.getMessage());
			return false;
		}
	}
	
	//new method
		public boolean dragAndDrop(By fromLocator,By toLocator)
		{
			try
			{
				WebElement from = objBaseTest.getDriver().findElement(fromLocator);
				//objBaseTest.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				Thread.sleep(30);
				WebElement to = objBaseTest.getDriver().findElement(toLocator);
				Actions act=new Actions(objBaseTest.getDriver());
				act.dragAndDrop(from,to).build().perform();
				return true;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return false;
			}
		}
	
	
		//new method
		public String getTitle()
		{
			try
			{
				String strTitle=objBaseTest.getDriver().getTitle();
				return strTitle;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return null;
			}
		}
		
		//new method
		public String getCurrentUrl()
		{
			try
			{
				String strCurrentURL=objBaseTest.getDriver().getCurrentUrl();
				return strCurrentURL;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return null;
			}
		}
		
		//new method
		public boolean close()
		{
			try
			{
				objBaseTest.getDriver().close();
				return true;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return false;
			}
		}
		
		//new method
		public boolean isDisplayed(By locator)
		{
			try
			{
				objBaseTest.getDriver().findElement(locator).isDisplayed();
				return true;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return false;
			}
		}
		
		public boolean explicitWait(By locator,int waitTime)
		{
			try
			{
				WebDriverWait objWebDriverWait=new WebDriverWait(objBaseTest.getDriver(),waitTime); 
				objWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				return true;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return false;
			}
		}
		
		public boolean implicitWait(int waitTime)
		{
			try
			{
				objBaseTest.getDriver().manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
				return true;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return false;
			}
		}
		
		
		public boolean fluentWait(By locator,int waitTime,int polling)
		{
			
			try
			{
				Wait<WebDriver> objWait=new FluentWait<WebDriver>(objBaseTest.getDriver())
						.withTimeout(Duration.ofSeconds(waitTime))
						.pollingEvery(Duration.ofSeconds(polling))
						.withMessage("Your desired element is not found")
						.ignoring(NoSuchElementException.class);
				objWait.until(ExpectedConditions.presenceOfElementLocated(locator));
				return true;
				
			}
			catch(Exception exception)
			{
				System.out.println("I got exception : "+exception.getMessage());
				return false;
			}
		}
		
		public boolean scrollDownToBottom()
		{
		try{

		JavascriptExecutor js = (JavascriptExecutor)objBaseTest.getDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		return true;
		}catch(Exception e){
		System.out.println("Expection is: "+e.getMessage());
		e.printStackTrace();
		return false;
		}
		}
		
		public boolean scrollUp()
		{
		try{

		JavascriptExecutor js = (JavascriptExecutor)objBaseTest.getDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollTop)");
		return true;
		}catch(Exception e){
		System.out.println("Expection is: "+e.getMessage());
		e.printStackTrace();
		return false;
		}
		}
	

}
