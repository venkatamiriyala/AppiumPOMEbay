/*
 * package com.qa.pages;
 * 
 * import com.qa.BaseTest; import com.qa.utils.TestUtils;
 * 
 * import io.appium.java_client.MobileElement; import
 * io.appium.java_client.pagefactory.AndroidFindBy; import
 * io.appium.java_client.pagefactory.iOSXCUITFindBy;
 * 
 * public class ProductDetailsPage extends HomePage {
 * 
 * TestUtils utils = new TestUtils();
 * 
 * @AndroidFindBy (xpath ="//*[@id='textview_item_name']") //@iOSXCUITFindBy
 * private MobileElement itemName;
 * 
 * //*[@id='textview_item_price']
 * 
 * //*[@id='button_bin'] //*[@id='seller_value']
 * 
 * 
 * 
 * //*[@id='alertTitle'] //*[@id='button1']
 * 
 * 
 * 
 * 
 * public String getTitle() { String title = getText(productTitleTxt);
 * utils.log().info("product page title is - " + title); return title; }
 * 
 * public String getSLBTitle() { String title = getText(SLBTitle);
 * utils.log().info("title is - " + title); return title; }
 * 
 * public String getSLBPrice() { String price = getText(SLBPrice);
 * utils.log().info("price is - " + price); return price; }
 * 
 * 
 * public ProductDetailsPage pressSLBTitle() {
 * utils.log().info("press SLB tile link"); click(SLBTitle); return new
 * ProductDetailsPage(); }
 * 
 * }
 */