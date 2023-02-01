package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	// This class will help to initialize the driver
	public WebDriver driver;
	private Properties propertiesObj;	// Naveen made this public
	private OptionsManager optionsManagerObj;	// Naveen made this public
	
	public WebDriver initializeBrowser(Properties prop)
	{
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name : "+browserName);
		optionsManagerObj = new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver( optionsManagerObj.getChromeOptions() );
		}
		else if(browserName.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver( optionsManagerObj.getFireFoxOptions() );
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		
		return driver;
		
		
	}
	
	public Properties initProperties()
	{
		propertiesObj = new Properties();
		try {
			// FileInputStream will create connection with the properties file.
			FileInputStream fis = new FileInputStream("E:\\SeleniumProject2023\\practice\\src\\test\\resources\\config\\config.properties"); 
			// E:\SeleniumProject2023\practice\src\test\resources\config\config.properties
			// /practice/src/test/resources/config/config.properties
			propertiesObj.load(fis); // load() will bind the data to propertiesObj Object.
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return propertiesObj;
	}
	
	
	
	
}
