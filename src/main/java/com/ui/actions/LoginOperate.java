
package com.ui.actions;

import org.openqa.selenium.WebDriver;

import com.ui.pages.LoginPage;
import com.ui.pages.MainPage;

public class LoginOperate {

	private static WebDriver driver;
	static LoginPage loginPage;
	static MainPage mainPage;
	
	public static WebDriver getWebDriver(){
		return driver;
	}
	
	public static void setWebDriver(WebDriver driver){
		LoginOperate.driver = driver;
	}
	
	public static MainPage LoginSuccess(String name,String password){
		loginPage = new LoginPage(getWebDriver());
		loginPage.inputUserName(name);
		loginPage.inputPassWord(password);
		loginPage.clickLoginButton();
		return new MainPage(getWebDriver());
	}
	
	public static String getLoginUserName(String name,String password){
		mainPage = LoginSuccess(name, password);
		return mainPage.getLoginUserName();
	}
	
	public static String LoginFail(String name,String password){
		mainPage = LoginSuccess(name, password);
		String text = loginPage.getAlertText();
		loginPage.alertAccept();
		return text;
		
	}
}
