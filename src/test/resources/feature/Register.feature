Feature: Register functionality

Scenario: Verify that user should able to Register Account using only mandatory feild
Given User navigates to Register Account page
When User enters below details
|FirstName      |ajinkya									|
|LastName       |Jagdale									|
|Telephone 			|123456789								|
|Password  			|12345										|
|PasswordConfirm|12345										|
And User selects Privacy Policy checkbox
And User clicks on Continue button
Then User should navigates to Account Succes page

Scenario: Verify that user should be able to Register Account using all the feilds
Given User navigates to Register Account page
When User enters below details
|FirstName										|Ajinkya									 |
|LastName											|Jagdale								   |												
|Telephone										|123456                    |
|Password											|12345                     |
|PasswordConfirm              |12345                     |
And User selects Yes for Newsletter radio button
And User selects Privacy Policy checkbox
And User clicks on Continue button
Then User should navigates to Account Succes page

Scenario: Verify that user is unable to Register Account with duplicate email 
Given User navigates to Register Account page
When User enters below details with duplicate email
|FirstName										|Ajinkya									 |
|LastName											|Jagdale								   |
|E-Mail												|ajinkyajagdale1@gmail.com |													
|Telephone										|123456                    |
|Password											|12345                     |
|PasswordConfirm              |12345                     |
And User selects Yes for Newsletter radio button
And User selects Privacy Policy checkbox
And User clicks on Continue button
Then User should get proper warning message about dupliacte email

Scenario: 	Verify that user is unable to Register Account without providing any feild
Given User navigates to Register Account page
When User doesn't enter anything into the feild
And User clicks on Continue button
Then User should get proper warning message about all mandatory feilds