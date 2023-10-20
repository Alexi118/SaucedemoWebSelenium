package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(className = "shopping_cart_link")
    public WebElement icon_Cart;
    @FindBy(className = "add-to-cart-sauce-labs-backpack")
    public WebElement btn_addToCart_Backpack;

    @FindBy(className = "add-to-cart-sauce-labs-bike-light")
    public WebElement btn_addToCart_BikeLight;
}
