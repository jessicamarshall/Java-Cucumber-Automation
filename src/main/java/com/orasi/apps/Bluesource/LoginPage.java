package com.orasi.apps.Bluesource;



import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orasi.utils.BasePage;
import com.orasi.utils.Constants;


public class LoginPage extends BasePage {

	//private String browserType;
	private ResourceBundle userCredentialRepo = ResourceBundle.getBundle(Constants.USER_CREDENTIALS_PATH);
	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
		//wait until the page is done loading
		isDomInteractive(driver);

	}
	
	//all the page elements
	@FindBy(id = "employee_username")
	private WebElement username;
	
	@FindBy(id = "employee_password")
	private WebElement password;
	
	@FindBy(name = "commit")
	private WebElement login;
	
	
	//***** Page interactions *****
	
	public static LoginPage returnCurrentPage(WebDriver driver){
		return new LoginPage(driver);
	}
	
	public void setUsername(String uName) {
		set(username, uName);
	}
	
	public void setPassword(String pWord) {
		set(password, pWord);
	}
	
	public boolean verifyPageDisplayed(){
		return isDisplayed(username);
		
	}
	
	public TopNavigationBar loginAsCompanyAdmin() {
		String uName = userCredentialRepo.getString("BLUESOURCE_COMPANY_ADMIN");
		String pWord = userCredentialRepo.getString("BLUESOURCE_PASSWORD");
		
		loginWithCredentials(uName, pWord);
		
		return new TopNavigationBar(driver);
	}
	
	public TopNavigationBar loginAsDeptAdmin() {
		String uName = userCredentialRepo.getString("BLUESOURCE_DEPARTMENT_ADMIN");
		String pWord = userCredentialRepo.getString("BLUESOURCE_PASSWORD");
		
		loginWithCredentials(uName, pWord);
		
		return new TopNavigationBar(driver);
	}
	
	public TopNavigationBar loginAsDeptHead() {
		String uName = userCredentialRepo.getString("BLUESOURCE_DEPARTMENT_HEAD");
		String pWord = userCredentialRepo.getString("BLUESOURCE_PASSWORD");
		
		loginWithCredentials(uName, pWord);
		
		return new TopNavigationBar(driver);
	}
	
	public TopNavigationBar loginAsUpperMgt() {
		String uName = userCredentialRepo.getString("BLUESOURCE_UPPER_MANAGEMENT");
		String pWord = userCredentialRepo.getString("BLUESOURCE_PASSWORD");
		
		loginWithCredentials(uName, pWord);
		
		return new TopNavigationBar(driver);
	}
	
	public TopNavigationBar loginAsMgt() {
		String uName = userCredentialRepo.getString("BLUESOURCE_MANAGEMENT");
		String pWord = userCredentialRepo.getString("BLUESOURCE_PASSWORD");
		
		loginWithCredentials(uName, pWord);
		
		return new TopNavigationBar(driver);
	}
	
	public TopNavigationBar loginAsBase() {
		String uName = userCredentialRepo.getString("BLUESOURCE_BASE");
		String pWord = userCredentialRepo.getString("BLUESOURCE_PASSWORD");
		
		loginWithCredentials(uName, pWord);
		
		return new TopNavigationBar(driver);
	}
	
	public void loginWithCredentials(String userName, String password){
		setUsername(userName);
		setPassword(password);
		login.click();
	}
	
	
	
	
}
