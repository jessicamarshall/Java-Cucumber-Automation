package com.orasi.stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.orasi.apps.Bluesource.LoginPage;
import com.orasi.apps.Bluesource.TopNavigationBar;
import com.orasi.apps.Bluesource.ListingTitlesPage;
import com.orasi.apps.Bluesource.NewTitlePage;
import com.orasi.apps.Bluesource.EditingTitlePage;
import com.orasi.utils.WebDriverSetup;
import com.orasi.utils.Randomness;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewTitleStepDefs {

    private String application = "";
    private String browserUnderTest = "";
    private String browserVersion = "";
    private String operatingSystem = "";
    private String runLocation = "";
    private String environment = "";
    private WebDriver driver;
    private Object currentPage;
    private String newTitle = "";
    private String editTitle = "";
	
    
    @Before(value = "@newTitle")
    public void initialize() throws InterruptedException, IOException{
		this.application = "BLUESOURCE";
		this.browserUnderTest = System.getProperty("jenkinsBrowser");
		System.out.println("Browser: " + browserUnderTest);
		if (browserUnderTest == null)
			browserUnderTest = "FIREFOX";
		this.runLocation = "LOCAL";
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
	
	@Given("^I am logged in as a company admin role$")
	public void loginAsCompanyAdmin() {
		
		currentPage = LoginPage.returnCurrentPage(driver);
		currentPage = ((LoginPage)currentPage).loginAsCompanyAdmin();
		Assert.assertTrue("Verify user is logged in", ((TopNavigationBar)currentPage).isLogoutLinkDisplayed());
	}
	
	
	@When("^I add a new title$")
	public void addANewTitle(){
		//navigate to the title page
		((TopNavigationBar)currentPage).clickAdminLink();
		currentPage = ((TopNavigationBar)currentPage).clickTitlesLink();
		
		//Add a new title
		newTitle = Randomness.randomAlphaNumeric(9);
		System.setProperty("newTitle", newTitle);
		currentPage = ((ListingTitlesPage)currentPage).clickNewTitle();
		currentPage = ((NewTitlePage)currentPage).createNewTitle(newTitle);
		
	}
	
	@Then("^I should see a success message$")
	public void verifySuccessMessage(){
		Assert.assertTrue(((ListingTitlesPage)currentPage).isSuccessMsgDisplayed());
	}
	
	@And("^I should see the title displayed in list of titles$")
	public void verifyTitleDisplayed(){
		Assert.assertTrue(((ListingTitlesPage)currentPage).verifyTitleIsListedInTable(System.getProperty("newTitle")));
	}
	
	@And("^I have added a new title$")
	public void addedANewTitle(){
		//navigate to the title page
		((TopNavigationBar)currentPage).clickAdminLink();
		currentPage = ((TopNavigationBar)currentPage).clickTitlesLink();
	}
	
	@When("^I edit the title$")
	public void editTitle(){
		editTitle = Randomness.randomAlphaNumeric(8);
		System.setProperty("editTitle", editTitle);
		currentPage = ((ListingTitlesPage)currentPage).clickEditTitle(System.getProperty("newTitle"));
		currentPage = ((EditingTitlePage)currentPage).updateTitleName(editTitle);
	}
	
	@And("^I should see the updated title in the list of titles$")
	public void verifyUpdatedTitleDisplayed(){
		Assert.assertTrue(((ListingTitlesPage)currentPage).verifyTitleIsListedInTable(System.getProperty("editTitle")));
	}
	
	@When("^I delete the title$")
	public void deleteTitle(){
		((ListingTitlesPage)currentPage).deleteTitle(System.getProperty("editTitle"));
	}
	
	@And("^I should not see the title in the list of titles$")
	public void verifyTitleIsNotListed(){
		Assert.assertFalse(((ListingTitlesPage)currentPage).verifyTitleIsListedInTable(System.getProperty("editTitle")));
	}
	
	
}

