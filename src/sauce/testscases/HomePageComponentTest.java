package testscases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Constants;

public class HomePageComponentTest extends BaseTest {
    @Test
    public void checkBurgerBtnItemList(){
        loginPage.action_LoginWithCorrectUser();
        common.action_clickOn_element(homePage.burgerBtn);
        common.waitForVisibilityOfElement(homePage.burgerBtn_ItemList);
        Assert.assertEquals(homePage.burgerBtn_ItemList.getText(),"All Items\nAbout\nLogout\nReset App State");
    }
    @Test
    public void checkBurgerBtn_allitemsBtn(){
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
    public void homePageFilterSuccessfully(){
        loginPage.action_LoginWithCorrectUser();
        common.action_select_dropdown("lohi", homePage.filter_box);
    }
}
