package de.fti.pages;

import de.fti.framework.Constants;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPageObject extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Ihre Reiseplanung')]")
    public WebElement headerHotel;

    @FindBy(xpath = "//*[contains(text(), 'Persönliche Daten')]")
    public WebElement headerPersonalData;

    @FindBy(xpath = "//*[contains(text(), 'Zahlungsdaten')]")
    public WebElement headerPayment;

    @FindBy(css = ".book.btn.btn-block.btn-default")
    public WebElement btnFinishBooking;

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//*[contains(text(), 'Ihre Reiseplanung')]");
    }

    public boolean isheaderHotelDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), headerHotel, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isheaderPersonalDataDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), headerPersonalData, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isheaderPaymentDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), headerPayment, Constants.SHORT_TIMEOUT).isDisplayed();
    }

    public boolean isbtnFinishBookingDisplayed() {
        return WebDriverUtils.getElementWhenVisible(getDriver(), btnFinishBooking, Constants.SHORT_TIMEOUT).isDisplayed();
    }

}
