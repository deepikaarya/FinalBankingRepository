package com.banking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(name = "uid")
	private WebElement userId;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "btnLogin")
	private WebElement btnLogin;

	@FindBy(linkText = "Log out")
	private WebElement logOutBtn;
	
	public void setUserId(String userId) {

		this.userId.sendKeys(userId);

	}
	
	public void setPassword(String password) {

		this.password.sendKeys(password);

	}
	
	public void clickLoginBtn() {

		btnLogin.click();

	}
	
	public void clickLogOutBtn() {

		logOutBtn.click();

	}
}
