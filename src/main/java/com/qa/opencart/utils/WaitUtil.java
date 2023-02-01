package com.qa.opencart.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	private WebDriver driver;
	
	// Constructor
	public WaitUtil(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String waitForTitle(String expectedTitle, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.titleContains(expectedTitle)))
		{
			return driver.getTitle();
		}
		else
		{
			System.out.println("Expected title is not visible");
			return null;
		}
	}
	
}
