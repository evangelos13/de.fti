package de.fti.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.function.Function;


public class WebDriverUtils {

    private WebDriverUtils(){
    }

    public static boolean isElementPresent(WebDriver driver, final By Locator) {
        boolean status = true;
        try {
            driver.findElement(Locator);

        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    // WE will use this function for all the tests
    public static WebElement getElementWhenVisible(WebDriver driver, final WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
    }

    public static void closePopUpOnHomePage(WebDriver driver){
        WebElement popUp = driver.findElement(By.id("cboxClose"));
        popUp.click();
    }
}



