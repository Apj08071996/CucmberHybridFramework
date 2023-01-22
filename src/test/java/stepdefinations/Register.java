package stepdefinations;

import java.util.Map;

import static org.junit.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccesPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtility;

public class Register
{
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccesPage accountSuccesPage;

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() 
	{
		driver=DriverFactory.getDriver();
		homePage=new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		registerPage=homePage.clickOnRegisterOption();
		
		
	}
	
	@When("User enters below details")
	public void user_enters_below_details(DataTable dataTable) 
	{

		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
	
		registerPage.enterFirstName(dataMap.get("FirstName"));
		registerPage.enterLastName(dataMap.get("LastName"));
		registerPage.enterEmailAddress(CommonUtility.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("Telephone"));
		registerPage.enterPassword(dataMap.get("Password"));
		registerPage.enterPasswordIntoConfirmPassword(dataMap.get("PasswordConfirm"));

	}
	
	@When("User enters below details with duplicate email")
	public void User_enters_below_details_with_duplicate_email(DataTable dataTable)
	{

		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
	
		registerPage.enterFirstName(dataMap.get("FirstName"));
		registerPage.enterLastName(dataMap.get("LastName"));
		registerPage.enterEmailAddress(dataMap.get("E-Mail"));
		registerPage.enterTelephone(dataMap.get("Telephone"));
		registerPage.enterPassword(dataMap.get("Password"));
		registerPage.enterPasswordIntoConfirmPassword(dataMap.get("PasswordConfirm"));
	}

	@When("User selects Privacy Policy checkbox")
	public void user_selects_privacy_policy_checkbox()
	{
		registerPage.clickOnPrivacyPolicyCheckbox();
		
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() 
	{
		accountSuccesPage=registerPage.clickOnContinueButton();	
	}

	@Then("User should navigates to Account Succes page")
	public void user_should_navigates_to_account_succes_page()
	{
		
		boolean status=accountSuccesPage.displayStatusOfYourAccountHasBeenCreated().contains("Your Account Has Been Created!");
		assertTrue(status);
	}

	@When("User selects Yes for Newsletter radio button")
	public void user_selects_yes_for_newsletter_radio_button()
	{
		registerPage.selectYesNewsLetterOption();
		

	}




	@Then("User should get proper warning message about dupliacte email")
	public void user_should_get_proper_warning_message_about_duplicate_email() 
	{
		String actual=registerPage.checkDuplicateEmailWarningMessage();
		assertEquals(actual,"Warning: E-Mail Address is already registered!");
	}

	@When("User doesn't enter anything into the feild")
	public void user_doesn_t_enter_anything_into_the_feild()
	{
		
		
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmailAddress("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterPasswordIntoConfirmPassword("");
		
	}
	
	@Then("User should get proper warning message about all mandatory feilds")
	public void User_should_get_proper_warning_message_about_all_mandatory_feilds()
	{
		
		assertEquals(registerPage.getFirstNameWarningMessage(),"First Name must be between 1 and 32 characters!");
		assertEquals(registerPage.getLastNameWarningMessage(), "Last Name must be between 1 and 32 characters!");
		assertEquals(registerPage.getEmailAddressWarningMessage(), "E-Mail Address does not appear to be valid!");
		assertEquals(registerPage.getTelephoneWarningMessage(),"Telephone must be between 3 and 32 characters!");
		assertEquals(registerPage.getPasswordWarningMessage(), "Password must be between 4 and 20 characters!");
		System.out.println(registerPage.getPrivacyPolicyWarningMessage());
		assertTrue(registerPage.getPrivacyPolicyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
	}

}
