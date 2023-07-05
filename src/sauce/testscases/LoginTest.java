package testscases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test()
    public void loginSuccessfullyWithStandardUser(){
        loginPage.action_Login("standard_user","secret_sauce");
        normalWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app_logo")));
    }
}
