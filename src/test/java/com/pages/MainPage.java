package com.pages;

import com.buildSettings.TestEnvironment;
import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainPage extends BasePage<MainPage> {

    @FindBy(how = How.ID, using = "logo_no_globe_new_logo")
    public WebElement bookingLogo;

    @FindBy(how = How.CLASS_NAME, using = "sb-searchbox__title-text")
    public WebElement phase;

    @FindBy(how = How.ID, using = "ss")
    public WebElement destination;

    @FindBy(how = How.XPATH, using = ".//div[@class='bui-calendar__control bui-calendar__control--next']")
    public WebElement nextMonth;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'sb-searchbox__input sb-date-field__field')]")
    public WebElement checkDate;

    @FindBy(how = How.XPATH, using = ".//div[@class='bui-calendar__wrapper']//table[@class='bui-calendar__dates']/tbody[1]/tr[contains(@class,'bui-calendar__row')]/td[contains(@data-date,'2021-02-20')]")
    public WebElement checkInDate;

    @FindBy(how = How.XPATH, using = ".//div[@class='bui-calendar__wrapper']//table[@class='bui-calendar__dates']/tbody[1]/tr[contains(@class,'bui-calendar__row')]/td[contains(@data-date,'2021-02-21')]")
    public WebElement checkOutDate;

    @FindBy(how = How.XPATH, using = "//div[@class='sb-searchbox-submit-col -submit-button ']//button[@type='submit']")
    public WebElement search;

    public MainPage() {
        super(TestEnvironment.HOME_URL);
    }
}