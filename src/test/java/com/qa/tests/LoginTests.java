package com.qa.tests;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import com.qa.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginTests extends BaseTest {
	
	LoginPage loginPage;
	HomePage homePage;
	InputStream datais;
	JSONObject loginUsers;
	
  @BeforeClass
  public void beforeClass() throws Exception {
	  try {
		  String dataFilename = "data/login.json";
		  datais = getClass().getClassLoader().getResourceAsStream(dataFilename);
		  JSONTokener tokener = new JSONTokener(datais);
		  loginUsers = new JSONObject(tokener);
 	     }catch (Exception e) {
		  e.printStackTrace();
		  throw e;
	     }finally {
		  if(datais !=null)
		  datais.close();}
	  // To keep the test cases Independed ( base state)
	  closeApp();
	  launchApp();
	  // ALso keep Login and logout methods in @Before methods and @after method
  }

  @AfterClass
  public void afterClass() {
  }
	
  @BeforeMethod
  public void beforeMethod(Method m) {
	  loginPage = new LoginPage();
	  homePage = new HomePage();
	  System.out.println("\n" + "********* Starting Test: " + m.getName() + "****"+"\n" );
  }

  @AfterMethod
  public void afterMethod() {
  }
  
  @Test
  public void verifyLogin() throws InterruptedException {
      loginPage.login(loginUsers.getJSONObject("validUser").getString("username") ,
			          loginUsers.getJSONObject("validUser").getString("password"));
      homePage.verifyeBayLogo();
      utils.log().info("Login is Successfull");
  
  }
  
}
