package de.fti.pages;

import de.fti.framework.LocalDriverManager;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.NoSuchElementException;


public abstract class BasePage {

    public abstract By getPageLoadedLocator();

    public WebDriver getDriver() {
        return LocalDriverManager.getDriver();
    }


    public final boolean isLoaded() {
        return WebDriverUtils.isElementPresent(getDriver(), this.getPageLoadedLocator());
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

}
