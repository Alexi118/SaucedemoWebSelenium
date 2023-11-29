package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryItemPage extends BasePage {
    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".inventory_details_name")
    public WebElement item_Name;
    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory']")
    public WebElement itemAdd_Btn;
    @FindBy(css = "button[class='btn btn_secondary btn_small btn_inventory']")
    public WebElement itemRemove_Btn;
    //#back-to-products
    @FindBy(css = "#back-to-products")
    public WebElement backToProducts_Btn;
}
