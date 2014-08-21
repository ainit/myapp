package com.sogou.log;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

public class LoggerManager  {
	
	private Logger logger;
	
	public LoggerManager(String name){
		//super(name);
		logger = Logger.getLogger(name);
	}
	
	public LoggerManager(Class clazz){
		//super(clazz.getName());
		logger = Logger.getLogger(clazz);
	}
	
	public static LoggerManager getLogger(String name){
		return new LoggerManager(name);
	}
	
	public static LoggerManager getLogger(Class clazz){
		return new LoggerManager(clazz);
	}
	
	
	public void info(Object message){
		logger.info(message);
	}
	
	public void info(Object message,Throwable t){
		logger.info(message, t);
	}
	
	
	public void error(Object message){
		logger.error(message);
	}
	
	public void error(Object message,Throwable t){
		logger.error(message, t);
	}
}
