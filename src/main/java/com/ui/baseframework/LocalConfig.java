package com.ui.baseframework;

import com.ui.utils.PropertiesUtils;

public class LocalConfig {
	
	public static final PropertiesUtils pro = new PropertiesUtils("local.properties");
	public static final String URL = pro.readProperties("url");
	public static final String SHOTPATH = pro.readProperties("shotpath");
	
}
