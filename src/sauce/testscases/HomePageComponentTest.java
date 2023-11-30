package testscases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Constants;

public class HomePageComponentTest extends BaseTest{
    @Test
    public void checkBurgerBtnItemList(){
        loginPage.action_LoginWithCorrectUser();
        common.action_clickOn_element(homePage.burgerBtn);
        common.waitForVisibilityOfElement(homePage.burgerBtn_ItemList);
        Assert.assertEquals(homePage.burgerBtn_ItemList.getText(),"All Items\nAbout\nLogout\nReset App State");
    }
    @Test
    public void checkBurgerBtn_AllItemsBtn(){
        checkBurgerBtnItemList();
        common.action_clickOn_element(homePage.all_items_Btn);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void checkBurgerBtn_AboutBtn(){
        checkBurgerBtnItemList();
        common.action_clickOn_element(homePage.about_Btn);
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }
    @Test
    public void checkBurgerBtn_LogOutBtn(){
        checkBurgerBtnItemList();
        common.action_clickOn_element(homePage.logOut_Btn);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.baseURL);
    }
    @Test
    public void checkBurgerBtn_ResetAppStateBtn(){
        checkBurgerBtnItemList();
        common.action_clickOn_element(homePage.resetAppState_Btn);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void homePageFilterFromAtoZSuccessfully(){
        loginPage.action_LoginWithCorrectUser();
        common.action_select_dropdown("az", homePage.filter_box);
        Assert.assertEquals(homePage.active_option_filter_box.getText(),"Name (A to Z)");
        Assert.assertEquals(common.getListOfWebElementsToString(homePage.allInventoryItemsNames),common.sortListTextASC(homePage.allInventoryItemsNames));
    }
    @Test
    public void homePageFilterFromZtoASuccessfully(){
        loginPage.action_LoginWithCorrectUser();
        common.action_select_dropdown("za", homePage.filter_box);
        Assert.assertEquals(homePage.active_option_filter_box.getText(),"Name (Z to A)");
        Assert.assertEquals(common.getListOfWebElementsToString(homePage.allInventoryItemsNames),common.sortListTextDESC(homePage.allInventoryItemsNames));
    }
    @Test
    public void homePageFilterFromLowToHighSuccessfully(){
        loginPage.action_LoginWithCorrectUser();
        common.action_select_dropdown("lohi", homePage.filter_box);
        Assert.assertEquals(homePage.active_option_filter_box.getText(),"Price (low to high)");
        Assert.assertEquals(common.getListOfWebElementsToString(homePage.priceForEachInventoryItems), common.sortListNumberASC(homePage.priceForEachInventoryItems));
    }
    @Test
    public void homePageFilterFromHighToLowSuccessfully(){
        loginPage.action_LoginWithCorrectUser();
        common.action_select_dropdown("hilo", homePage.filter_box);
        Assert.assertEquals(homePage.active_option_filter_box.getText(),"Price (high to low)");
        Assert.assertEquals(common.getListOfWebElementsToString(homePage.priceForEachInventoryItems), common.sortListNumberDESC(homePage.priceForEachInventoryItems));
    }
    @Test
    public void addAndRemoveItemFromShoppingCartOnHomePage(){
        loginPage.action_LoginWithCorrectUser();
        common.action_clickOn_element(homePage.addRemove1stItemOnHomepage_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"1");
        common.action_clickOn_element(homePage.addRemove2ndItemOnHomepage_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"2");
        common.action_clickOn_element(homePage.addRemove3rdItemOnHomepage_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"3");
        common.action_clickOn_element(homePage.addRemove2ndItemOnHomepage_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"2");
        common.action_clickOn_element(homePage.addRemove3rdItemOnHomepage_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"1");
        common.action_clickOn_element(homePage.addRemove1stItemOnHomepage_Btn);
        Assert.assertEquals(common.isDisplayed(cartPage.cartBadgeCount), false);
        common.action_clickOn_element(homePage.addRemove4thItemOnHomepage_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"1");
    }
    @Test
    public void footerRedirectCorrectly() throws InterruptedException {
        loginPage.action_LoginWithCorrectUser();
        Assert.assertEquals(homePage.footer_text.getText(),"© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
        common.action_clickOn_element(homePage.twitter_icon);
        Thread.sleep(2000);
        common.action_switchToAnother_Tab();
        Assert.assertEquals(driver.getCurrentUrl(),"https://twitter.com/saucelabs");
        common.action_switchBackToBaseURL_Tab();
        common.action_clickOn_element(homePage.facebook_icon);
        Thread.sleep(2000);
        common.action_switchToAnother_Tab();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/saucelabs");
        common.action_switchBackToBaseURL_Tab();
        common.action_clickOn_element(homePage.linkedin_icon);
        Thread.sleep(2000);
        common.action_switchToAnother_Tab();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/company/sauce-labs/");
        common.action_switchBackToBaseURL_Tab();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
