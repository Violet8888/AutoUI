package com.ui.testcases;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.actions.LoginOperate;
import com.ui.baseframework.BasePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MainPage;
import com.ui.utils.AssertUtils;
import com.ui.utils.ExeclUtils;
import com.ui.utils.TestCase;

public class LoginTest {
	WebDriver driver;
	AssertUtils assertUtils;
	@BeforeMethod
	public void setUp(){
		try{
		driver = new ChromeDriver();
		assertUtils = new AssertUtils();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception e){
			Assert.fail("测试初始化报错");
		}
		}
	@Test
	public void f1(){
		List<TestCase> testcases = ExeclUtils.getUITestData("TestData.xlsx");
		HashMap<String,String> testdata = (HashMap<String, String>) testcases.get(0).getTestData();
		LoginOperate.setWebDriver(driver);
		String text = LoginOperate.getLoginUserName(testdata.get("username"),testdata.get("password"));
		assertUtils.checkStringContains(text,testcases.get(0).getExpectedResult(),"登录测试失败");
  }
	
	@Test
	public void f2(){
		List<TestCase> testcases = ExeclUtils.getUITestData("TestData.xlsx");
		HashMap<String,String> testdata = (HashMap<String, String>) testcases.get(1).getTestData();
		LoginOperate.setWebDriver(driver);
		String st = LoginOperate.LoginFail(testdata.get("username"), testdata.get("password"));
		assertUtils.checkStringContains(st,testcases.get(1).getExpectedResult(), "登录测试失败");
  }
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	}
	
}
