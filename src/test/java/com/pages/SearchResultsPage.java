package com.pages;

import com.buildSettings.TestEnvironment;
import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultsPage extends BasePage<SearchResultsPage> {

    @FindBy(how = How.ID, using = "logo_no_globe_new_logo")
    public WebElement bookingLogo;

    @FindBy(how = How.XPATH, using = "//div[@class='filteroptions']//button[@class='collapsed_partly_link collapsed_partly_more']")
    public WebElement showAllFacilities;

    @FindBy(how = How.XPATH, using = "//div[@id='filter_facilities']/div[2]/a[10]/label[1]/div[@class='bui-checkbox__label filter_item css-checkbox']")
    public WebElement spa;

    @FindBy(how = How.XPATH, using = "//div[@id='filter_class']/div[2]//a[@data-id='class-5']")
    public WebElement fiveStars;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'js-sr-hotel-link hotel_name_link')]//span[text()[normalize-space()='The Savoy Hotel']]")
    public WebElement hotelNameTheSavoyHotel;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'js-sr-hotel-link hotel_name_link')]//span[text()[normalize-space()='Dromoland Castle']]")
    public WebElement hotelDromolandCastle;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'js-sr-hotel-link hotel_name_link')]//span[text()[normalize-space()='Absolute Hotel Limerick']]")
    public WebElement hotelAbsoluteHotelLimerick;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'js-sr-hotel-link hotel_name_link')]//span")
    public WebElement checkHotelName;

    @FindBy(how = How.XPATH, using = "//a[@class='bui-button bui-button--secondary']//span[text()[normalize-space()='5 stars']]")
    public WebElement fiveStarsTag;

    @FindBy(how = How.XPATH, using = "//a[@class='bui-button bui-button--secondary']//span[text()[normalize-space()='Spa']]")
    public WebElement spaTag;

    @FindBy(how = How.XPATH, using = "//a[@class='hp-breadcrumb__item_masked_link']//div[text()[normalize-space()='Search results']]")
    public WebElement searchResults;

    public SearchResultsPage() {
        super(TestEnvironment.HOME_URL);
    }
}
