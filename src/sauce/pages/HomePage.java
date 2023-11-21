package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Common;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
            super(driver);
    }
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerBtn;
    @FindBy(className = "bm-item-list")
    public WebElement burgerBtn_ItemList;
    @FindBy(css =".app_logo")
    public WebElement banner_AppLogo;
    @FindBy(css =".product_sort_container")
    public WebElement filter_box;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement all_items_Btn;
    @FindBy(id = "about_sidebar_link")
    public WebElement about_Btn;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logOut_Btn;
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState_Btn;
}
