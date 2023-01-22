package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage
{

	 WebDriver driver;
	 ElementUtils elementUtils;
	 
	 public LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
		 
		 PageFactory.initElements(driver,this);
		 
		  elementUtils=new ElementUtils(driver);
	 }
	 
	 //******find the corrosponding webelement*******
	 @FindBy(id="input-email")
	 private WebElement emailFeild;
	 
	 
	 @FindBy(id="input-password")
	 private WebElement passwordFeild;
	 
	 @FindBy(xpath="//input[@value='Login']")
	 private WebElement loginButton;
	 
	 @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	 private WebElement warningMessage;
	 
	 
	 //******performing the corrosponding operation
	 public void enterEmailAddress(String emailAddress)
	 {
		 elementUtils.typeTextIntoElement(emailFeild, emailAddress, 15);
		// emailFeild.sendKeys(emailAddress);
		
	 }
	 
	 public void enterPassword(String password)
	 {
		 elementUtils.typeTextIntoElement(passwordFeild, password, 15);
		// passwordFeild.sendKeys(password);
	 }
	 
	 public AccountPage clickOnLoginButton()
	 {
		 elementUtils.clickOnElement(loginButton, 15);
		 //loginButton.click();
		 
		 return new AccountPage(driver);
		 
		 
	 }
	 
	 public String displayStatusOfWarningMessage()
	 {
		 return warningMessage.getText();
	 }
}
