package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = ".shopping_cart_link")
    public WebElement cartIcon_Link;
    @FindBy(css = ".shopping_cart_badge")
    public WebElement cartBadgeCount;
    @FindBy(css = ".inventory_item_name")
    public List<WebElement> allIventoryItemsName;
    @FindBy(css = "#continue-shopping")
    public WebElement continueShopping_Btn;
    @FindBy(css = "#checkout")
    public WebElement checkOut_Btn;
}
