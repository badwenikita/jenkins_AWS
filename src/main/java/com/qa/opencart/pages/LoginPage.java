package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//------------------------------------------------- POM video 2

	private WebDriver driver;
	
	// 1. private By Locators
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value = 'Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	

	
	// 2. page Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// 3. page Actions
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getLoginPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public MyAccountPage doLogin(String username, String pwd)
	{
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		
		return new MyAccountPage(driver);
	}
	
	public boolean forgetPasswordLink()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
}
