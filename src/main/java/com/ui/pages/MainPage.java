package com.ui.pages;

import org.openqa.selenium.WebDriver;
import com.ui.baseframework.Locator;
import com.ui.baseframework.WebElementUtils;

public class MainPage extends WebElementUtils{
	
	Locator userMenu = getLocator("userMenu");
	
	public MainPage(WebDriver driver){
		super(driver);
		
	}
	
	public String getLoginUserName(){
		return getText(userMenu);
	}
}
