package com.ui.baseframework;

public class Locator {
	
	public enum ByType{
		xpath,id,linkText,name,className,cssSelector,partialLinkText,tagName
	}
	private String elementName;
	private String value;
	private int timeOut;
	private ByType byType;
	
	public Locator(String value,int timeOut,ByType byType,String elementName){
		this.value = value;
		this.timeOut = timeOut;
		this.byType = byType;
		this.elementName = elementName;
		
	}

	public String getElementName() {
		return elementName;
	}

	public String getLocatorInfo() {
		return value;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public ByType getByType() {
		return byType;
	}
}
