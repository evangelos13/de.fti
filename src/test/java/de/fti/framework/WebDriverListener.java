package de.fti.framework;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener{
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browser = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            WebDriver driver = LocalDriverFactory.createInstance(browser);
            LocalDriverManager.setWebDriver(driver);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = LocalDriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }

    }
}
