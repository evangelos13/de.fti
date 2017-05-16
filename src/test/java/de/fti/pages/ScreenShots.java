package de.fti.pages;

import de.fti.framework.LocalDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;


public class ScreenShots extends TestListenerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(ScreenShots.class);

    private String fileSeperator = System.getProperty("file.separator");

    public WebDriver getDriver() {
        return LocalDriverManager.getDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("***** Error " + result.getName() + " test has failed *****");

        String testClassName = getTestClassName(result.getInstanceName()).trim();

        String testMethodName = result.getName().toString().trim();
        String screenShotName = testMethodName + ".png";


        if (getDriver() != null) {
            String imagePath = ".." + fileSeperator + "Screenshots"
                    + fileSeperator + "Results" + fileSeperator + testClassName
                    + fileSeperator
                    + takeScreenShot(getDriver(), screenShotName, testClassName);
            LOG.info("Screenshot can be found : " + imagePath);
        }
    }

    public String getTestClassName(String testName) {
        String[] reqTestClassname = testName.split("\\.");
        int i = reqTestClassname.length - 1;
        LOG.info("Required Test Name : " + reqTestClassname[i]);
        return reqTestClassname[i];
    }

    public String takeScreenShot(WebDriver driver, String screenShotName, String testName) {

        try {
            File file = new File("Screenshots" + fileSeperator + "Results");
            if (!file.exists()) {
                LOG.info("File created " + file);
                file.mkdir();
            }

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("Screenshots" + fileSeperator + "Results" + fileSeperator + testName, screenShotName);
            FileUtils.copyFile(screenshotFile, targetFile);

            return screenShotName;
        } catch (Exception e) {
            LOG.info("An exception occured while taking screenshot " + e.getCause());
            return null;
        }
    }
}