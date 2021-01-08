package com.banking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pages.LoginPage;

public class TC01_LoginTest extends BaseTest{
	
	LoginPage loginPage;	
	
	@Test
	public void loginTest() throws IOException {
		driver.get(readConfig.getBaseURL());
		logger.info("Testcases starting");
		loginPage = new LoginPage(driver);
		loginPage.setUserId(readConfig.getUserId());
		loginPage.setPassword(readConfig.getPassword());
		loginPage.clickLoginBtn();
		
		logger.info("Testcases ending");
		captureScreen(driver,"loginTest");
		Assert.assertTrue(true);
		logger.info("Login test passed");
	}
	

}
