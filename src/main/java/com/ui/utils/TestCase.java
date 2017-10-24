package com.ui.utils;

import java.util.HashMap;
import java.util.Map;

public class TestCase {

	private String CaseName = null;
	private String isCheck = null;
	private String expectedResult = null;
	private Map<String,String> testData = new HashMap<String,String>();
	
	public TestCase(String name,String check,String result,Map<String,String> testData){
		this.CaseName = name;
		this.isCheck = check;
		this.expectedResult = result;
		this.testData = testData;
	}

	public String getCaseName() {
		return CaseName;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public String getExpectedResult() {
		return expectedResult;
	}

	public Map<String, String> getTestData() {
		return testData;
	}
}
