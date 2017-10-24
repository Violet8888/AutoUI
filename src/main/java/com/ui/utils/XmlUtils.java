package com.ui.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ui.baseframework.Locator;
import com.ui.baseframework.Locator.ByType;

public class XmlUtils {
		
	public static HashMap<String,Locator> readElementInfo(String path){
		HashMap<String,Locator> elementInfos = new HashMap<String,Locator>();
		SAXReader saxReader = new SAXReader();
		try{
		Document document = saxReader.read(new File(path));
		Element root = document.getRootElement();
		List<Element> childList = root.elements();
		for(Element el:childList){
			String value = el.attributeValue("value").toString();
			int timeOut = Integer.parseInt(el.attributeValue("timeout"));
			String elementName = el.attributeValue("name").toString();
			String type = el.attributeValue("type");
			Locator locator = new Locator(value,timeOut,getType(type),elementName);
			String keyName = el.getText();
			elementInfos.put(keyName, locator);
		}}catch(Exception e){
			e.printStackTrace();
		}
		return (HashMap<String,Locator>)elementInfos;

	}
		
	public static ByType getType(String value){
		ByType type = null;
		switch(value){
		case "css" : type = ByType.cssSelector;break;
		case "xpath" : type = ByType.xpath;break;
		}
		return type;
}
}