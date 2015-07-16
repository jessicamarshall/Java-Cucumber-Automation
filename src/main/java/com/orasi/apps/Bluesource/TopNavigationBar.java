package com.orasi.apps.Bluesource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orasi.utils.BasePage;



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
	
	@FindBy(xpath = "//a[text() = 'Admin ']")
	private WebElement adminLink;
	
	@FindBy(linkText = "Departments")
	private WebElement deptLink;
	
	@FindBy(linkText = "Titles")
	private WebElement titlesLink;
	
	//***** Page interactions *****
	
	public static TopNavigationBar returnCurrentPage(WebDriver driver){
		return new TopNavigationBar(driver);
	}
	
	public boolean isLogoutLinkDisplayed(){
		return isDisplayed(logoutLink);
	}
	
	public void clickAdminLink(){
		adminLink.click();
	}
	
	public ListingTitlesPage clickTitlesLink(){
		titlesLink.click();
		return new ListingTitlesPage(driver);
	}
	
	public void clickLogoutLink(){
		logoutLink.click();
	}
	
	public boolean waitUntilVisible(){
		return waitUntilVisible(logoutLink, 5);
	}
	

}
