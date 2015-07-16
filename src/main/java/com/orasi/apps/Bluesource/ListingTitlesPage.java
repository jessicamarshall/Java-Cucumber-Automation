package com.orasi.apps.Bluesource;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orasi.utils.BasePage;



public class ListingTitlesPage extends BasePage{
	

	
	//***** Constructor *****
	public ListingTitlesPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		
		//wait until the page is done loading
		isDomInteractive(driver);
	}
	
	//***** all the page elements *****

	@FindBy(linkText = "New Title")
	private WebElement newTitleLink;
	
	@FindBy(css = ".alert-success.alert-dismissable")
	private WebElement successMsg;
	
	
	//***** Page interactions *****
	
	public static ListingTitlesPage returnCurrentPage(WebDriver driver){
		return new ListingTitlesPage(driver);
	}
	
	public NewTitlePage clickNewTitle(){
		newTitleLink.click();
		return new NewTitlePage(driver);
	}
	
	public boolean isSuccessMsgDisplayed(){
		waitUntilVisible(successMsg, 10);
		return successMsg.isDisplayed();
	}
	
	/**
	 * Verifies that the specified title is listed in the title table
	 * Returns true if the title was found, false if not
	 * 
	 * @author jessica.marshall
	 * @param title
	 * @return boolean
	 * 
	 */
	public boolean verifyTitleIsListedInTable(String title){
		
		List<WebElement> tdList = driver.findElements(By.tagName("td"));
		
		for(WebElement td:tdList){
			if(td.getText().equals(title)){
				//title was found in the table, return true
				return true;
			}
		}
		
		System.out.println("Title was not found in the table: " + title);
		return false;
	}
	
	/**
	 * Deletes a specified title from the table
	 * Returns a true if title was found & deleted and
	 * false if title was not found in the table
	 * 
	 * @author jessica.marshall
	 * @param title
	 * @return boolean
	 * 
	 */
	public boolean deleteTitle(String title){
		
		List<WebElement> tdList = driver.findElements(By.tagName("td"));
			
			for(WebElement td:tdList){
				if(td.getText().equals(title)){
					
					//click the trash can element in that td element
					td.findElement(By.cssSelector("a[data-method = 'delete']")).click();
					
					//accept the alert that pops up
					Alert alert = driver.switchTo().alert();
					alert.accept();
					return true;
				}
			}
			
			System.out.println("Title was not found in table, and could not be deleted: " + title);
			return false;
		
	}
	
	/**
	 * Clicks the edit icon for a specified title in the list of titles
	 * Returns the editing title page
	 * 
	 * @author jessica.marshall
	 * @param title
	 * @return boolean
	 * 
	 */
	public EditingTitlePage clickEditTitle(String title){
		List<WebElement> tdList = driver.findElements(By.tagName("td"));
		
		for(WebElement td:tdList){
			if(td.getText().equals(title)){
				
				//click the trash can element in that td element
				td.findElement(By.cssSelector(".glyphicon-pencil")).click();

				return new EditingTitlePage(driver);
			}
		}
		
		System.out.println("Title was not found in table, and could not be edited: " + title);
		return new EditingTitlePage(driver);
	}
}
