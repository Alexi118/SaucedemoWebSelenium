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

    @Test(dataProvider = "LoginUnsuccessful1")
    public void loginUnsuccessfullyWithEmptyUser(String username,String password){
        loginPage.action_Login(username,password);
        loginPage.btn_cancel_error.click();
        common.waitForVisibilityOfElement(loginPage.box_error);
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username is required");
    }
    @DataProvider(name = "LoginUnsuccessful1")
    public Object[][] loginUnsuccessfullyWithEmptyUserData() throws Exception {
        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
        return excel.getTableByColumn(2);
    }

//    @Test(dataProvider = "LoginUnsuccessful2")
//    public void loginUnsuccessfullyWithEmptyPassword(String username,String password){
//        loginPage.action_Login(username,password);
//        loginPage.btn_cancel_error.click();
//        common.waitForVisibilityOfElement(loginPage.box_error);
//        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Password is required");
//    }
//    @DataProvider(name = "LoginUnsuccessful2")
//    public Object[][] loginUnsuccessfullyWithEmptyPasswordData() throws Exception {
//        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
//        return excel.getTableArray(2);
//    }
//
//    @Test(dataProvider = "LoginUnsuccessful3")
//    public void loginUnsuccessfullyWithWrongUser(String username,String password){
//        loginPage.action_Login(username,password);
//        loginPage.btn_cancel_error.click();
//        common.waitForVisibilityOfElement(loginPage.box_error);
//        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
//    }
//    @DataProvider(name = "LoginUnsuccessful3")
//    public Object[][] loginUnsuccessfullyWithWrongUserData() throws Exception {
//        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
//        return excel.getTableArray(2);
//    }
//
//    @Test(dataProvider = "LoginUnsuccessful4")
//    public void loginUnsuccessfullyWithWrongPassword(String username,String password){
//        loginPage.action_Login(username,password);
//        loginPage.btn_cancel_error.click();
//        common.waitForVisibilityOfElement(loginPage.box_error);
//        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
//    }
//    @DataProvider(name = "LoginUnsuccessful4")
//    public Object[][] loginUnsuccessfullyWithWrongPasswordData() throws Exception {
//        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginUnSuccessful);
//        return excel.getTableArray(2);
//    }
}
