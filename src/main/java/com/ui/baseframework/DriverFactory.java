package com.ui.baseframework;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	static Runtime runtime=Runtime.getRuntime();
	
	public static WebDriver getChromeDriver(){
	//如果打开了多个chrome页面，先关闭之前可能出错的浏览器
	try {		
		runtime.exec("taskkill /F /IM chrome.exe");
		} catch (IOException e) {
		e.printStackTrace();
		}
	
//		String path = System.getProperty("user.dir")+
//		System.setProperty(key, value);
	
		//去掉启动时候的黄色提示框
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		return driver;
	
	}
}
