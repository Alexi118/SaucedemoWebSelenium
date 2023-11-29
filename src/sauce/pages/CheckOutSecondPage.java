package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckOutSecondPage extends BasePage{
    public CheckOutSecondPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".inventory_item_name")
    public List<WebElement> allItemsName;
    @FindBy(css = ".inventory_item_price")
    public List<WebElement> allItemsPrice;
    @FindBy(css = ".summary_subtotal_label")
    public WebElement itemTotalbeforeTax;
    @FindBy(css = ".summary_tax_label")
    public WebElement tax;
    @FindBy(css = "div[class='summary_info_label summary_total_label']")
    public WebElement itemTotalafterTax;
    @FindBy(css = "#finish")
    public WebElement finish_Btn;
    @FindBy(css = "#cancel")
    public WebElement cancel_Btn;
}
