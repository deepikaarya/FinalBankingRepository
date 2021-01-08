package com.banking.resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class ReadConfig {
	Properties pro;
	File src = new File("./Configurations/config.properties");
	
	public ReadConfig() 
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBrowser()
	{
		String getData = pro.getProperty("browser");
		return(getData);
		
	}
	
	
	public String getBaseURL()
	{
		String getData = pro.getProperty("baseURL");
		return(getData);
		
	}
	
	public String getUserId()
	{
		String getData = pro.getProperty("userId");
		return(getData);
		
	}
	
	
	public String getPassword()
	{
		String getData = pro.getProperty("pwd");
		return(getData);
		
	}
	
}
