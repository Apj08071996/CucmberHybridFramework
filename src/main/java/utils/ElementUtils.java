package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.AllArguments;

public class ElementUtils
{
	WebDriver driver;
	private String[] arguments;

	public ElementUtils(WebDriver driver) 
	{
		this.driver=driver;
	}

	//Method for click on element
	public void clickOnElement(WebElement element,long durationOfSeconds)
	{
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
		//WebElement webelement=wait.until(ExpectedConditions.elementToBeClickable(element));

		//instead of writing above two lines we can use third method here

		WebElement webelement=waitForElement(element, durationOfSeconds);

		webelement.click();		
	}

	//method for sending text into an element

	public void typeTextIntoElement(WebElement element,String textToBeType,long durationOfSeconds)
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfSeconds));
		//WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));

		////instead of writing above two lines we can use third method here which return us WebElement

		WebElement webelement=waitForElement(element, durationOfSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToBeType);
	}

	public WebElement waitForElement(WebElement element,long durationOfSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfSeconds));

		WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));

		return webelement;
	}

	public void selectOptionInDropDown(WebElement webElement,String dropdownOption,long durationInSeconds)
	{
		WebElement webelement = waitForElement(webElement, durationInSeconds);

		Select select=new Select(webelement);

		select.selectByVisibleText(dropdownOption);
	}

	public void acceptAlert(long durationOfSeconds)
	{
		Alert alert=waitForAlert(durationOfSeconds);

		alert.accept();
	}

	public void dissmissAlert(long durationOfSeconds)
	{
		Alert alert = waitForAlert(durationOfSeconds);
		alert.dismiss();
	}

	public Alert waitForAlert(long durationOfSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfSeconds));

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		return alert;
	}

	public void mouseHoverAndClick(WebElement element,long durationOfSeconds)
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfSeconds));
		//WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		//instead of above two lines we can use below method

		WebElement webElement = waitForVisibilityOfElement(element, durationOfSeconds);
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}

	public WebElement waitForVisibilityOfElement(WebElement element,long durationOfSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfSeconds));

		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		return webElement;
	}

	public void javascriptClick(WebElement element,long durationofSeconds)
	{
		WebElement webelement = waitForVisibilityOfElement(element, durationofSeconds);

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].click();",webelement);
	}

	public void javaScriptType(WebElement element,long durationOfSeconds,String textToBeType)
	{
		WebElement webelement = waitForVisibilityOfElement(element, durationOfSeconds);

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].value='"+textToBeType+"'",webelement);
	}
	
}
