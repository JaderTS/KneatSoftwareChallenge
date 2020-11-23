package com.steps;

import com.DriverFactory;
import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;


public class MainPageSteps extends TestEnvironment {

    private final MainPage mainPage = new MainPage().get();
    private final TestCommons testCommons = new TestCommons();

    @Step("I open home page")
    @Given("I open home page")
    public void iOpenHomePage() throws Throwable {
        final String expectedPageURL = "https://www.booking.com/";

        DriverFactory.getDriver().get(HOME_URL);

        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), expectedPageURL);
    }

    @Step("I can see booking.com website")
    @Given("I can see booking.com website")
    public void iCanSeeBookingComWebsite() throws Throwable {
        final boolean isPageReadyToExecuteTests;

        isPageReadyToExecuteTests = TestCommons.isPageReady();
        logger.info(String.format("Page ready: \"%S\"", isPageReadyToExecuteTests));

        Assert.assertTrue(isPageReadyToExecuteTests, ContextInjection.PHASE);
    }

    @Step("I click booking logo")
    @When("I click booking logo")
    public void iClickBookingLogo() throws Throwable {
        testCommons.waitForElementToBeVisible(mainPage.bookingLogo);
        testCommons.customClick(mainPage.bookingLogo);

        logger.info(String.format("I click booking logo"));

        Assert.assertEquals("Find deals on hotels, homes, and much more...",
                mainPage.phase.getText());
    }

    @Step("I enter destination *{0}*")
    @When("I enter destination {string}")
    public void iEnterAddress(String myLocation) throws Throwable {
        testCommons.waitForElementToBeVisible(mainPage.destination);
        testCommons.customSendKeys(mainPage.destination, myLocation);

        logger.info(String.format("I enter destination"));

        Assert.assertEquals("Find deals on hotels, homes, and much more...",
                mainPage.phase.getText());
    }

    @Step("I click check date")
    @And("I click check date")
    public void iClickCheckDate() throws Throwable {
        testCommons.waitForElementToBeVisible(mainPage.checkDate);
        testCommons.customClick(mainPage.checkDate);

        logger.info(String.format("I click check date"));

        Assert.assertEquals("Find deals on hotels, homes, and much more...",
                mainPage.phase.getText());    }

    @Step("I click next month")
    @And("I click next month")
    public void iClickNextMonth() throws Throwable {
        testCommons.waitForElementToBeVisible(mainPage.nextMonth);
        testCommons.customClick(mainPage.nextMonth);

        logger.info(String.format("I click next month"));

        Assert.assertEquals("Find deals on hotels, homes, and much more...",
                mainPage.phase.getText());    }

    @Step("I choose three months from today date check in")
    @And("I choose three months from today date check in")
    public void iChooseThreeMonthsFromTodayDateCheckIn() throws Throwable {
        testCommons.waitForElementToBeVisible(mainPage.checkInDate);
        testCommons.customClick(mainPage.checkInDate);

        logger.info(String.format("I choose three months from today date check in"));

        Assert.assertEquals("Find deals on hotels, homes, and much more...",
                mainPage.phase.getText());    }

    @Step("I choose three months from today date check out")
    @And("I choose three months from today date check out")
    public void iChooseThreeMonthsFromTodayDateCheckOut() throws Throwable {
        testCommons.waitForElementToBeVisible(mainPage.checkOutDate);
        testCommons.customClick(mainPage.checkOutDate);

        logger.info(String.format("I choose three months from today date check out"));

        Assert.assertEquals("Find deals on hotels, homes, and much more...",
                mainPage.phase.getText());    }

    @Step("I click search")
    @When("I click search")
    public void iClickSearch() throws Throwable {
        testCommons.customClick(mainPage.search);
    }
}