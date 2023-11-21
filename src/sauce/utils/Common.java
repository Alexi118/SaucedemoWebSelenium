package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import pages.BasePage;
import utils.Constants;

public class Common extends BasePage{
        public Common(WebDriver driver){
                super(driver);
        }
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Short));
        WebDriverWait normalWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Normal));
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Long));

        public void waitForVisibilityOfElement(WebElement webElement){
                try{
                        normalWait.until(ExpectedConditions.visibilityOf(webElement));
                }catch (NoSuchElementException e){
                        System.out.println("The element is not visible!" + webElement);
                }
        }
        public void waitForElementToBeClickable(WebElement webElement){
                try{
                        normalWait.until(ExpectedConditions.elementToBeClickable(webElement));
                }catch (NoSuchElementException e){
                        System.out.println("The element is not clickable!" + webElement);
                }
        }
        public void waitForVisibilityOfAllElements(WebElement webElement){
                try{
                        normalWait.until(ExpectedConditions.visibilityOfAllElements(webElement));
                }catch (NoSuchElementException e){
                        System.out.println("All elements are not visible!" + webElement);
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
                        webElement.click();
                }catch (NoSuchElementException e) {
                        System.out.println("WebDriver couldn’t locate the element to click on" + webElement);
                }
        }
}