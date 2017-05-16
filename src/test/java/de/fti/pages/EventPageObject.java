package de.fti.pages;

import de.fti.framework.Constants;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class EventPageObject extends BasePage{

    public  EventPageObject goToBookingPage() {
        btnBooking.click();
        return PageFactory.initElements(getDriver(), EventPageObject.class);
    }

    // Get "weiter zur buchung" button.
    @FindBy(xpath = ".//a[@class = 'btn btn-default btn-block btn-booking']")
    public WebElement btnBooking;

    @FindBy(css = ".offerHeadHotelName")
    public WebElement lblHotelName ;

    @FindBys({@FindBy(xpath = ".//div[@class = 'list-col offer-price col-sm-3']/span")})
    public List<WebElement> lstOtherPrices;


    public String getHotelName () {
        return  lblHotelName.getText();
    }

    public  boolean isOtherPricesDisplayed() {
        boolean status = true;
        for (WebElement element : lstOtherPrices){
            if(!WebDriverUtils.getElementWhenVisible(getDriver(), element, Constants.SHORT_TIMEOUT).isDisplayed()){
                status = false;
            }
        }
        return status;
    }

    public boolean isBookingButtonDisplayed() {

            return WebDriverUtils.getElementWhenVisible(getDriver(), btnBooking, Constants.TIMEOUT).isDisplayed();
    }

    public boolean hasBookingButtonCorrectName() {

        return WebDriverUtils.getElementWhenVisible(getDriver(), btnBooking, Constants.TIMEOUT).getText().contains("weiter zur Buchung");
    }


    @Override
    public By getPageLoadedLocator() {
        return By.cssSelector(".offerHeadHotelName");
    }

}



