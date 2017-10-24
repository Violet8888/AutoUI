package com.ui.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestReportNG {
  @Test
  public void f1() {
	  System.setProperty("org.uncommons.reportng.escape-output", "false"); 
	  Reporter.log("<span style=\"color:#16A05D\"><H1>hello</H1>");
	  Assert.assertFalse(true);
  }
  @Test
  public void f2() {
	  System.setProperty("org.uncommons.reportng.escape-output", "false"); 
	  Reporter.log("<span style=\"color:#16A05D\"><H1>hello</H1>");
	  Assert.assertFalse(false);
  }
}
