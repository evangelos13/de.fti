package de.fti.tests;

import de.fti.framework.LocalDriverManager;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public WebDriver getDriver() {
        return LocalDriverManager.getDriver();
    }

}

