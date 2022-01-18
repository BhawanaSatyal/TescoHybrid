package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class GroceryPage extends Utils{
   Actions actions = new Actions(driver);

   By _btn_Signout = By.xpath("//div[@id=\"main\"]/div/div[1]/div[1]/div/div/div/div/div/ul/li[5]/a/span");
   By _btn_GroceryOrders = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div/div[2]/div/div[1]/ul/ul/li[1]/a/span");
   By _txt_Search = By.id("search-input");
   By _txt_Flash = By.id("id_299772342_3");
   By _btn_AddItem = By.xpath("//*[@id=\"tile-299772342\"]/div[2]/form/div/div[2]/button/span[1]");
   By _btn_Checkout = By.xpath("//a[@class='button button-primary mini-trolley__checkout']/span");
   By _btn_ClickAndCollect = By.xpath("//*[@id=\"main\"]/div[1]/div/div[1]/div[3]/div/div/div[2]/a/div[2]/h3");
   By _txt_Postcode = By.id("postcode-input-large");
   By _btn_SearchPostcode = By.xpath("//*[@id=\"selected-slot-map\"]/div[2]/div[1]/div/form[2]/button");


   public void verifyUserIsOnAlreadyLoggedIn(){

      Assert.assertTrue(driver.findElement((_btn_Signout)).isDisplayed());

  
   }

   public void userClicksOnGroceryOrders(){
      clickOnElement(_btn_GroceryOrders);
}
   public void userSearchForCleaningProducts(){
      typeText(_txt_Search, loadProp.getProperty("CleaningProduct"));
      actions.sendKeys(Keys.ENTER).perform();

   }
   public void userClearsDefaultQtyAndAddsRequiredQty(){
      clickOnElement(_txt_Flash);
      actions.sendKeys(Keys.BACK_SPACE).perform();
      typeText(_txt_Flash, loadProp.getProperty("FlashQty"));
      clickOnElement(_btn_AddItem);
   }

   public void userIsAbleToCheckOutAndBookDeliverySlot(){
      clickOnElement(_btn_Checkout);
      clickOnElement(_btn_ClickAndCollect);
      typeText(_txt_Postcode,loadProp.getProperty("Postcode"));
      clickOnElement(_btn_SearchPostcode);


   }
}