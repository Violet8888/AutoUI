package com.ui.demo;

import java.util.List;
import com.ui.utils.ExeclUtils;
import com.ui.utils.TestCase;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		
		String path = "TestData.xlsx";
		List<TestCase> testcases = ExeclUtils.getUITestData(path);
		
		for(int i=0;i<testcases.size();i++){
			System.out.println(testcases.get(i).getCaseName());
			System.out.println(testcases.get(i).getIsCheck());
			System.out.println(testcases.get(i).getExpectedResult());
			System.out.println(testcases.get(i).getTestData());
		}
		
	}

}
