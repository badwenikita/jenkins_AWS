package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class SearchProductPage {
	
	//------------------------------------------------- POM video 4
	
	private WebDriver driver;
	private By searchProducts = By.xpath("//div[@class = 'product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']");

	
	public SearchProductPage(WebDriver driver) {

		this.driver = driver;
	}
	
	
	public String getSearchProductPageTitle(String productName)
	{
		String title = driver.getTitle();
		if(title.contains(productName))
		{
			return driver.getTitle();
		}
		return null;
		
	}
	
	public String getSearchProductPageUrl()
	{
		return driver.getCurrentUrl();
		
	}
	
	public int getSearchProductsCount()
	{
		System.out.println("Product count = "+driver.findElements(searchProducts).size());
		return driver.findElements(searchProducts).size();
	}
	
	
	public ProductInfoPage selectProduct(String mainProducrName)
	{
		driver.findElement(By.linkText(mainProducrName)).click();
		return new ProductInfoPage(driver);
	}
	
	
	

}
