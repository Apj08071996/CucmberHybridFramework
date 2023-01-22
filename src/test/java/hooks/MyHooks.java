package hooks;

import java.time.Duration;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks 
{

	public WebDriver driver;
	@Before
	public void setup()
	{
		Properties prop=ConfigReader.intializeProperties();
		driver=DriverFactory.initializeBrowser(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));
	}
	

	@After
	public void teardown(Scenario scenario)
	{
		String scenarioName = scenario.getName().replaceAll(" ","_");

		if(scenario.isFailed()) {

			TakesScreenshot ts=(TakesScreenshot)driver;

			byte[] srcScrennshot = ts.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(srcScrennshot,"image/png", scenarioName);
		}
		driver.quit();
	}

}
