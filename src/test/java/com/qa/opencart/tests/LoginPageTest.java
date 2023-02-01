package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.AppErrors;

public class LoginPageTest extends BaseTest {
	
	//------------------------------------------------- POM video 2

	@Test
	public void loginPageTitleTest()
	{
		String actTitle = loginPageObj.getLoginPageTitle();
		System.out.println("Title : "+actTitle);
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE, AppErrors.TITLE_INCORRECT);
	}
	
	@Test
	public void loginPageUrlTest()
	{
		String actUrl = loginPageObj.getLoginPageUrl();
		System.out.println("URL : "+actUrl);
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), AppErrors.INCORRECT_LOGIN_PAGE_FRACTION_URL);
	}
	
	@Test
	public void forgotPasswordLinkExistTest()
	{
		boolean b = loginPageObj.forgetPasswordLink();
		Assert.assertEquals(b, true, AppErrors.FORGET_PASSWORD_LINK_UNAVAILABLE);
	}
	
	@Test
	public void loginTest()
	{
		String username = propertiesObj.getProperty("username");
		String pwd = propertiesObj.getProperty("password");
		myAccountPageObj = loginPageObj.doLogin(username, pwd);
		// System.out.println("1. "+myAccountPageObj);
		Assert.assertEquals(myAccountPageObj.verifyLogoutOption(), true);
		
	}
	
	
	
	
	
	
	
	
	
	
}
