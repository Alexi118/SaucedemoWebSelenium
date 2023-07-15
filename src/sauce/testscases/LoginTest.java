package testscases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test()
    public void loginSuccessfullyWithStandardUser(){
        loginPage.action_Login("standard_user","secret_sauce");
        normalWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app_logo")));
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
