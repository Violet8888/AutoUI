package com.ui.baseframework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebElementUtils{
	
	public BasePage(WebDriver driver){
		super(driver);
	}
	
	public void alertAccept(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertDismiss(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getAlertText(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void inputAlert(String value){
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
}
