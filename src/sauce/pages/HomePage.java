package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Common;

public class HomePage extends BasePage {
    Common common = new Common();
    public HomePage(WebDriver driver){
            super(driver);
    }
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerBtn;
    @FindBy(className = "bm-item-list")
    public WebElement burgerBtn_ItemList;
    @FindBy(how = How.CSS, using =".app_logo")
    public WebElement banner_AppLogo;
    @FindBy(how = How.CSS, using =".product_sort_container")
    public WebElement filter_box;

    public void action_select_dropdown_filter_box(String dropdownOption){
        common.action_select_dropdown(dropdownOption,filter_box);
    };
}
