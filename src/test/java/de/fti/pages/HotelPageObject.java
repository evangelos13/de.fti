package de.fti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HotelPageObject extends BasePage {

    @FindBys({
            @FindBy(css = ".row.ttHotelProdukt")
    })
    public List<WebElement> lstHotelItems;

    @FindBys({
            @FindBy(css = ".tt.hotel.image")
    })
    public List<WebElement> lstHotelImages;

    @FindBys({
            @FindBy(css = ".icon-info27")
    })
    public List<WebElement> lstHotelInfoButtons;

    @FindBys({
            @FindBy(css = ".btn.btn-default.btn-block.btn-price")
    })
    public List<WebElement> lstHotelPrices;


   //Return list of hotel names
    @FindBys({
            @FindBy(css = ".hidden-xs.col-sm-9")
    })
    public List<WebElement> lstHotelNames;

    // Method to navigate and to initialize the element of the next page: Event page
    public EventPageObject goToEventPage() {
        lstHotelPrices.get(0).click();
        return PageFactory.initElements(getDriver(), EventPageObject.class);
    }


    // Get name of the first hotel
    public  String getFirstHotelName(){
        return lstHotelNames.get(0).getText();
    }

    //Page Locator
    @Override
    public By getPageLoadedLocator() {
        return By.cssSelector(".row.ttHotelFilterHead");
    }

    //Validate that every hotel has an image
    public boolean EveryHotelHasAnImage() {

        return lstHotelItems.size() == lstHotelImages.size();
    }

    //Validate that every hotel has a price
    public boolean EveryHotelHasAPrice() {
        return lstHotelItems.size() == lstHotelPrices.size();
    }

    //Validate that every hotel has an Info button
    public boolean EveryHotelHasAnInfoButton() {

        return lstHotelItems.size() == lstHotelInfoButtons.size();
    }
}


