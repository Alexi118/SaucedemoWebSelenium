package testscases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchasingItemTest extends BaseTest{
    @Test
    public void purchasingItemE2E_Successfully(){
        loginPage.action_LoginWithCorrectUser();
        common.action_clickOn_element(homePage.addRemove1stItemOnHomepage_Btn);
        common.action_clickOn_element(homePage.addRemove2ndItemOnHomepage_Btn);
        common.action_clickOn_element(homePage.addRemove3rdItemOnHomepage_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"3");
        common.action_clickOn_element(cartPage.cartIcon_Link);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        common.action_clickOn_element(cartPage.checkOut_Btn);
        checkOutPage.action_fillInCorrectICheckOutInfo();
        common.action_clickOn_element(checkOutPage.continue_Btn);
        Assert.assertEquals(common.getNumberInString(checkOutSecondPage.itemTotalbeforeTax.getText()),common.sumOfNumberInList(checkOutSecondPage.allItemsPrice));
        common.sumOfNumberInList(checkOutSecondPage.allItemsPrice);
        common.action_clickOn_element(checkOutSecondPage.finish_Btn);
    }
    @Test
    public void testdoubleClick(){
        loginPage.action_LoginWithCorrectUser();
        common.action_clickOn_element(homePage.addRemove1stItemOnHomepage_Btn);
        common.doubleClick(homePage.addRemove1stItemOnHomepage_Btn);
    }

}
