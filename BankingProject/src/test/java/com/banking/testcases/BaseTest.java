package com.banking.testcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.banking.resources.ReadConfig;
import com.banking.utilities.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	protected Logger logger;

	@BeforeClass
	public void setUp() {
		this.driver = DriverFactory.getDriver(readConfig.getBrowser());
		logger = Logger.getLogger("Banking Test Logs");
		PropertyConfigurator.configure("Log4j.properties");

	}

	@AfterClass
	public void tearDrow() {

		this.driver.quit();

	}

	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
