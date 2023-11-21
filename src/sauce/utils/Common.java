package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testscases.BaseTest;

public class Common extends BaseTest {
        public void waitForVisibilityOfElement(WebElement webElement){
                try{
                        System.out.println(normalWait);
                        normalWait.until(ExpectedConditions.visibilityOf(webElement));
                }catch (NoSuchElementException e){
                        System.out.println("The element is not visible!" + webElement);
                }
        }
        public void action_select_dropdown(String option, WebElement webElement) {
                try {
                        Select select_filter_box = new Select(webElement);
                        select_filter_box.selectByValue(option);
                } catch (NoSuchElementException e) {
                        System.out.println("WebDriver couldn’t locate the dropdown element" + webElement);
                }
        }

        public void action_clickOn_element(WebElement webElement){
                try {
                        //normalWait.until(ExpectedConditions.visibilityOf(webElement));
                        webElement.click();
                }catch (NoSuchElementException e) {
                        System.out.println("WebDriver couldn’t locate the element to click on" + webElement);
                }
        }
}