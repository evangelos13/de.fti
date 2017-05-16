package de.fti.tests;

import de.fti.pages.DestinationPageObject;
import de.fti.pages.FTIHomePageObject;
import de.fti.pages.HotelPageObject;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class HotelsPageTest  extends BaseTest {

    // Test that each hotel has an image, a price
    @Test
    private void validateEachHotelHasAnImage() {

        FTIHomePageObject homepame  = PageFactory.initElements(getDriver(),  FTIHomePageObject.class);
        homepame.openHomePage();
        WebDriverUtils.closePopUpOnHomePage(getDriver());
        homepame.clickOnSearchButton();

        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DestinationPageObject destinationpage = PageFactory.initElements(getDriver(),  DestinationPageObject.class);
        destinationpage.listBtnPricesInFavouriteTable.get(1).click();

        HotelPageObject hotelpage = PageFactory.initElements(getDriver(),  HotelPageObject.class);

        Assert.assertTrue(hotelpage.EveryHotelHasAnImage(), "Hotel Image is missing");
        Assert.assertTrue(hotelpage.EveryHotelHasAPrice(), "Hotel price is missing");
        Assert.assertTrue(hotelpage.EveryHotelHasAnInfoButton(), "Hotel Info is missing");
    }
}



