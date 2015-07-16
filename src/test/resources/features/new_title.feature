@newTitle
Feature: New Title Functionality
		This test will validate that the company admin role can add a new title to bluesource, delete the title from bluesource
		
		Scenario: Add a new title
			Given I am logged in as a company admin role
			When I add a new title 
			Then I should see a success message
			And I should see the title displayed in list of titles
			
		Scenario: Edit the title
			Given I am logged in as a company admin role
			And I have added a new title
			When I edit the title
			Then I should see a success message
			And I should see the updated title in the list of titles
			
		Scenario: Delete the title
			Given I am logged in as a company admin role
			And I have added a new title
			When I delete the title
			Then I should see a success message
			And I should not see the title in the list of titles	
			
			