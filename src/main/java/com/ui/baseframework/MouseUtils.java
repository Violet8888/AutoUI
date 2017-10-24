package com.ui.baseframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {
	
	Actions action;
	
	public MouseUtils(WebDriver driver){
		action = new Actions(driver);
	}
	
	public void rigthClick(WebElement element){
		action.contextClick(element).perform();
	}
	
	public void doubleClick(WebElement element){
		action.doubleClick(element).perform();
	}
	
}
