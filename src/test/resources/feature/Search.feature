Feature: Search Functionality

Scenario: Verify that user should be able to search a valid product
Given User opens the Application
When User enters valid product "HP" into Search box feild
And User clicks on Search button
Then User should get valid product displayed in search results

Scenario: User searches for an invalid product
Given User opens the Application
When User enters invalid product "Honda" into Search box feild
And User clicks on Search button
Then User should get a message about no other product matching

Scenario: User searches without the product
Given User opens the Application
When User dont enter any product into Search box feild
And User clicks on Search button
Then User should get a message about no other product matching