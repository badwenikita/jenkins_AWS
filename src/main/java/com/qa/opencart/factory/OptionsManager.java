package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	// ************************************************************************ POM video 6
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	public OptionsManager(Properties prop)
	{
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions()
	{
		co = new ChromeOptions();
		if( Boolean.parseBoolean(prop.getProperty("headless")) )
		{
			co.setHeadless(true);
			System.out.println("Running Test in headless mode............");
		}
		if( Boolean.parseBoolean(prop.getProperty("incognito")) )
		{
			// co.setHeadless(true);
			co.addArguments("--incognito");
			System.out.println("Running Test in incognito mode............");
		}
		System.out.println("co :"+co);
		return co;
	}
	
	public FirefoxOptions getFireFoxOptions()
	{
		fo = new FirefoxOptions();
		if( Boolean.parseBoolean(prop.getProperty("headless")) )
		{
			fo.setHeadless(true);
			System.out.println("Running Test in headless mode............");
		}
		if( Boolean.parseBoolean(prop.getProperty("incognito")) )
		{
			// co.setHeadless(true);
			fo.addArguments("--incognito");
			System.out.println("Running Test in incognito mode............");
		}
		
		return fo;
	}
	
	
	
	
	
	
}
