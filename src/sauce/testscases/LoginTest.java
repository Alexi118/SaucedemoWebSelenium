package testscases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Constants;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "LoginSuccessful")
    public void loginSuccessfullyWithStandardUser(String username,String password){
        loginPage.action_Login(username,password);
        common.waitForVisibilityOfElement(homePage.banner_AppLogo);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @DataProvider(name = "LoginSuccessful")
    public Object[][] loginSuccessfullyWithStandardUserData() throws Exception {
        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginSuccessful);
        return excel.getTableByColumn(2);
    }

    @Test()
    public void loginUnsuccessfullyWithEmptyUser() throws Exception{
        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
        String username = excel.getCellData(1,0);
        String password = excel.getCellData(1,1);
        loginPage.action_Login(username,password);
        common.waitForVisibilityOfElement(loginPage.box_error);
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username is required");
        common.action_clickOn_element(loginPage.btn_cancel_error);
    }

    @Test()
    public void loginUnsuccessfullyWithEmptyPassword() throws Exception{
        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
        String username = excel.getCellData(2,0);
        String password = excel.getCellData(2,1);
        loginPage.action_Login(username,password);
        common.waitForVisibilityOfElement(loginPage.box_error);
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Password is required");
        common.action_clickOn_element(loginPage.btn_cancel_error);
    }

    @Test()
    public void loginUnsuccessfullyWithWrongUser() throws Exception{
        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
        String username = excel.getCellData(3,0);
        String password = excel.getCellData(3,1);
        loginPage.action_Login(username,password);
        common.waitForVisibilityOfElement(loginPage.box_error);
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
        common.action_clickOn_element(loginPage.btn_cancel_error);
    }

    @Test()
    public void loginUnsuccessfullyWithWrongPassword() throws Exception{
        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
        String username = excel.getCellData(4,0);
        String password = excel.getCellData(4,1);
        loginPage.action_Login(username,password);
        common.waitForVisibilityOfElement(loginPage.box_error);
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
        common.action_clickOn_element(loginPage.btn_cancel_error);
    }
}
