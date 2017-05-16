package de.fti.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LocalDriverFactory {

    private  static final Logger LOG = LoggerFactory.getLogger(LocalDriverFactory.class);

    static WebDriver createInstance(String browser) {
        WebDriver driver = null;
        if (browser.toLowerCase().contains("firefox")) {
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, Constants.FIREFOX_DRIVER_WINDOWS_PATH);
            driver = new FirefoxDriver();
            LOG.info("Firefox driver instance was created! Thread id- ");
            return driver;
        }
        if (browser.toLowerCase().contains("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, Constants.CHROME_DRIVER_WINDOWS_PATH);
            driver = new ChromeDriver();
            return driver;
        }
        return driver;
    }
}
