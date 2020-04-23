package com.qa.pages;

import java.awt.Menu;
import java.sql.Driver;

import org.openqa.selenium.interactions.SendKeysAction;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {
	
	TestUtils utils = new TestUtils();
	HomePage homePage = new HomePage();
	
	@AndroidFindBy (id = "edit_text_username") private MobileElement userNameInput;
	@AndroidFindBy (id = "et_temp") private MobileElement userPwdInput;
	@AndroidFindBy (id = "button_sign_in") private MobileElement signInBtn;
	@AndroidFindBy (id = "bt_maybe_later") private MobileElement fingerLink;
	
	
	public LoginPage enterUserName(String userName) {
		clear(userNameInput);
		utils.log().info("login with " + userName);
		sendKeys(userNameInput, userName);
		return this;
	}

	public LoginPage enterPassword(String pwd) {
		clear(userPwdInput);
		sendKeys(userPwdInput, pwd);
		return this;
	}
	
		
	public HomePage login(String username, String password) throws InterruptedException {
		homePage.clickSignINOption();
		enterUserName(username);
		enterPassword(password);
		utils.log().info("Clicking on login button");
		click(signInBtn);
		click(fingerLink);
		Thread.sleep(3000);
		return new HomePage();
		}
		

}

