package stepdefinations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class Search 
{
		WebDriver driver;
		HomePage homePage;
		SearchPage searchPage;
		
	@Given("User opens the Application")
	public void user_opens_the_application() 
	{

		driver=DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box feild")
	public void user_enters_valid_product_into_search_box_feild(String validProduct) 
	{
		homePage=new HomePage(driver);
		
		homePage.enterProductIntoSearchBoxFeild(validProduct);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() 
	{
		searchPage=homePage.clickOnSearchButton();
		
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() 
	{
			
		assertTrue(searchPage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into Search box feild")
	public void user_enters_invalid_product_into_search_box_feild(String invalidProduct)
	{
		homePage=new HomePage(driver);
		
		homePage.enterProductIntoSearchBoxFeild(invalidProduct);
		
	}

	@Then("User should get a message about no other product matching")
	public void user_should_get_a_message_about_no_other_product_matching()
	{
		
		String actual=searchPage.displayStatusOfThereIsNoProductThatMatches();
		assertEquals(actual,"There is no product that matches the search criteria.");
	}

	@When("User dont enter any product into Search box feild")
	public void user_dont_enter_any_product_into_search_box_feild()
	{
		 homePage=new HomePage(driver);
		
		homePage.enterProductIntoSearchBoxFeild("");
	}

}
