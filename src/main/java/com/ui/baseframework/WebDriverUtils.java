package com.ui.baseframework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	
	

public class WebDriverUtils{
		protected WebDriver driver;
		protected static MouseUtils mouse;
		protected static KeyboardUtils keyboard;
		protected static Log log = new Log(WebDriverUtils.class);

		public WebDriverUtils(WebDriver driver){
			this.driver = driver;
			mouse = new MouseUtils(driver);
			keyboard = new KeyboardUtils(driver);
		}
		
		public void openPage(String url){
			driver.get(url);
			log.info("打开网址："+url);
		}
		
		public void back(){
			driver.navigate().back();
			log.info("返回上一页");
		}
	
		public void takeScreenShot(String... pngName){
			String fileName;
			String filePath = LocalConfig.SHOTPATH;
			File file = new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			if(pngName.length == 0){
				fileName = "shotImage";
			}else{
				fileName = pngName[0];
			}
			SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			String dateStr = sf.format(date);
			String path = "\\"+filePath+"\\"+fileName+"_"+dateStr+".png";
			takeScreenShot(driver,path);
		}
		
		public void takeScreenShot(WebDriver driver,String path){
			String currentPath = System.getProperty("user.dir");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File picFile = new File(currentPath + path);
			try{
				FileUtils.copyFile(scrFile, picFile);
				log.info("截图成功，图片保存路径为："+currentPath + path);
			}catch(Exception e){
				log.error("截图失败");
			}
		}
}
