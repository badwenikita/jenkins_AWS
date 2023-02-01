package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductInfoPage {
	
	//------------------------------------------------- POM video 4, 5
	
	private WebDriver driver;
	private By productHeader = By.xpath("//*[@id= 'content']//h1");
	private By productImages = By.xpath("//a[@class = 'thumbnail']");
	private By productMetaData = By.xpath("(//div[@id = 'content']//ul[@class = 'list-unstyled'])[position() = 1]/li");
	private By productPricingData = By.xpath("(//div[@id = 'content']//ul[@class = 'list-unstyled'])[position() = 2]/li");
	private Map<String, String> productMap;
	
	//============================================================================================================
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//===============================================================================================================================
	
	public String getProductHeader()
	{
		return driver.findElement(productHeader).getText();
	}
	
	// KT : we cannot compare the images in selenium but we can surely count the no. of images on the page available.
	public int getProductImageCount()
	{
		int i = driver.findElements(productImages).size();
		System.out.println("Product Image count on ProductInfoPage : "+i);
		return i;	
		
	}
	
	//*******************************************************************************************************************************************
	
	// HashMap<k,v> does not maintain any order. So if client wants to maintain or verify the order of the metadata on panel then use LinkedHashMap<k,v>
	// TreeMap<k,v> maintains the Alphabatic order.
	// calling getProductMetaData() and getProductPricingData() inside getProductMetaDataAndPricingInfo()
	public Map<String, String> getProductMetaDataAndPricingInfo()
	{
		productMap = new HashMap<String, String>();
		// productMap = new LinkedHashMap<String, String>();
		// productMap = new TreeMap<String, String>();
		getProductMetaData();
		getProductPricingData();
		// System.out.println(productMap);
		return productMap;
	}
	
	
	/*
	 * Brand: Apple
Product Code: Product 17
Reward Points: 700
Availability: In Stock
	 */
	private void getProductMetaData()
	{
		List<WebElement> list = driver.findElements(productMetaData);
		
		for(WebElement e : list)
		{
			// System.out.println(e.getText());
			String meta = e.getText();
			String metaData[] = meta.split(":");
			String key = metaData[0].trim();
			String value = metaData[1].trim();
			productMap.put(key, value);
		}
	}
	
	
	/*
	 *$2,000.00
	Ex Tax: $2,000.00 
	 */
	// Declared private because we dont want to call this method from Testng class. we are calling it from getProductMetaDataAndPricingInfo()
	private void getProductPricingData()
	{
		List<WebElement> list1 = driver.findElements(productPricingData);
	
	
			String price = list1.get(0).getText();
			String key = "Actual Price";
			String value = price.trim();
			// System.out.println("key = "+key+" , value = "+value);
			productMap.put(key, value);
			
			String data[] = list1.get(1).getText().split(":");
			key = data[0].trim();
			value = data[1].trim();
			// System.out.println("key = "+key+" , value = "+value);
			productMap.put(key, value);
			
	}
	
	
	// *******************************************************************************************************************************************
	
	
	
	
	
	
	
	
	
	
	

}
