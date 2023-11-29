package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#first-name")
    public WebElement firstName_txtBox;
    @FindBy(css = "#last-name")
    public WebElement lastName_txtBox;
    @FindBy(css = "#postal-code")
    public WebElement postalCode_txtBox;
    @FindBy(css = "#continue")
    public WebElement continue_Btn;

    public void action_fillInCorrectICheckOutInfo(){
        firstName_txtBox.sendKeys("Nguyen Duc");
        lastName_txtBox.sendKeys("Cuong");
        postalCode_txtBox.sendKeys("123 - Cau Giay - Ha Noi");
    }
}
