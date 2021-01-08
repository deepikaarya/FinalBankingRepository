package com.banking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pages.LoginPage;
import com.banking.utilities.XLUtils;
import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

public class TC02_LoginUsingExcelTest extends BaseTest {

LoginPage loginPage;	
	
	@Test(dataProvider = "excelLoginData")
	public void loginTest(String user, String passsword) throws IOException, InterruptedException {
		driver.get(readConfig.getBaseURL());
		logger.info("Testcases starting");
		loginPage = new LoginPage(driver);
		loginPage.setUserId(user);
		loginPage.setPassword(passsword);
		loginPage.clickLoginBtn();
		Thread.sleep(2000);
		
		if(IsAlertPresent())
		{

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver,"loginTest");
			logger.info("Testcase Failed where userId :"+ user + " password :" + passsword);
			Assert.assertTrue(false);
		}
		
		else {
		
			logger.info(" Valid Credentials where userId :"+  user + " password : " + passsword); 
			loginPage.clickLogOutBtn();
			logger.info("Testcase Passed where userId :"+ user + " password :" + passsword);
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		logger.info("Testcases ending");
		
	}
	
	
	public boolean IsAlertPresent() {
		
		try {
		driver.switchTo().alert();
		return true;
		}catch (NoAlertPresentException e) {

			return false;
		}
		
		
	}
	
	@DataProvider(name="excelLoginData")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/banking/testdata/LoginData.xlsx";
		String sheetName="LoginDetails";
		int rowNum = XLUtils.getRowCount(path, sheetName);
		int cellCount = XLUtils.getCellCount(path, sheetName, 1);
		
		String loginData[][] = new String[rowNum][cellCount];
		
		for (int i=1;i<=rowNum;i++) {
			for(int j=0; j<cellCount;j++) {
				
				loginData[i-1][j]=XLUtils.getCellData(path, sheetName, i, j);
				
			}
		}
		
		return loginData;
		
	}
	
}
