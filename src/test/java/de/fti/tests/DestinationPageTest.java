package de.fti.tests;

import de.fti.pages.DestinationPageObject;
import de.fti.pages.FTIHomePageObject;
import de.fti.utils.WebDriverUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DestinationPageTest  extends BaseTest{

    private String notAllPricesDisplayedMessage = "Not all prices are displayed in the table content.";
    private String notAllPricesForTeasersDisplayedMessage = "Not all prices for teasers are displayed in the table content.";
    private String NotAllTemperaturesDisplyedMessage  = "Not all temperatures are displayed in the table content.";
    private String NotallTeasersDisplayedMessage = "Not all teasers are displayed.";
    private String tabDestinationISNotCorrectMessage = "The body title: 2. Reiseziel is not displayed.";
    private String headerChossingDestinationIsNotCorrectMessage = "Headline is not correct. It should be: Wählen Sie Ihr gewünschtes Reiseziel ";
    private String contentForInfoButtonNotDisplayedMessage = "Issue with the Info buttons. Please check which one is not working.";
    private String infoButtonsNotDisplayedMessage = "Not all Info buttons are displayed.";


    @Test // Validate title Raiseziel is displayed.
    public  void test1ValidateDestinationTitle() {
        FTIHomePageObject homePage = PageFactory.initElements(getDriver(), FTIHomePageObject.class);
        homePage.openHomePage();
        WebDriverUtils.closePopUpOnHomePage(getDriver());
        homePage.getDrpReiseziel(getDriver()).selectByVisibleText("beliebig");
        homePage.getDrpReiseregion(getDriver()).selectByVisibleText("beliebig");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickOnSearchButton();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DestinationPageObject destPage = PageFactory.initElements(getDriver(), DestinationPageObject.class);
        boolean result = destPage.isTabDestinationTextCorrect();
        Assert.assertTrue(tabDestinationISNotCorrectMessage, result);
    }
    @Test
    //TODO: Add two more tests : check the teasers and prices for them
    public void test2ValidateTeasersAndPrices() {
        DestinationPageObject destPage = PageFactory.initElements(getDriver(), DestinationPageObject.class);
       // Assert.assertTrue("The header is not correct.", destPage.isTextHeaderTopHotelsDisplayed());
        Assert.assertTrue(NotallTeasersDisplayedMessage, destPage.isListOfTeasersDisplayed());
        Assert.assertTrue(notAllPricesForTeasersDisplayedMessage, destPage.isListOfPricesForTeasersDisplayed());
    }
    @Test
    public void test3ValidateHeader() {
        DestinationPageObject destPage = PageFactory.initElements(getDriver(), DestinationPageObject.class);

        Assert.assertTrue(headerChossingDestinationIsNotCorrectMessage,
                destPage.isTextHeaderChoosingDestinationCorrect());

    }
    @Test
    public void test4ValidateInfoButtons() {
        DestinationPageObject destPage = PageFactory.initElements(getDriver(), DestinationPageObject.class);

        Assert.assertTrue(infoButtonsNotDisplayedMessage,
                destPage.isListOfBtnInfoDisplayed());

        destPage.clickOnBtnInfo();
        Assert.assertTrue(contentForInfoButtonNotDisplayedMessage,
                destPage.isTblInfoContentDisplayed());

    }
    @Test
    public void test5ValidatePricesAndTemperatures() {
        DestinationPageObject destPage = PageFactory.initElements(getDriver(), DestinationPageObject.class);

        // Validate prices.
        Assert.assertTrue(notAllPricesDisplayedMessage,
                destPage.isListOfAllPricesDisplayed());

        // Validate temperatures.
        Assert.assertTrue(NotAllTemperaturesDisplyedMessage,
                destPage.isListOfAllTemperaturesDisplayed());
    }
}
