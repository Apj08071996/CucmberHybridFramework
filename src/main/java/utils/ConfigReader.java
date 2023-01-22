package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader 
{
	public static Properties intializeProperties()
	{
		Properties prop=new Properties();
		
		try 
		{
			

			FileInputStream fis=new FileInputStream("E:\\CucumberBDDAndAPITesting\\tutorialsninjahybridframework\\src\\test\\resources\\config\\config.properties");

			prop.load(fis);

		} 
		catch (Exception e)
		{
			e.printStackTrace();

		}

		return prop;

	}


}
