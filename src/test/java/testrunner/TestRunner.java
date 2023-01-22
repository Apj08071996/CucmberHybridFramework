package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features={"src/test/resources/feature"},
		         glue={"stepdefinations","hooks"},
		         monochrome=true,
		         dryRun=false,
		         plugin= {"pretty","html:target/cucumber/reports/CucumberReport.html"},
		         publish=true
		
		         )
public class TestRunner 
{
	
}
