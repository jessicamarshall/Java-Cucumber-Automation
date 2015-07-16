package com.orasi.apps.Bluesource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orasi.utils.BasePage;



public class NewTitlePage extends BasePage{
	

	
	//***** Constructor *****
	public NewTitlePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		
		//wait until the page is done loading
		isDomInteractive(driver);
	}
	
	//***** all the page elements *****

	@FindBy(id = "title_name")
	private WebElement titleInput;
	
	@FindBy(name = "commit")
	private WebElement createTitleInput;
	
	//***** Page interactions *****
	
	public static NewTitlePage returnCurrentPage(WebDriver driver){
		return new NewTitlePage(driver);
	}
	
	public ListingTitlesPage createNewTitle(String titleName){
		set(titleInput, titleName);
		createTitleInput.click();
		return new ListingTitlesPage(driver);
		
		
	}
	

}
