package testscases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test()
    public void loginSuccessfullyWithStandardUser(){
        loginPage.action_LoginWithCorrectUser();
        normalWait.until(ExpectedConditions.visibilityOf(homePage.banner_AppLogo));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html" );
    }

    @Test()
    public void loginUnsuccessfullyWithEmptyUser(){
        loginPage.action_Login("","secret_sauce");
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username is required");
        loginPage.btn_cancel_error.click();
        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
    }

    @Test()
    public void loginUnsuccessfullyWithEmptyPassword(){
        loginPage.action_Login("standard_user","");
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Password is required");
        loginPage.btn_cancel_error.click();
        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
    }

    @Test()
    public void loginUnsuccessfullyWithWrongUser(){
        loginPage.action_Login("standard","secret_sauce");
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
        loginPage.btn_cancel_error.click();
        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
    }

    @Test()
    public void loginUnsuccessfullyWithWrongPassword(){
        loginPage.action_Login("standard","secret_sauce123");
        Assert.assertEquals(loginPage.box_error.getText(),"Epic sadface: Username and password do not match any user in this service");
        loginPage.btn_cancel_error.click();
        normalWait.until(ExpectedConditions.invisibilityOf(loginPage.box_error));
    }
}
