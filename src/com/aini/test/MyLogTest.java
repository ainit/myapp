package com.aini.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.aini.log.LoggerManager;

public class MyLogTest {
	public static void main(String[] args) {
		PropertyConfigurator.configure( "C:\\Users\\zwb\\workspace\\Test\\src\\log4j.properties" );
		LoggerManager log = LoggerManager.getLogger(MyLogTest.class);
		log.info("hello");
		log.error("xxxx");
	}
}
