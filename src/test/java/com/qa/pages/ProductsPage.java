
  package com.qa.pages;
  
  import com.qa.BaseTest; import com.qa.utils.TestUtils;
  
  import io.appium.java_client.MobileElement; import
  io.appium.java_client.pagefactory.AndroidFindBy; import
  io.appium.java_client.pagefactory.iOSXCUITFindBy;
  
  public class ProductsPage extends HomePage {
  
  TestUtils utils = new TestUtils();
  
  @AndroidFindBy (xpath ="//*[@id='textview_item_count']") //@iOSXCUITFindBy
  private MobileElement resultsCount;
  
  @AndroidFindBy (xpath ="//*[@id='cell_collection_item']") //@iOSXCUITFindBy
  private MobileElement resultsCellBlock;
  
  @AndroidFindBy (xpath ="//*[@id='textview_item_title']") //@iOSXCUITFindBy
  private MobileElement resultsItemTitle;
  
  
  }
 