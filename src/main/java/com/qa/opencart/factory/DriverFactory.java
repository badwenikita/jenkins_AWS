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
		FileInputStream fis = null;

		// mvn clean install -Denv="qa"
		// mvn clean install
		
		String envName = System.getProperty("env");
		System.out.println("-----> Running test cases on environment----> " + envName);
		
		
		if (envName == null) {
			System.out.println("No env is given...hence running it on default QA env....");
			try {
				fis = new FileInputStream("E:\\SeleniumProject2023\\Git-Jenkins-Grid-AWS-Project\\src\\test\\resources\\config\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		 else {

				try {
					switch (envName.toLowerCase()) {
					case "qa":
						fis = new FileInputStream("./src/test/resources/config/qa.config.properties");
						break;
					case "dev":
						fis = new FileInputStream("./src/test/resources/config/dev.config.properties");
						break;
					case "stage":
						fis = new FileInputStream("./src/test/resources/config/stage.config.properties");
						break;
					case "uat":
						fis = new FileInputStream("./src/test/resources/config/uat.config.properties");
						break;
					case "prod":
						fis = new FileInputStream("./src/test/resources/config/config.properties");
						break;

					default:
						System.out.println("Please pass the right env name...." + envName);
						break;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}

			try {
				propertiesObj.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return propertiesObj;
		
		
	}
	
	
	
	
}
