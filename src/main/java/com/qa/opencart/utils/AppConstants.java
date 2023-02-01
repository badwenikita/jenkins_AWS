package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	// verification messages, titles, URLs are kept in this class. NO HARDCODDING IN TEST CLASS.
	public static final String LOGIN_PAGE_TITLE = "Account Login11";
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	
	public static final String MY_ACCOUNT_PAGE_TITLE = "My Account";
	public static final String MY_ACCOUNT_PAGE_FRACTION_URL = "route=account/account";
	
	public static final List<String> MY_ACCOUNT_PAGE_EXPECTED_HEADERS = Arrays.asList("My Account", "My Orders", "My Affiliate Account", 
			"Newsletter");
	
	public static final int DEFAULT_TIMEOUT = 10;
	
	public static final String SEARCH_PRODUCT_PAGE_TITLE = "Search - ";
	
	public static final String EXPECTED_PRODUCT_HEADER = "MacBook Pro";
	
}
