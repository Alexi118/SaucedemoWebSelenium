package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Constants;
import utils.Common;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "user-name")
    public WebElement txt_Username;

    @FindBy(id = "password")
    public WebElement txt_Password;

    @FindBy(how = How.CSS, using = "#login-button")
    public WebElement btn_Login;

    @FindBy(css =".error-message-container")
    public WebElement box_error;

    @FindBy(how = How.CSS, using =".error-button")
    public WebElement btn_cancel_error;

    public void enter_Username(String username){
        txt_Username.clear();
        txt_Username.sendKeys(username);
    }
    public void enter_Password(String password){
        txt_Password.clear();
        txt_Password.sendKeys(password);
    }
    public void clickOn_btn_Login(){
        btn_Login.click();
    }
    public void action_Login(String username,String password){
        enter_Username(username);
        enter_Password(password);
        clickOn_btn_Login();
    }

    public void action_LoginWithCorrectUser(){
        enter_Username(Constants.Admin_acc);
        enter_Password(Constants.Admin_pass);
        clickOn_btn_Login();
    }
}
