package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Utils {
    Actions actions = new Actions(driver);

    By _btn_Accounts = By.linkText("My account");
    By _btn_AcceptCookies = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/form/button/span/span");
    By _txt_Email = By.id("email");
    By _txt_Password = By.id("password");
    By _btn_SignIn = By.id("signin-button");



    //  WebDriverWait wait = new WebDriverWait(driver,10);


    public void verifyUserIsOnLogInPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("tesco"));
        System.out.println("You are on correct homepage");
    }

    public void acceptCookies() {
        clickOnElement(_btn_AcceptCookies);
    }

    public void clickOnMyAccounts() {
        clickOnElement(_btn_Accounts);

    }

    public void UserInputsLogInDetails() {
        typeText(_txt_Email, loadProp.getProperty("Email"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions.sendKeys(Keys.TAB).perform();
        typeText(_txt_Password, loadProp.getProperty("Password"));

    }

    public void userClicksOnSignInButton() {
        clickOnElement(_btn_SignIn);

    }
    public void verifyUserIsSignedInSuccessfully(){
        String expectedSuccessmessage = "Bhawana";
        String actualSuccessmessage = getTextFromElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div/div[1]/h3/div/span/span[2]"));
        Assert.assertEquals(actualSuccessmessage,expectedSuccessmessage,"LogIn success message do not match");

    }
}
