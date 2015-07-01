package com.orasi.apps.Bluesource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orasi.utils.BasePage;
import com.orasi.utils.Element;


public class DirectEmployeesPage extends BasePage{
	

	
	//***** Constructor *****
	public DirectEmployeesPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		
		//wait until the page is done loading
		isDomInteractive(driver);
	}
	
	//***** all the page elements *****

	
	//***** Page interactions *****
	
	public static DirectEmployeesPage returnCurrentPage(WebDriver driver){
		return new DirectEmployeesPage(driver);
	}
	

}
