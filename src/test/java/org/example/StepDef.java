package org.example;

import io.cucumber.java.en.*;

public class StepDef {

    LoginPage loginPage = new LoginPage();
    GroceryPage groceryPage = new GroceryPage();
    SocialMediaPage socialMediaPage = new SocialMediaPage();


    @Given("I am on homepage")
    public void i_am_on_homepage() {
        loginPage.verifyUserIsOnLogInPage();

    }

    @When("I click on My account")
    public void i_click_on_my_account() {
        loginPage.acceptCookies();
        loginPage.clickOnMyAccounts();

    }

    @And("I fill up log in details")
    public void iFillUpLogInDetails() {
        loginPage.UserInputsLogInDetails();

    }

    @When("I click on Sign in")
    public void i_click_on_sign_in() {
        loginPage.userClicksOnSignInButton();

    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        loginPage.verifyUserIsSignedInSuccessfully();


    }


    @Given("I am logged in")
    public void i_am_logged_in() {
        i_click_on_my_account();
        iFillUpLogInDetails();
        i_click_on_sign_in();
        groceryPage.verifyUserIsOnAlreadyLoggedIn();

    }

    @When("I click on Grocery Orders")
    public void i_click_on_grocery_orders() {

        groceryPage.userClicksOnGroceryOrders();

    }

    @When("I search for required item")
    public void i_search_for_required_item() {
        groceryPage.userSearchForCleaningProducts();

    }

    @Then("I should be able to able to amend qty on related items and add to cart")
    public void i_Should_Be_Able_To_Able_To_Amend_Qty_On_Related_Items_And_Add_To_Cart() {

        groceryPage.userClearsDefaultQtyAndAddsRequiredQty();
    }

    @And("I should be able to checkout and book delivery slot")
    public void i_Should_Be_Able_To_Checkout_And_Book_Delivery_Slot() {
        groceryPage.userIsAbleToCheckOutAndBookDeliverySlot();

   }


    @Given("I am on a homepage")
    public void i_am_on_a_homepage() {
        socialMediaPage.verifyUserIsOnHomePage();

    }
//    @When("I click on {String} icon")
//    public void iClickOnSocial_mediaIcon(String socialLink) {
//        socialMediaPage.clickONSocialLinks(socialLink);

    @When("I click on facebook icon")
    public void i_click_on_facebook_icon() {
        socialMediaPage.clickOnFacebookIcon();

    }

    @Then("I should be able to navigate to facebook page")
    public void i_should_be_able_to_navigate_to_facebook_page() {
        socialMediaPage.handleWindow();

    }

    @And("I click on twitter icon")
    public void iClickOnTwitterIcon() {
     socialMediaPage.handleWindow1();

    }

    @Then("I should be able to navigate to twitter page")
    public void iShouldBeAbleToNavigateToTwitterPage() {
        socialMediaPage.userShouldBeAbleToHoverOnCategories();

    }

//
//    @When("I click on {string} icon")
//    public void iClickOnIcon(String socialLink) { socialMediaPage.clickONSocialLinks(socialLink);
//
//    }
}

