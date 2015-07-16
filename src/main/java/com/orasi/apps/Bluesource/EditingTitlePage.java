package com.orasi.apps.Bluesource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orasi.utils.BasePage;



public class EditingTitlePage extends BasePage{
	

	
	//***** Constructor *****
	public EditingTitlePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		
		//wait until the page is done loading
		isDomInteractive(driver);
	}
	
	//***** all the page elements *****
	@FindBy (id = "title_name")
	private WebElement titleInput;
	
	@FindBy (name = "commit")
	private WebElement updateTitleInput;
	
	@FindBy (linkText = "Back")
	private WebElement backLink;
	
	
	//***** Page interactions *****
	
	public static EditingTitlePage returnCurrentPage(WebDriver driver){
		return new EditingTitlePage(driver);
	}
	
	/**
	 * This method enters a new title and clicks update
	 * 
	 * @param newTitle
	 * @return ListingTitlesPage
	 * @author jessica.marshall
	 */
	public ListingTitlesPage updateTitleName(String newTitle){
		set(titleInput, newTitle);
		updateTitleInput.click();
		return new ListingTitlesPage(driver);
	}
	
	

}
