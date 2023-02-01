package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchProductPage;


public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	public LoginPage loginPageObj;
	public MyAccountPage myAccountPageObj;
	public SearchProductPage searchProductPageObj;
	public SoftAssert softAssertObj;
	public ProductInfoPage productInfoPageObj;
	public Properties propertiesObj;
	
	
	@BeforeTest
	public void setup()
	{
		df = new DriverFactory();
		propertiesObj = df.initProperties();
		driver = df.initializeBrowser(propertiesObj);
		
		loginPageObj = new LoginPage(driver);
		softAssertObj = new SoftAssert();
		
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
