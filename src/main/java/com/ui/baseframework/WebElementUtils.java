package com.ui.baseframework;

import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ui.baseframework.Locator.ByType;
import com.ui.utils.XmlUtils;

public class WebElementUtils extends WebDriverUtils{
	
		protected HashMap<String,Locator> locatorMap;
		protected String path;
	
		public WebElementUtils(WebDriver driver){
			super(driver);
			path = System.getProperty("user.dir")+"/webelementdata/"+this.getClass().getSimpleName()+".xml";
			locatorMap = XmlUtils.readElementInfo(path);
		}
		
		public WebElement getElement(Locator locator){
			WebElement el=null;
			ByType type = locator.getByType();
			try{
			switch(type){
			case id : el = driver.findElement(By.id(locator.getLocatorInfo()));break;
			case name : el = driver.findElement(By.name(locator.getLocatorInfo()));break;
			case xpath : el = driver.findElement(By.xpath(locator.getLocatorInfo()));break;
			case cssSelector : el = driver.findElement(By.cssSelector(locator.getLocatorInfo()));break;
			}}catch(Exception e){
				log.info("元素："+locator.getElementName()+"识别异常");
				takeScreenShot("findElementErrorImage");
				Assert.fail("查找元素异常，退出当前测试用例");
			}
			return el;
		}
		
		public WebElement findElement(final Locator locator){
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			WebElement el = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d){
					return getElement(locator);
				}
			});
			return el;
		}
		
		public void click(Locator locator){
			WebElement el = findElement(locator);
			el.click();
			log.info("点击元素"+locator.getElementName());
		}
		
		public void input(Locator locator,String content){
			WebElement el = findElement(locator);
			el.sendKeys(content);
			log.info("在元素"+locator.getElementName()+"输入："+content);
		}
		
		public void submit(Locator locator){
			WebElement el = findElement(locator);
			el.submit();
		}
		
		public String getText(Locator locator){
			WebElement el = findElement(locator);
			log.info("获取元素："+locator.getElementName());
			return el.getText();
		}
		
		public Locator getLocator(String locatorName){
		return locatorMap.get(locatorName);
		}
}
