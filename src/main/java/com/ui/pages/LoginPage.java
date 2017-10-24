package com.ui.pages;

import org.openqa.selenium.WebDriver;

import com.ui.baseframework.BasePage;
import com.ui.baseframework.LocalConfig;
import com.ui.baseframework.Locator;

public class LoginPage extends BasePage{

		Locator usernameInputbox =getLocator("usernameInputbox");
		Locator passwordInputbox = getLocator("passwordInputbox");
		Locator loginButton = getLocator("loginButton");
		Locator userLink = getLocator("userLink");
	
		public LoginPage(WebDriver driver){
			super(driver);
			openPage(LocalConfig.URL);
		}
		
		public void inputUserName(String name){
			input(usernameInputbox, name);
		}
		
		public void inputPassWord(String password){
			input(passwordInputbox,password);
		}
		
		public void clickLoginButton(){
			click(loginButton);
		}
		
		public String getAlertInfo(){
			return getAlertText();
		}
		
}
