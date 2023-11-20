package utils;

import com.sun.jdi.event.ExceptionEvent;
import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Common {
        public void action_select_dropdown(String option, WebElement filterElement) throws Exception{
        try{
                Select select_filter_box = new Select(filterElement);
                select_filter_box.selectByValue(option);
        }catch(Exception e){
                System.out.println("WebDriver couldn’t locate the element");
        }
        }
}
