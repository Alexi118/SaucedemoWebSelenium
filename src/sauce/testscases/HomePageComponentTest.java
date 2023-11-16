package testscases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageComponentTest extends BaseTest {
    @Test
    public void checkBurgerBtnItemList(){
        loginPage.action_LoginWithCorrectUser();
        homePage.burgerBtn.click();
        normalWait.until(ExpectedConditions.visibilityOf(homePage.burgerBtn_ItemList));
        Assert.assertEquals(homePage.burgerBtn_ItemList.getText(),"All Items\nAbout\nLogout\nReset App State");
    }
    @Test
    public void homePageFilterSuccessfully(){
        loginPage.action_LoginWithCorrectUser();
        homePage.action_select_dropdown_filter_box("lohi");
    }
}
