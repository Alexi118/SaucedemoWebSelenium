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
        longWait.until(ExpectedConditions.visibilityOf(homePage.banner_AppLogo));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html" );
    }
    @DataProvider(name = "LoginSuccessful")
    public Object[][] getLoginSuccessfulData() throws Exception {
        ExcelUtils excel = new ExcelUtils(Constants.DataPath_Login, Constants.DataSheet_LoginSuccessful);
        return excel.getTableArray(2);
    }
//
//    @Test()
//    public void loginUnsuccessfullyWithEmptyUser(){
//        loginPage.action_Login("","secret_sauce");
//        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username is required");
//        loginPage.btn_cancel_error.click();
//        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
//    }
//
//    @Test()
//    public void loginUnsuccessfullyWithEmptyPassword(){
//        loginPage.action_Login("standard_user","");
//        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Password is required");
//        loginPage.btn_cancel_error.click();
//        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
//    }
//
//    @Test()
//    public void loginUnsuccessfullyWithWrongUser(){
//        loginPage.action_Login("standard","secret_sauce");
//        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
//        loginPage.btn_cancel_error.click();
//        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
//    }
//
//    @Test()
//    public void loginUnsuccessfullyWithWrongPassword(){
//        loginPage.action_Login("standard","secret_sauce123");
//        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
//        loginPage.btn_cancel_error.click();
//        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
//    }
}
