package testscases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryItemPageComponentTest extends BaseTest {
    @Test
    public void selectFirstItem_ByClickingOnImg(){
        loginPage.action_LoginWithCorrectUser();
        String name = homePage.firstItem_Name.getText();
        common.action_clickOn_element(homePage.firstItem_Img);
        Assert.assertEquals(inventoryItemPage.item_Name.getText(),name);
    }
    @Test
    public void selectFirstItem_ByClickingOnName(){
        loginPage.action_LoginWithCorrectUser();
        String name = homePage.firstItem_Name.getText();
        common.action_clickOn_element(homePage.firstItem_Name);
        Assert.assertEquals(inventoryItemPage.item_Name.getText(),name);
    }
    @Test
    public void addAndRemoveItemFromShoppingCartOnInventoryItemPage() {
        loginPage.action_LoginWithCorrectUser();
        common.action_clickOn_element(homePage.firstItem_Name);
        common.action_clickOn_element(inventoryItemPage.itemAdd_Btn);
        Assert.assertEquals(cartPage.cartBadgeCount.getText(),"1");
        common.action_clickOn_element(inventoryItemPage.itemRemove_Btn);
        Assert.assertEquals(common.isDisplayed(cartPage.cartBadgeCount), false);
    }
    @Test
    public void redirectToHomePage_ByclickOnBackToProducts(){
        loginPage.action_LoginWithCorrectUser();
        common.action_clickOn_element(homePage.firstItem_Name);
        common.action_clickOn_element(inventoryItemPage.backToProducts_Btn);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
