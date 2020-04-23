
  package com.qa.tests;
  import org.testng.annotations.Test;
  import org.testng.asserts.SoftAssert;
  
  import com.qa.BaseTest;
  import com.qa.pages.HomePage;
  import com.qa.pages.LoginPage;
  import com.qa.pages.ProductsPage;
  import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.testng.annotations.BeforeMethod;
  import org.testng.annotations.AfterMethod;
  import org.testng.annotations.BeforeClass;
  
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.PrintWriter;
  import java.io.StringWriter;
  import java.lang.reflect.Method;

import org.json.JSONException;
import org.json.JSONObject;
  import org.json.JSONTokener;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
  import org.testng.annotations.AfterClass;
  
  public class ProductTests extends BaseTest{
	  LoginPage loginPage;
	  
	  HomePage homePage;
	  JSONObject loginUsers;
	  TestUtils utils = new TestUtils();
  
  @BeforeClass public void beforeClass() throws Exception {
	  InputStream datais = null;
	  try {
		  String dataFileName = "data/login.json";
		  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
		  JSONTokener tokener = new JSONTokener(datais); loginUsers = new JSONObject(tokener);
		  }
	  catch(Exception e) { e.printStackTrace(); throw e; }
	  finally {
		  if(datais != null) { datais.close(); } }
	  closeApp();
	  launchApp();
	  }
  
  @AfterClass public void afterClass() { }
  
  @BeforeMethod public void beforeMethod(Method m) throws JSONException, InterruptedException {
	  utils.log().info("\n" +  "****** starting test:" + m.getName() + "******" + "\n");
	  loginPage = new LoginPage();
      homePage = loginPage.login(loginUsers.getJSONObject("validUser").getString("username"),
    		  			loginUsers.getJSONObject("validUser").getString("password"));
      
  }
  
  @AfterMethod public void afterMethod() {
	  //settingsPage =  productsPage.pressSettingsBtn(); loginPage = settingsPage.pressLogoutBtn(); }
  }
  
  @Test
  public void searchForAnItem() throws InterruptedException {
	  
	  homePage.clickSearchLink();
	  homePage.enterSearchItem("65 inch TV" + "\n");

	  ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
	  
	  Thread.sleep(3000);
	  
  }
  
  
  }
  