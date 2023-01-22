package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage
{
		public WebDriver driver;
		ElementUtils elementUtils;
		
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			
			PageFactory.initElements(driver, this);
			
			elementUtils=new ElementUtils(driver);
		}
		
		//***********------------------------**************
		//here we are finding the webelement
		
		@FindBy(xpath="//span[text()='My Account']")
		private WebElement myAccountDropMenu;
		
		@FindBy(linkText = "Login")
		private WebElement loginButton;
		
		@FindBy(linkText = "Register")
		private WebElement registerOption;
		
		@FindBy(xpath="//input[@type='text'][@name='search']")
		private WebElement searchBoxFeild;
		
		@FindBy(xpath="//button[contains(@class,'btn btn-default btn-lg')]")
		private WebElement searchButton;
		
		
		
		//performming corrosponding operation
		
		public SearchPage clickOnSearchButton()
		{
			searchButton.click();
			return new SearchPage(driver);
		}
		
		public void enterProductIntoSearchBoxFeild(String product)
		{
			searchBoxFeild.sendKeys(product);
		}
		
		public void clickOnMyAccountDropMenu()
		{
			//myAccountDropMenu.click();
			
			elementUtils.clickOnElement(myAccountDropMenu,15);
		}
		
		public LoginPage clickOnLoginButton() {
			
			//loginButton.click();
			elementUtils.clickOnElement(loginButton, 15);
			
			return new LoginPage(driver);
		}
		
		public RegisterPage clickOnRegisterOption()
		{
			registerOption.click();
			
			return new RegisterPage(driver);
		}
		
}
