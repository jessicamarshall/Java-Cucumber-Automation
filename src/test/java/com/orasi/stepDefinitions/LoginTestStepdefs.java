package com.orasi.stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.orasi.apps.Bluesource.LoginPage;
import com.orasi.apps.Bluesource.TopNavigationBar;
import com.orasi.utils.WebDriverSetup;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestStepdefs {

    private String application = "";
    private String browserUnderTest = "";
    private String browserVersion = "";
    private String operatingSystem = "";
    private String runLocation = "";
    private String environment = "";
    private WebDriver driver;
    private Object currentPage;
	

    @Before(value = "@login")
    public void initialize() throws InterruptedException, IOException{
		this.application = "BLUESOURCE";
		this.browserUnderTest = System.getProperty("jenkinsBrowser");
		System.out.println("Browser: " + browserUnderTest);
		if (browserUnderTest == null)
			browserUnderTest = "FIREFOX";
		this.runLocation = "REMOTE";
		this.environment = System.getProperty("jenkinsTestEnvironment");
		if(environment ==null){
			environment = "STAGING";
		}
		this.operatingSystem = System.getProperty("jenkinsOperatingSystem");
		if (operatingSystem == null)
			operatingSystem = "LINUX";
		
		WebDriverSetup setup = new WebDriverSetup(application,
				browserUnderTest, browserVersion, operatingSystem, runLocation,
				environment);
		driver = setup.initialize();
    }
    
	@After
	public void cleanUp() {
		if (driver != null)
			driver.quit();
	}
	
	@Given("^I am on the login page$")
	public void navigateToLogin() throws InterruptedException, IOException{
		currentPage = LoginPage.returnCurrentPage(driver);
		Assert.assertTrue(((LoginPage) currentPage).verifyPageDisplayed());
	}
	
	@When("^I login with the COMPANY_ADMIN role$")
	public void login_CompanyAdmin(){
		currentPage = ((LoginPage) currentPage).loginAsCompanyAdmin();
	}
	
	@When("^I login with the DEPARTMENT_ADMIN role$")
	public void login_DeptAdmin(){
		currentPage = ((LoginPage) currentPage).loginAsDeptAdmin();
	}
	
	@When("^I login with the DEPARTMENT_HEAD role$")
	public void login_DeptHead(){
		currentPage = ((LoginPage) currentPage).loginAsDeptHead();
	}
	
	@When("^I login with the UPPER_MANAGEMENT role$")
	public void login_UpperMgt(){
		currentPage = ((LoginPage) currentPage).loginAsUpperMgt();
	}
	
	@When("^I login with the MANAGEMENT role$")
	public void login_Mgt(){
		currentPage = ((LoginPage) currentPage).loginAsMgt();
	}
	
	@When("^I login with the BASE role$")
	public void login_Base(){
		currentPage = ((LoginPage) currentPage).loginAsBase();
	}
	
	@Then("^I should login successfully$")
	public void verifySuccessfulLogin(){
		Assert.assertTrue(((TopNavigationBar) currentPage).isLogoutLinkDisplayed());
	}
}
