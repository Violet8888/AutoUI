package com.ui.demo;

import org.dom4j.DocumentException;

import com.ui.utils.XmlUtils;

public class ReadXml {
	public static void main(String[] args) throws DocumentException{
		XmlUtils xl = new XmlUtils();
		System.out.println(xl.readElementInfo("LoginPage.xml").get("passwordInputbox").getLocatorInfo());
	}

}
