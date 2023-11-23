package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import pages.BasePage;
import utils.Constants;

public class Common extends BasePage{
        public Common(WebDriver driver){
                super(driver);
        }
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Short));
        WebDriverWait normalWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Normal));
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Long));

        //Display&visible assert
        public boolean isDisplayed(WebElement element) {
                try {
                        return element.isDisplayed();
                } catch (NoSuchElementException e) {
                        return false;
                }
        }

        public boolean isEnabled(WebElement element) {
                try {
                        return element.isEnabled();
                } catch (NoSuchElementException e) {
                        return false;
                }
        }

        //Wait Conditions
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

        //Interact action on Web
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
        public void action_switchToAnother_Tab(){
                try{
                        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
                        driver.switchTo().window(browserTabs.get(1));
                }catch(NoSuchFrameException e){
                        System.out.println("WebDriver couldn’t find the Window to switch!");
                }
        }
        public void action_switchBackToBaseURL_Tab(){
                try{
                        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
                        driver.close();
                        driver.switchTo().window(browserTabs.get(0));
                }catch(NoSuchFrameException e){
                        System.out.println("WebDriver couldn’t find the Window to switch!");
                }
        }
}