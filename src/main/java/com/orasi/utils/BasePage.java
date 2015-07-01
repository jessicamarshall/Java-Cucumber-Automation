package com.orasi.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver = null;
	private int timeout = 60;
	
	//Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
	}

	//***** Page Loaded Methods *****
	
	/**
	 * This uses the HTML DOM readyState property to wait until a page is finished loading.  It will wait for
	 * the ready state to be either 'interactive' or 'complete'.  
	 * 
	 * @param	class	the class calling this method - used so can initialize the page class repeatedly
	 * @param 	driver	The webDriver
	 * @param	obj		The element you are waiting to display on the page
	 * @version	12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	False if the element is not found after the timeout, true if is found
	 */
	public boolean isDomInteractive(WebDriver driver){
		this.driver = driver;
		int count = 0;
		Object obj = null;

		do {
			//this returns a boolean
			obj = ((JavascriptExecutor) driver).executeScript(
                    "var result = document.readyState; return (result == 'complete' || result == 'interactive');");
			if (count == this.timeout)
				break;
			else{
				Sleeper.sleep(500);
				count++;
			
			}
		} while (obj.equals(false));
		
		
		if (count < this.timeout*2){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Overloaded method - gives option of specifying a timeout.
	 * This uses the HTML DOM readyState property to wait until a page is finished loading.  It will wait for
	 * the ready state to be either 'interactive' or 'complete'.  
	 * 
	 * @param 	driver	The webDriver
	 * @param	timeout	Integer value of number seconds to wait for a page to finish loaded before quiting
	 * @version	12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	False if the element is not found after the timeout, true if is found
	 */
	public boolean isDomInteractive(WebDriver driver, int timeout){
		this.timeout = timeout;
		return isDomInteractive(driver);
	}
	
	/**
	 * This uses protractor method to wait until a page is ready - notifyWhenNoOutstandingRequests
	 * 
	 * @param 	driver	The webDriver
	 * @version	10/16/2014
	 * @author 	Justin Phlegar
	 */
	public static void waitForAngularRequestsToFinish(JavascriptExecutor driver) {
		    	
		driver.executeAsyncScript("var callback = arguments[arguments.length - 1];" +
    				"angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");

    }
	
	/**
	 * A more strict version of isDomInteractive.  
	 * This uses the HTML DOM readyState property to wait until a page is finished loading.  It will wait for
	 * the ready state to be 'complete'.  
	 * 
	 * @param	class	the class calling this method - used so can initialize the page class repeatedly
	 * @param 	driver	The webDriver
	 * @param	obj		The element you are waiting to display on the page
	 * @version	12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	False if the element is not found after the timeout, true if is found
	 */
	public boolean isDomComplete(WebDriver driver){
		this.driver = driver;
		int count = 0;
		Object obj = null;

		do {
			//this returns a boolean
			obj = ((JavascriptExecutor) driver).executeScript(
                    "var result = document.readyState; return (result == 'complete');");
			if (count == this.timeout)
				break;
			else{
				Sleeper.sleep(500);
				count++;
			
			}
		} while (obj.equals(false));
		
		
		if (count < this.timeout*2){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Overloaded method - gives option of specifying a timeout.
	 * A more strict version of isDomInteractive
	 * This uses the HTML DOM readyState property to wait until a page is finished loading.  It will wait for
	 * the ready state to be 'complete'.  
	 * 
	 * @param 	driver	The webDriver
	 * @param	timeout	Integer value of number seconds to wait for a page to finish loaded before quiting
	 * @version	12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	False if the element is not found after the timeout, true if is found
	 */
	public boolean isDomComplete(WebDriver driver, int timeout){
		this.timeout = timeout;
		return isDomInteractive(driver);
	}
	
	
	//*****
	public void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(
				"arguments[0].scrollIntoView(true);arguments[0].click();",
				element);
	}
	

	public void set(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void focusClick(WebElement element){
		new Actions(driver).moveToElement(element).click().perform();
	}
	
	public void waitUntilClickable(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilTextToBePresent(WebElement element, int timeOut, String text) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitUntilToBeSelected(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitUntilTextToBePresentInValue(WebElement element, int timeOut, String text) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}
	
	public void waitUntilVisible(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilTitleIs(String title, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void waitUntilTitleContains(String title, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	
	
}
