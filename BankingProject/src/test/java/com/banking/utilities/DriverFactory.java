package com.banking.utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Supplier;

public class DriverFactory {
	
	private static final Supplier<WebDriver> chromeSupplier= ()-> {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		return new ChromeDriver();
		
	};
	
	private static Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
	
	static {
		
		MAP.put("chrome", chromeSupplier);
	}

	public static WebDriver getDriver(String browser) {
		
		return MAP.get(browser).get();
		
	}
	
}
