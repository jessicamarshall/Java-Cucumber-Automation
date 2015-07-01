@Login
Feature: Validate login functionality
	This feature tests that you can login to bluesource using the different roles
	
	Scenario Outline: Verify login with different roles
		Given I am on the login page
		When I login with the <type> role
		Then I should login successfully
		
	Examples:
			| type				|
			|COMPANY_ADMIN		|
			|DEPARTMENT_ADMIN	|
			|DEPARTMENT_HEAD	|
			|UPPER_MANAGEMENT	|	
			|MANAGEMENT			|
			|BASE				|
