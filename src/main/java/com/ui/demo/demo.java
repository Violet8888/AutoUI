package com.ui.demo;

import org.openqa.selenium.WebDriver;

import com.ui.baseframework.DriverFactory;

public class demo {

	public static void main(String[] args) {

		WebDriver driver = DriverFactory.getChromeDriver();
		driver.get("http://www.baidu.com");
	}

}
