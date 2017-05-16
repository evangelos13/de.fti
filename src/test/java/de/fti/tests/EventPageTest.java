package de.fti.tests;

import de.fti.pages.DestinationPageObject;
import de.fti.pages.EventPageObject;
import de.fti.pages.FTIHomePageObject;
import de.fti.pages.HotelPageObject;
import de.fti.utils.WebDriverUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class EventPageTest  extends BaseTest{

    private static final Logger LOG = LoggerFactory.getLogger(EventPageTest.class);

    private String hotelNameNotMatchmessage = "The Hotel clicked doesn't match to the Hotel on Termin page.";
    private String btnBookingNotDisplayedMessage = "Yhe booking button is not displayed.";
    private String buchungButtonIncorrectNameMessage = "The button has incorrect name.";
    private String otherPricesNotDisplayedMessage = "Other prices are not displayed on Termin page.";

    // Validate if the hotel is the one selected in the hotel page. TODO: need to chabge according to hotel page object class
    @Test
    public void test1ValidateHotelIsTheSameAsSelected()  {

        FTIHomePageObject homePage = PageFactory.initElements(getDriver(), FTIHomePageObject.class);
        homePage.openHomePage();
        WebDriverUtils.closePopUpOnHomePage(getDriver());
        homePage.clickOnSearchButton();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DestinationPageObject destpage = PageFactory.initElements(getDriver(), DestinationPageObject.class);
        destpage.goToHotelsPage();

        HotelPageObject hotelPage = PageFactory.initElements(getDriver(), HotelPageObject.class);
        String firstHotelNameOnHotelPage = hotelPage.getFirstHotelName();
        LOG.info("First:"+firstHotelNameOnHotelPage);
        hotelPage.goToEventPage();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        EventPageObject eventPage = PageFactory.initElements(getDriver(), EventPageObject.class);
        LOG.info("Second:"+eventPage.getHotelName());

        Assert.assertTrue( hotelNameNotMatchmessage,
                eventPage.getHotelName().equals(firstHotelNameOnHotelPage));
    }

    // Validate if the button "weiter zur Buchung" exist.
    @Test
    public void test2ValidateBookingButton()  {
        EventPageObject eventPage = PageFactory.initElements(getDriver(), EventPageObject.class);
        Assert.assertTrue(btnBookingNotDisplayedMessage,
               eventPage.isBookingButtonDisplayed());
        Assert.assertTrue(buchungButtonIncorrectNameMessage,
                eventPage.hasBookingButtonCorrectName());
    }

    // Validate if the prices are appearing for another options.
    @Test
    public void test3ValidateOtherPrices() {
        EventPageObject eventPage = PageFactory.initElements(getDriver(), EventPageObject.class);
        Assert.assertTrue(otherPricesNotDisplayedMessage,
                eventPage.isOtherPricesDisplayed());
    }
}