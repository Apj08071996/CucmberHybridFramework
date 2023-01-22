package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	

	
	@FindBy(id="input-firstname")
	private WebElement firstNameFeild;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameFeild;
	
	@FindBy(id="input-email")
	private WebElement emailFeild;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneFeild;
	
	@FindBy(id="input-password")
	private WebElement passwordFeild;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@Type='radio'][@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailIdWarningMessage;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMassege;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	public String getPrivacyPolicyWarningMessage() {
		
		return privacyPolicy.getText();
	}
	public String getPasswordWarningMessage()
	{
		return passwordWarningMessage.getText();
	}
	
	public String getTelephoneWarningMessage()
	{
		return telephoneWarningMassege.getText();
	}
	
	public String getEmailAddressWarningMessage()
	{
		return emailIdWarningMessage.getText();
	}
	
	public String getLastNameWarningMessage()
	{
		return lastNameWarningMessage.getText();
	}
	
	public String getFirstNameWarningMessage()
	{
		return firstNameWarningMessage.getText();
	}
	
	public void enterFirstName(String firstName)
	{
		firstNameFeild.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) 
	{
		lastNameFeild.sendKeys(lastName);
	}
	
	public void enterEmailAddress(String email)
	{
		emailFeild.sendKeys(email);
	}
	
	public void enterTelephone(String telephone)
	{
		telephoneFeild.sendKeys(telephone);
	}
	
	public void enterPassword(String password)
	{
		passwordFeild.sendKeys(password);
	}
	
	public void enterPasswordIntoConfirmPassword(String password)
	{
			confirmPassword.sendKeys(password);
	}
	
	public void clickOnPrivacyPolicyCheckbox()
	{
		privacyPolicy.click();
	}
	
	public AccountSuccesPage clickOnContinueButton()
	{
		continueButton.click();
		return new AccountSuccesPage(driver);
	}
	
	public void selectYesNewsLetterOption()
	{
		yesNewsLetterOption.click();
	}
	
	public String checkDuplicateEmailWarningMessage()
	{
		return duplicateEmailMessage.getText();
	}

	
}
