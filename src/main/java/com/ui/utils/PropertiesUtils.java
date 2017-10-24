package com.ui.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {

	private static Properties properties;
	private static String path;
	
	public PropertiesUtils(String path){
		this.path = path;
	}
	
	public static String readProperties(String keyName){
	properties = new Properties();
	try{
	FileInputStream fi = new FileInputStream("src/main/java/com/ui/config/"+path);
	properties.load(fi);
	}catch(Exception e){
		e.printStackTrace();
	}
	return properties.getProperty(keyName);
	}
}
