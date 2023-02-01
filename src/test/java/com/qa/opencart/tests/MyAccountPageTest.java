package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;


public class MyAccountPageTest extends BaseTest{
	
	//------------------------------------------------- POM video 3
	// SearchProduct page ~ Result Page in naveen's project

	
	//Individual pre-condition for MyAccountPage
	@BeforeClass
	public void accountSetup()
	{
		// login related code. Because after login, landing page is "My Account" page.
			myAccountPageObj = loginPageObj.doLogin(propertiesObj.getProperty("username"), propertiesObj.getProperty("password"));
	}
	
	/*
	 @BeforeClass
	public void accountSetup()
	{
		System.out.println("2. "+myAccountPageObj);
		System.out.println("3. "+loginPageObj);
		if( myAccountPageObj == null )
		{
			myAccountPageObj = loginPageObj.doLogin("jacobpeter@gmail.com", "Test123@");
			System.out.println("4. "+myAccountPageObj);
		}
		// login related code. Because after login, landing page is "My Account" page.
		
	}
	 */
	
	
	@Test(priority = 1)
	public void myAccountPageTitleTest()
	{
		String actTitle = myAccountPageObj.getMyAccountPageTitle();
		System.out.println("Title : "+actTitle);
		Assert.assertEquals(actTitle, AppConstants.MY_ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void myAccountPageUrlTest()
	{
		String actUrl = myAccountPageObj.getMyAccountPageUrl();
		System.out.println("URL : "+actUrl);
		Assert.assertTrue(actUrl.contains(AppConstants.MY_ACCOUNT_PAGE_FRACTION_URL));
	}
	
	@Test(priority = 3)
	public void verifyAccountPageHeadersTest()
	{
		List<String> actualHeaders = myAccountPageObj.verifyAccountPageHeaders();
		Assert.assertEquals(actualHeaders, AppConstants.MY_ACCOUNT_PAGE_EXPECTED_HEADERS);
	}

	@Test(priority = 4)
	public void verifyLogoutOptionTest()
	{
		Assert.assertTrue(myAccountPageObj.verifyLogoutOption());
	}
	
	@Test(priority = 5)
	public void verifySearchBoxTest()
	{
		Assert.assertTrue(myAccountPageObj.isSearchBoxExist());
	}
	
	
	
	@DataProvider
	public Object[][] supplyProductName()
	{
		Object[][] o = { 
				{"Macbook"},
				{"imac"},
				{"Samsung"}
			};
				
		return o;
	}
	
	/*
	 * 	TDD :Test Driven Development
		We want to search a product, so we know what we want to Test, for that particular Test we don't have any productSearch() in MyAccountPage
		so in order to Test this we have to write a Development code ie productSearch() in MyAccountPage class. this is called Test Driven 
		Development. For testing a feature we have to write a development code.
		
		we cannot have more than one hard assertion for a @Test method
	 */
	// TDD
	@Test(dataProvider = "supplyProductName", priority = 6)
	public void productSearchTest(String productName)
	{
		searchProductPageObj = myAccountPageObj.performProductSearch(productName);
		String actualTitle = searchProductPageObj.getSearchProductPageTitle(productName);
		softAssertObj.assertEquals(actualTitle, AppConstants.SEARCH_PRODUCT_PAGE_TITLE+productName );
		Assert.assertTrue(searchProductPageObj.getSearchProductsCount() > 0 );
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
