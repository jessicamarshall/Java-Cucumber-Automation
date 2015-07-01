package com.orasi.apps.Bluesource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orasi.utils.BasePage;
import com.orasi.utils.Element;


public class TopNavigationBar extends BasePage{
	

	
	//***** Constructor *****
	public TopNavigationBar(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		
		//wait until the page is done loading
		isDomInteractive(driver);
	}
	
	//***** all the page elements *****
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	@FindBy(linkText = "Employees")
	private WebElement employeesLink;
	
	@FindBy(linkText = "Projects")
	private WebElement projectsLink;
	
	@FindBy(linkText = "Directory")
	private WebElement directoryLink;
	
	@FindBy(linkText = "Calendar")
	private WebElement calendarLink;
	
	//***** Page interactions *****
	
	public static TopNavigationBar returnCurrentPage(WebDriver driver){
		return new TopNavigationBar(driver);
	}
	
	public boolean isLogoutLinkDisplayed(){
		return logoutLink.isDisplayed();
	}

}
