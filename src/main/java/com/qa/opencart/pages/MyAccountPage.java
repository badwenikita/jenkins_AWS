package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.WaitUtil;

public class MyAccountPage {
	
	//------------------------------------------------- POM video 3
	
	private WebDriver driver;
	private WaitUtil waitUtilObj;
	
	public By searchBox = By.xpath("//input[@name = 'search']");
	public By searchButton = By.xpath("//div[@id = 'search']/span[@class = 'input-group-btn']");
	public By accountPageHeader = By.xpath("//div[@id = 'content']/h2");
	public By logout = By.linkText("Logout");
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver;
		waitUtilObj = new WaitUtil(driver);
	}
	
	public List<String> verifyAccountPageHeaders() {
		
		List<WebElement> list = driver.findElements(accountPageHeader);
		List<String> result = new ArrayList<String>();
		for(WebElement e : list)
		{
			result.add(e.getText());
		}
		return result;
		
	}
	
	// Suppose Title of "My Account" Page is loading a bit slow, then we can apply wait to it.
	public String getMyAccountPageTitle()
	{
		return waitUtilObj.waitForTitle(AppConstants.MY_ACCOUNT_PAGE_TITLE, AppConstants.DEFAULT_TIMEOUT);
	}
	
	public String getMyAccountPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean verifyLogoutOption()
	{
		return driver.findElement(logout).isDisplayed();
	}
	
	
	public boolean isSearchBoxExist()
	{
		return driver.findElement(searchBox).isDisplayed();
	}
	
	
	public SearchProductPage performProductSearch(String productName)
	{
		if(isSearchBoxExist())
		{
			driver.findElement(searchBox).clear();
			driver.findElement(searchBox).sendKeys(productName);
			driver.findElement(searchButton).click();
			return new SearchProductPage(driver);
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
