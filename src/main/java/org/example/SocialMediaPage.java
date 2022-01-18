package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class SocialMediaPage extends Utils {
    Actions actions = new Actions(driver);
    By _btn_Contactus = By.linkText("Contact us");
    By _btn_AcceptCookies = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/form/button/span/span");
    By _btn_Facebook = By.xpath("//a[@class='facebook-icon']");
    By _btn_AllowCookies = By.xpath("//button[@title='Allow All Cookies']");
    By _btn_Twitter = By.xpath("//a[@class='twitter-icon']");
    By _btn_closePopUp = By.xpath("//*[@id=\"layers\"]/div/div[2]/div/div/div/div[2]/div/span/span");
    By _btn_Groceries = By.xpath("//a[@title='Groceries']");
    By _btn_ShopGroceries = By.xpath("//*[@id=\"navigation\"]/div[1]/ul/li[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/a/h3/span");



    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(driver.findElement((_btn_Contactus)).isDisplayed());
//   }
//    public void clickONSocialLinks(String socialLink) {
//        clickOnElement(By.linkText(socialLink));
    }

    public void clickOnFacebookIcon() {
        clickOnElement(_btn_AcceptCookies);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clickOnElement(_btn_Facebook);

    }



    public void handleWindow() {
        Set<String> windowhandles = driver.getWindowHandles();
        Iterator<String> iterator = windowhandles.iterator();
        String parentwindow = iterator.next();
        String childwindow = iterator.next();
        driver.switchTo().window(childwindow);

        clickOnElement(_btn_AllowCookies);
        driver.close();
        driver.switchTo().window(parentwindow);
        clickOnElement(_btn_Twitter);
    }

    public void handleWindow1() {
        Set<String> windowhandles = driver.getWindowHandles();
        Iterator<String> iterator = windowhandles.iterator();
        String parentwindow = iterator.next();
        String childwindow = iterator.next();
        driver.switchTo().window(childwindow);
        clickOnElement(_btn_closePopUp);
        driver.close();
        driver.switchTo().window(parentwindow);

    }

    public void userShouldBeAbleToHoverOnCategories(){
      //  System.out.println(driver.getCurrentUrl());
        actions.moveToElement(driver.findElement(_btn_Groceries)).click().perform();
       // actions.moveToElement(driver.findElement(_btn_ShopGroceries)).click().perform();
        clickOnElement(_btn_ShopGroceries);
        String color = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/nav[2]/div/div/div")).getCssValue("color");
        System.out.println(color);
        String hexColor = Color.fromString(color).asHex();
        String expectedColor = "#333333";
        Assert.assertEquals(hexColor,expectedColor,"incorrect text color");
        System.out.println("Colour Matched");



    }




}

