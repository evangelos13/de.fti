package de.fti.pages;

import de.fti.framework.Constants;
import de.fti.tests.EventPageTest;
import de.fti.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DestinationPageObject extends BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(DestinationPageObject.class);

    private By tblFavouriteRegionsBy = By.className("ttRegionGroup");
    private By lstButtonsInfoBy = By.xpath("//i[contains(@class , 'ttRegionGroupSingleRegionIcon')]");
    private By listBtnPricesInFavouriteTableBy = By.cssSelector(".ttRegionGroupSingleRegionPrice");
    private By btnPriceInFavouriteTableBy = By.xpath(".//*[@id='TTIBE']/div/div[2]/div[2]/div[4]/section/div[2]/div[5]/div[1]/div[3]/div[1]/div/div/div[6]/div/a/span");
    private By lstOutsiteTemperaturesBy = By.xpath("ttRegionGroup");
    private By tblInfoContentBy = By.className("csbContainer");
    private By tabDestinationBy = By.xpath(".//ul[contains(@class, 'nav-pills')]/li[contains(@class, 'active')][2]");
    private By lstTeasersBy = By.xpath(".//div[@class = 'product-name']");
    private By lstPricesForTeasersBy = By.xpath(".//div[@class = 'product-price']");
    private By headerChoosingDestinationBy = By.xpath(".//div[contains(@class, 'ttRegionListHead')]/div[1]");

    // Lieblings regionen unserer kunden table
    @FindBy(className = "ttRegionGroup")
    public WebElement tblFavouriteRegions;

    @FindBy(xpath = ".//*[@id='recommender-container']/h2")
    public WebElement headerTopHotels;

    @FindBys({
            @FindBy(xpath = "//i[contains(@class , 'ttRegionGroupSingleRegionIcon')]")
    })
    public List<WebElement>  listBtnInfo;

    @FindBys({
            @FindBy(css = ".ttRegionGroupSingleRegionPrice")
    })
    public List<WebElement>  listBtnPricesInFavouriteTable;

    @FindBy(xpath = ".//*[@id='TTIBE']/div/div[2]/div[2]/div[4]/section/div[2]/div[5]/div[1]/div[3]/div[1]/div/div/div[6]/div/a/span")
    public WebElement btnPriceInFavouriteTable;

    @FindBys({
            @FindBy(className = "ttRegionGroup")
    })
    public List<WebElement>  lstOutsiteTemperatures;

    @FindBys({
            @FindBy(className = "csbContainer")
    })
    public List<WebElement>  tblInfoContent;

    @FindBy(xpath = " .//ul[contains(@class, 'nav-pills')]/li[contains(@class, 'active')][2]")
    public WebElement tabDestination;

    @FindBys({
            @FindBy(css = ".content")
    })
    public List<WebElement> lstTeasers;

    @FindBys({
            @FindBy(css = ".product-price")
    })
    public List<WebElement>   lstPricesForTeasers;

    // Wählen Sie Ihr gewünschtes Reiseziel header.
    @FindBy(xpath = ".//div[contains(@class, 'ttRegionListHead')]/div[1]")
    public WebElement headerChoosingDestination;

    public HotelPageObject goToHotelsPage() {
        btnPriceInFavouriteTable.click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return PageFactory.initElements(getDriver(), HotelPageObject.class);
    }


    // Click on first price in table.
    public void clickOnFirstPriceInFavouriteTable(){
        btnPriceInFavouriteTable.click();
    }

    // If list of all prices in table exists.
    public boolean isListOfAllPricesDisplayed() {
        boolean status = true;
        for (WebElement element : listBtnPricesInFavouriteTable){
            if(!WebDriverUtils.getElementWhenVisible(getDriver(), element, Constants.SHORT_TIMEOUT).isDisplayed()){
                status = false;
            }
        }
        return status;
    }

    // If list of all temperatures in table exists.
    public boolean isListOfAllTemperaturesDisplayed() {
        boolean status = true;
        for (WebElement element : lstOutsiteTemperatures){
            if(!WebDriverUtils.getElementWhenVisible(getDriver(), element, Constants.SHORT_TIMEOUT).isDisplayed()){
                status = false;
            }
        }
        return status;
    }

    // If list of all info buttons in table displayed.
    public boolean isListOfBtnInfoDisplayed() {
        boolean status = true;
        for (WebElement element : listBtnInfo){
            if(!WebDriverUtils.getElementWhenVisible(getDriver(), element, Constants.SHORT_TIMEOUT).isDisplayed()){
                status = false;
            }
        }
        return status;
    }

    public boolean isTblInfoContentDisplayed() {
        WebElement element = WebDriverUtils.getElementWhenVisible(getDriver(), tblInfoContent.get(0), Constants.SHORT_TIMEOUT);
        return element.isDisplayed();
    }

    public void clickOnBtnInfo() {
        listBtnInfo.get(0).click();
    }

    // Return headline.
    public String getTextHeaderChoosingDestination() {
        return headerChoosingDestination.getText();
    }

    public String getTextHeaderTopHotels() {
        return headerTopHotels.getText();
    }

    public boolean isTabDestinationTextCorrect(){
        WebElement title = WebDriverUtils.getElementWhenVisible(getDriver(), tabDestination, Constants.SHORT_TIMEOUT);
        return title.getAttribute("title").contains("Reiseziel");
    }


    public boolean isListOfTeasersDisplayed(){
        boolean status = true;
        for (WebElement element : lstTeasers){
            if(!WebDriverUtils.getElementWhenVisible(getDriver(), element, Constants.SHORT_TIMEOUT).isDisplayed()){
                status = false;
            }
            LOG.info("index");
        }
        return status;
    }

    // Check if list of prices for teaser displayed.
    public boolean isListOfPricesForTeasersDisplayed() {
        boolean status = true;
        for (WebElement element : lstPricesForTeasers){
            if(!WebDriverUtils.getElementWhenVisible(getDriver(), element, Constants.SHORT_TIMEOUT).isDisplayed()){
                status = false;
            }
        }
        return status;
    }

    public boolean isTextHeaderChoosingDestinationCorrect(){
        return getTextHeaderChoosingDestination().contains("Wählen Sie Ihr gewünschtes Reiseziel");
    }

    public boolean isTextHeaderTopHotelsDisplayed(){
        return headerTopHotels.isDisplayed();
    }

    @Override
    public By getPageLoadedLocator() {
        return By.cssSelector(".ttRegionListHead.hidden-xs.col-sm-12.col-md-8.col-lg-8>div");
    }


}
