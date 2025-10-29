package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@UtilityClass
public class PageUtils {

    public void clearAndType(WebElement textbox, String text) {
        textbox.clear();
        textbox.sendKeys(text);
    }

    public void scrollAndClick(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
