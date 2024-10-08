package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import org.openqa.selenium.interactions.Actions;

import pages.BasePage;

public class Common extends BasePage{

        public Common(WebDriver driver){
                super(driver);
        }
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Short));
        WebDriverWait normalWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Normal));
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Long));
        Actions act = new Actions(driver);
        public void doubleClick(WebElement element){
                //Actions act = new Actions(driver);
                act.doubleClick(element);
                act.build().perform();
        }

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
        public String getNumberInString(String string){
                String getNumber = string.replaceAll("[^\\d.]", "");
                return getNumber;
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
        public void waitForVisibilityOfAllElements(List<WebElement> list){
                try{
                        normalWait.until(ExpectedConditions.visibilityOfAllElements(list));
                }catch (NoSuchElementException e){
                        System.out.println("All elements are not visible!" + list);
                }
        }
        public void waitForLinkIsLoad(String link){
                try {
                        normalWait.until(ExpectedConditions.numberOfWindowsToBe(2));
                }catch (NoSuchFrameException e){
                        System.out.println("The window is not visible!" + link);
                }
        }

        //List Array handle
        public List<String> getListOfWebElementsToString(List<WebElement> list){
                        List<String> textList = new ArrayList<>();
                        for (WebElement element : list){
                                //Remove $ Symbol if String contain money currency
                                if(element.getText().contains("$")){
                                        String newStr = element.getText().replace("$","");
                                        textList.add(newStr);
                                }
                                else
                                        textList.add(element.getText());
                        }
                        return textList;
        }
        public String sumOfNumberInList(List<WebElement> list){
                getListOfWebElementsToString(list);
                List<Double> convertedDoubleList = getListOfWebElementsToString(list).stream().map(Double::parseDouble).collect(Collectors.toList());
                Double sum = convertedDoubleList.stream().mapToDouble(Double::doubleValue).sum();
                String convertedSum = Double.toString(sum);
                System.out.println(convertedSum);
                return convertedSum;
        }
        public List<String> sortListTextASC(List<WebElement> list){
                List<String> textListAfterSortedASC = getListOfWebElementsToString(list);
                Collections.sort(textListAfterSortedASC);
                return textListAfterSortedASC;
        }
        public List<String> sortListTextDESC(List<WebElement> list){
                List<String> textListAfterSortedDESC = getListOfWebElementsToString(list);
                Collections.sort(textListAfterSortedDESC, Collections.reverseOrder());
                return textListAfterSortedDESC;
        }
        public List<String> sortListNumberASC(List<WebElement> list){
                List<Double> numberListAfterSortedASC = getListOfWebElementsToString(list).stream().map(Double::parseDouble).collect(Collectors.toList());
                Collections.sort(numberListAfterSortedASC);
                List <String> convertedString = numberListAfterSortedASC.stream().map(x->String.valueOf(x)).collect(Collectors.toList());
                return convertedString;
        }

        public List<String> sortListNumberDESC(List<WebElement> list){
                List<Double> numberListAfterSortedDESC = getListOfWebElementsToString(list).stream().map(Double::parseDouble).collect(Collectors.toList());
                Collections.sort(numberListAfterSortedDESC, Collections.reverseOrder());
                List <String> convertedString = numberListAfterSortedDESC.stream().map(x->String.valueOf(x)).collect(Collectors.toList());
                return convertedString;
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
                }catch (NoSuchElementException | ElementNotInteractableException e) {
                        System.out.println("WebDriver couldn’t locate the element to click on" + webElement);
                }
        }
        public void action_switchToAnother_Tab(){
                try{
                        normalWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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

        //Excel handle

}