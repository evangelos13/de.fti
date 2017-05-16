package de.fti.tests;

//import org.apache.log4j.Logger;

import de.fti.pages.FTIHomePageObject;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class QuickSearchButtonsTest extends BaseTest {

    @Test
    public void validateAllButtonsExist() {

        FTIHomePageObject home = PageFactory.initElements(getDriver(),  FTIHomePageObject.class);
        home.openHomePage();
        WebDriverUtils.closePopUpOnHomePage(getDriver());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(home.isbtnEarlyBookingDisplayed(), "Early Booking button is not displayed");
        Assert.assertTrue(home.isbtnRateDisplayed(), "Fruhbucher should exist");
        Assert.assertTrue(home.isbtnLastMinuteDisplayed(), "Pauschal button should exist");
        Assert.assertTrue(home.isbtnFlightDisplayed(), "Last Minute button should exist");
        Assert.assertTrue(home.isbtnHotelDisplayed(), "Flug button should exist");
        Assert.assertTrue(home.isbtnbtnCamperDisplayed(), "Hotel button should exist");
        Assert.assertTrue(home.isbtnCarRentDisplayed(), "Camper button should exist");
        Assert.assertTrue(home.isbtnFlightHeaderDisplayed(), "Flight Header button should exist");
        Assert.assertTrue(home.isbtnCarRentHeaderDisplayed(), "Car Rent header button should exist");
        Assert.assertTrue(home.isSearchButtonDisplayed(), "Search button should exist");
    }

    @Test
    public void validateListDropDownHeader(){
        FTIHomePageObject home = PageFactory.initElements(getDriver(),  FTIHomePageObject.class);
        Assert.assertTrue(home.islistDropDownDisplayed(), "Missing option for the List drop dropdown");
    }



}


