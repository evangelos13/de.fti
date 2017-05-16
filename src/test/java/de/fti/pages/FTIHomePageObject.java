package de.fti.pages;

import de.fti.framework.Constants;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class FTIHomePageObject extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.fti.de/";
    //Elements of the FTI Home page
    @FindBy(xpath = "//a[@href='#ftiquicksearchtabearlybooking']/span")
    public WebElement btnEarlyBooking;

    @FindBy(xpath = "//a[@href='#ftiquicksearchtabpackagetour']/span")
    public WebElement btnRate;

    @FindBy(xpath = "//a[@href='#ftiquicksearchtablastminute']/span")
    public WebElement btnLastMinute;

    @FindBy(xpath = "//a[@href='/fluege.html']/span")
    public WebElement btnFlight;

    @FindBy(xpath = "//a[@href='#ftiquicksearchtabhotel']/span")
    public WebElement btnHotel;

    @FindBy(xpath = "//a[@href='#ftiquicksearchtabcamper']/span")
    public WebElement btnCamper;

    @FindBy(xpath = "//a[@href='#ftiquicksearchtabdrive']/span")
    public WebElement btnCarRent;

    @FindBy(xpath = ".//*[@id='ftiquicksearchtabpackagetour']/form[1]/div[2]/div[2]/button")
    public WebElement btnSearch;

    @FindBy(xpath = "//*[@class='dropdown-toggle']")
    public List<WebElement> tglHeader;

    @FindBy(css = "#navbar-16508>a")
    public WebElement btnFlightHeader;

    @FindBy(css = "#navbar-16509>a")
    public WebElement btnCarRentHeader;

    @FindBy(css = ".big_footer_menu.hidden-xs.hidden-sm.hidden-md")
    public WebElement menuFooter;

    @FindBy(xpath = "//*[@id='cboxOverlay']")
    public WebElement overLay;

    @FindBy(id = "cboxClose")
    public WebElement popUp;


    //Lists of Elements of FTI Home Page
    @FindBys({
            @FindBy(css = ".dropdown-toggle")
    })
    public List<WebElement>  listDropDown;

    public void openHomePage() {
        getDriver().get(HOME_PAGE_URL);
    }

//    //Method to navigate and to initialize the element of the next page: Destination page
    public DestinationPageObject goToDestinationPage() {
       btnSearch.click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       return PageFactory.initElements(getDriver(), DestinationPageObject.class);
    }


    //Methods to check that the display of Elements in the FTI home page
    public boolean isbtnEarlyBookingDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnEarlyBooking, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnRateDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnRate, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnLastMinuteDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnLastMinute, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnFlightDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnFlight, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnHotelDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnHotel, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnbtnCamperDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnCamper, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnCarRentDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnCarRent, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    //--------------------------------------------------------------------------------------------------


    public boolean isbtnFlightHeaderDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnFlightHeader, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnCarRentHeaderDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnCarRentHeader, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isSearchButtonDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnSearch, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    //--------------------------------------------------------------------------------------------------

    public boolean islistDropDownDisplayed(){
        boolean status = true;
        for (WebElement element : listDropDown){
            if(!WebDriverUtils.getElementWhenVisible(getDriver(), element, Constants.SHORT_TIMEOUT).isDisplayed()){
                status = false;
            }
        }
        return status;
    }


    public void clickOnSearchButton() {

        WebElement btn1 = getDriver().findElement(By.
                xpath(".//*[@id='ftiquicksearchtabpackagetour']/form[1]/div[2]/div[2]/button"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", btn1);
      //  btnSearch.click();
    }


    public Select getDrpReiseziel(WebDriver driver) {
        Select drpReiseziel = new Select(driver.findElement(By.id("zielpackagetour2")));
        return drpReiseziel;
    }

    public Select getDrpReiseregion(WebDriver driver) {
        Select drpReiseregion = new Select(driver.findElement(By.id("regionpackagetour2")));
        return drpReiseregion;
    }

    /**
     * Wait for the overlay  element to become invisible - Needed when the user wants to click on any of the elements of Search page
     * Another solution to click on any of the webelements of the Home page is to use Javascript executor as in: clickOnSearchButton
     *
     */

    public void waitForOverlayNotVisible(WebDriver driver, final By by) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);

        wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {

                return driver.findElement(by);

            }

        });
    }

    @Override
    public By getPageLoadedLocator() {
        return By.cssSelector(".navbar-brand.brand>img");
    }


}


