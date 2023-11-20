package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Common {
        public void action_select_dropdown(String option, WebElement filterElement) throws Exception{
        try{
                Select select_filter_box = new Select(filterElement);
                select_filter_box.selectByValue(option);
        }catch(NoSuchElementException e){
                System.out.println("WebDriver couldn’t locate the element");
        }
        }
}
