package com.ui.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ReadLog {
	
	static Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		
		log.error("error");

	}

}
