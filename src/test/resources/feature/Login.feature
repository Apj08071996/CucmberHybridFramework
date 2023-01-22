Feature: LoginFunctionality

Scenario Outline: Verify that user should be able to login with valid credentials
Given User navigates to login page
When User enters valid email <E-Mail> into email address feild
And User enters valid password <Password> into password feild
And User clicks on login button
Then User should get succesfully logged in
Examples:
|E-Mail                   |Password      |
|ajinkyajagdale1@gmail.com|12345				 |
|ajinkyajagdale2@gmail.com|12345				 |
|ajinkya12345@gmail.com   |12345				 |
|ajjagdale8@gmail.com     |12345				|

Scenario: Verify that user unable to login with invalid credentials
Given User navigates to login page
When User enters invalid email "ajinkya1111222333@gmail.com" into email address feild
And User enters invalid password "1234" into password feild
And User clicks on login button
Then User is unable to login into application and should get proper warning message

Scenario: Verify that user unable to login with invalid email and valid password
Given User navigates to login page
When User enters invalid email "ajinkya12qw2@gmail.com" into email address feild
And User enters valid password "12345" into password feild
And User clicks on login button
Then User is unable to login into application and should get proper warning message

Scenario: Verify that user is unable to login with valid email and invalid password
Given User navigates to login page
When User enters valid email "ajinkya12345@gmail.com" into email address feild
And User enters invalid password "1234" into password feild
And User clicks on login button
Then User is unable to login into application and should get proper warning message

Scenario: Verify that user is unable to login without providing any credentials
Given User navigates to login page
When User dont enter anything into email address feild
And User dont enter anything into password feild
And User clicks on login button
Then User is unable to login into application and should get proper warning message