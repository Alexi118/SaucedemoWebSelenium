package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
            super(driver);
    }
    //burger-menu
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerBtn;
    @FindBy(className = "bm-item-list")
    public WebElement burgerBtn_ItemList;
    @FindBy(css =".app_logo")
    public WebElement banner_AppLogo;
    @FindBy(css =".product_sort_container")
    public WebElement filter_box;
    @FindBy(css =".active_option")
    public WebElement active_option_filter_box;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement all_items_Btn;
    @FindBy(id = "about_sidebar_link")
    public WebElement about_Btn;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logOut_Btn;
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState_Btn;

    //inventory
    @FindBy(css = ".inventory_item:nth-child(1) button")
    public WebElement addRemove1stItemOnHomepage_Btn;
    @FindBy(css = ".inventory_item:nth-child(2) button")
    public WebElement addRemove2ndItemOnHomepage_Btn;
    @FindBy(css = ".inventory_item:nth-child(3) button")
    public WebElement addRemove3rdItemOnHomepage_Btn;
    @FindBy(css = ".inventory_item:nth-child(4) button")
    public WebElement addRemove4thItemOnHomepage_Btn;
    @FindBy(css = ".inventory_item_name")
    public List<WebElement> allInventoryItemsNames;
    @FindBy(css = ".inventory_item_price")
    public List<WebElement> priceForEachInventoryItems;
    //cart
    @FindBy(css = ".shopping_cart_badge")
    public WebElement cartBadgeCount;

    //footer
    @FindBy(css = ".social_twitter")
    public WebElement twitter_icon;
    @FindBy(css = ".social_facebook")
    public WebElement facebook_icon;
    @FindBy(css = ".social_linkedin")
    public WebElement linkedin_icon;
    @FindBy(css = ".footer_copy")
    public WebElement footer_text;
}
