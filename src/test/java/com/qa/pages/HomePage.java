package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BaseTest{
	
	TestUtils utils = new TestUtils();

	@AndroidFindBy (accessibility = "Main navigation, open") 
	@iOSXCUITFindBy (id = "Main navigation, open")
	private MobileElement menu;
	
	
	@AndroidFindBy (id  = "textview_sign_out_status") private MobileElement signInLnk;
	@AndroidFindBy (id = "button_classic") private MobileElement useEmailBtn;
	@AndroidFindBy (xpath = "//*[@id='textview_sign_in_status']") private MobileElement profileIcon;
	@AndroidFindBy (xpath = "//*[@text='Sign out']") private MobileElement logOut;
	
	@AndroidFindBy (id = "com.ebay.mobile:id/logo") private MobileElement logo;
	@AndroidFindBy (id = "com.ebay.mobile:id/search_box") private MobileElement searchBoxLink;
	@AndroidFindBy (id = "com.ebay.mobile:id/search_src_text") private MobileElement searchTextBox;
	
	 @AndroidFindBy (xpath ="//*[@id='title']")
	  //@iOSXCUITFindBy 
	  private MobileElement pageTitle;
	
	//*[@id='search_plate']
	
	 
	
	public HomePage clickMenu() {
		click(menu);
		return this;
		}

	public HomePage logOut() throws InterruptedException {
		
	try {
		if(profileIcon.isDisplayed())
		{
			profileIcon.click();	
			waitForVisibility(logOut);
			logOut.click();
			clickMenu();
		}
	
		} catch (Exception e) {
			// TODO: handle exception
		}
			return this;
	}
	
	
	public LoginPage clickSignINOption() throws InterruptedException {
		clickMenu();
		logOut();
		waitForVisibility(signInLnk);
		click(signInLnk);
		click(useEmailBtn);
		return new LoginPage();
	}
	 
	public String getTitle() {
		String title = getText(pageTitle);
	  utils.log().info("Page title is - " + title);
	  return title;
	  }
	 
	public HomePage verifyeBayLogo() {
		waitForVisibility(logo);
		return this;
	}
	
	public HomePage clickSearchLink() {
		click(searchBoxLink);
		return this;
	}
	
	public HomePage enterSearchItem(String searchItem) {
			sendKeys(searchTextBox, searchItem);
			return this;
		}
	
}
