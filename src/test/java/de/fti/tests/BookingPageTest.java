package de.fti.tests;

import de.fti.pages.*;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class BookingPageTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BookingPageTest.class);

    @Test
    public void navigateToTerminePage() {
        FTIHomePageObject homepame = PageFactory.initElements(getDriver(), FTIHomePageObject.class);
        homepame.openHomePage();
        WebDriverUtils.closePopUpOnHomePage(getDriver());
        homepame.clickOnSearchButton();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DestinationPageObject destinationpage = PageFactory.initElements(getDriver(), DestinationPageObject.class);
        destinationpage.listBtnPricesInFavouriteTable.get(1).click();

        HotelPageObject hotelpage = PageFactory.initElements(getDriver(), HotelPageObject.class);
        hotelpage.lstHotelPrices.get(1).click();

        LOG.info("test");

        EventPageObject eventpage = PageFactory.initElements(getDriver(), EventPageObject.class);
        LOG.info("test1");

        eventpage.btnBooking.click();

        LOG.info("test2");
        BookingPageObject bookingpage = PageFactory.initElements(getDriver(), BookingPageObject.class);


        Assert.assertTrue(bookingpage.isbtnFinishBookingDisplayed(), "Booking button should exist");

        Assert.assertTrue(bookingpage.isheaderHotelDisplayed(), "Hotel header should exist");

        Assert.assertTrue(bookingpage.isheaderPaymentDisplayed(), "Payement should exist");

        Assert.assertTrue(bookingpage.isheaderPersonalDataDisplayed(), "Personal Data should exist");
    }

}

