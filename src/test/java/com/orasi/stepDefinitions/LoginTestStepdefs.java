package com.orasi.stepDefinitions;

import java.io.IOException;
import java.util.logging.Logger;

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

	private static final Logger LOGGER = Logger.getLogger(LoginTestStepdefs.class.getName());
    private String application = "";
    private String browserUnderTest = "";
    private String browserVersion = "";
    private String operatingSystem = "";
    private String runLocation = "";
    private String environment = "";
    private WebDriver driver;
    private Object currentPage;
	
	@Before
	public void launchDriver() throws InterruptedException, IOException{
		this.application = "BLUESOURCE";
		this.browserUnderTest = "chrome";
		this.runLocation = "local";
		this.environment = "staging";
		this.operatingSystem = "windows";
		
		WebDriverSetup setup = new WebDriverSetup(application,
				browserUnderTest, browserVersion, operatingSystem, runLocation,
				environment);
		driver = setup.initialize();
	}
	
	@After
	public void cleanUp() {
		driver.quit();
	}
	
	@Given("^I am on the login page$")
	public void navigateToLogin(){
		currentPage = LoginPage.returnCurrentPage(driver);
		Assert.assertTrue(((LoginPage) currentPage).verifyPageDisplayed());
		//LoginPage loginPage = new LoginPage(driver);
		//Assert.assertTrue(loginPage.verifyPageDisplayed());
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
