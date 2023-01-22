package stepdefinations;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login 
{
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page()
	{
		driver=DriverFactory.getDriver();
		homePage=new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		
		loginPage=homePage.clickOnLoginButton();
		
	}

	@When("^User enters valid email (.+) into email address feild$")
	public void user_enters_valid_email_into_email_address_feild(String validEmail)
	{
	 
	  loginPage.enterEmailAddress(validEmail);
	 
	}

	@When("^User enters valid password (.+) into password feild$")
	public void user_enters_valid_password_into_password_feild(String validPassword)
	{
		loginPage.enterPassword(validPassword);
	  
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button()
	{
		
		accountPage=loginPage.clickOnLoginButton();
	   
	   
	}

	@Then("User should get succesfully logged in")
	public void user_should_get_succesfully_logged_in()
	{
		
		
		assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email {string} into email address feild")
	public void user_enters_invalid_email_into_email_address_feild(String invalidEmail)
	{
		
		loginPage.enterEmailAddress(invalidEmail);
		
	}

	@When("User enters invalid password {string} into password feild")
	public void user_enters_invalid_password_into_password_feild(String invalidPassword)
	{
		loginPage.enterPassword(invalidPassword);
	 
	}

	@Then("User is unable to login into application and should get proper warning message")
	public void user_is_unable_to_login_into_application_and_should_get_proper_warning_message() 
	{
	     boolean status = loginPage.displayStatusOfWarningMessage().contains("Warning: No match for E-Mail Address and/or Password.");
		System.out.println(status);
		
	   assertTrue(status);
	}

	@When("User dont enter anything into email address feild")
	public void user_dont_enter_anything_into_email_address_feild() 
	{
		loginPage =new LoginPage(driver);
		loginPage.enterEmailAddress("");
	  
	}

	@When("User dont enter anything into password feild")
	public void user_dont_enter_anything_into_password_feild()
	{
	   
		loginPage.enterPassword("");
	}
}
