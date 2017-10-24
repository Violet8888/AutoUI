package com.ui.utils;

import junit.framework.Assert;

public class AssertUtils {
		
	public void checkNum(int actual,int expected,String... com){
		Assert.assertEquals(expected, actual);
	}
	
	public void checkString(String actual,String expected,String... com){
		Assert.assertEquals(expected, actual);
	}
	
	public void checkStringContains(String actual,String expected,String... com){
		Assert.assertEquals(actual.contains(expected), true);
	}
	
	public void checkNotNull(Object object){
		Assert.assertNotNull(object);
	}
}
