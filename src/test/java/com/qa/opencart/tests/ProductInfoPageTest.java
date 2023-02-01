package com.qa.opencart.tests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	//------------------------------------------------- POM video 4, 5

	@BeforeClass
	public void productDetailsSetup()
	{
		myAccountPageObj = loginPageObj.doLogin(propertiesObj.getProperty("username"), propertiesObj.getProperty("password"));
		
	}
	
	
	@DataProvider
	public Object[][] getProductTestData()
	{
		Object[][] o = {
				{"Macbook", "MacBook Air"},
				{"Macbook", "MacBook Pro"},
				{"Apple", "Apple Cinema 30\""},
				{"Samsung", "Samsung SyncMaster 941BW"},
				{"Samsung", "Samsung Galaxy Tab 10.1"},
		};
		
		return o;
	}
	
	@Test(dataProvider = "getProductTestData")
	public void productHeaderTest(String searchKey, String mainProduct)
	{
		searchProductPageObj = myAccountPageObj.performProductSearch(searchKey);
		productInfoPageObj = searchProductPageObj.selectProduct(mainProduct);
		String actualHeader = productInfoPageObj.getProductHeader();
		Assert.assertEquals(actualHeader, mainProduct);
		
	}
	
	@DataProvider
	public Object[][] getProductImageTestData()
	{
		Object[][] o = {	
				{"Macbook", "MacBook Air", 4},
				{"Macbook", "MacBook Pro", 4},
				{"Apple", "Apple Cinema 30\"", 6},
				{"Samsung", "Samsung SyncMaster 941BW", 1},
				{"Samsung", "Samsung Galaxy Tab 10.1", 7},
				
		};
		
		return o;
	}
	
	// KT :- Test cases should not be dependent on each other. This is why login, product search, product info related TCs are repeated in every TCs
	@Test(dataProvider = "getProductImageTestData" )
	public void verifyImageCount(String searchKey, String mainProduct, int productCount)
	{
		searchProductPageObj = myAccountPageObj.performProductSearch(searchKey);
		productInfoPageObj = searchProductPageObj.selectProduct(mainProduct);
		String actualHeader = productInfoPageObj.getProductHeader();
		System.out.println("Product header : "+actualHeader);
		Assert.assertTrue(productInfoPageObj.getProductImageCount() == productCount);
	}
	
	
	
	// KT : we are using more than one assertion in this TC because we are verifying meta data of the product, so we have to verify multiple data
	//about a product on panel. 
	// verifying metadata is a single feature hence we have to write in a single test case for that, containing multiple assertion. 
	// We are not going to write separate TC for each metadata.
	@Test
	public void productMetaDataTest()
	{
		searchProductPageObj = myAccountPageObj.performProductSearch("Macbook");
		productInfoPageObj = searchProductPageObj.selectProduct("MacBook Air");
		Map<String, String> actualProductInfo = productInfoPageObj.getProductMetaDataAndPricingInfo();
		System.out.println(actualProductInfo);
		
		softAssertObj.assertEquals(actualProductInfo.get("Brand"), "Apple");
		softAssertObj.assertEquals(actualProductInfo.get("Availability"), "In Stock");
		softAssertObj.assertEquals(actualProductInfo.get("Actual Price"), "$1,202.00");
		softAssertObj.assertEquals(actualProductInfo.get("Ex Tax"), "$1,000.00");
		softAssertObj.assertEquals(actualProductInfo.get("Product Code"), "Product 17");
		softAssertObj.assertEquals(actualProductInfo.get("Reward Points"), "700");
		// assertEquals(actualProductInfo.get("Reward Points") = Returns the value to which the specified key is mapped,or null if 
		// this map contains no mapping for the key. 

		softAssertObj.assertAll();
	}
	
	
	
	
	
	
	
	

}
