package com.steps;

import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;


public class SearchResultsPageSteps extends TestEnvironment {

    private final SearchResultsPage searchResultsPage = new SearchResultsPage().get();
    private final TestCommons testCommons = new TestCommons();

    @Step("I click show all facilities")
    @And("I click show all facilities")
    public void iClickShowAllFacilities() throws Throwable {
        testCommons.waitForElementToBeVisible(searchResultsPage.showAllFacilities);

        testCommons.customClick(searchResultsPage.showAllFacilities);

        Assert.assertEquals("Search results", searchResultsPage.searchResults.getText());
    }

    @Step("I filter by *{0}*")
    @And("I filter by {string}")
    public void iFilterBy(String filterBy) throws Throwable {

        logger.info(String.format("I can see that results are correctly by the name", filterBy));
        switch (filterBy) {
            case "5 stars":
                testCommons.waitForElementToBeVisible(searchResultsPage.fiveStars);
                testCommons.customClick(searchResultsPage.fiveStars);
                testCommons.waitForElementToBeVisible(searchResultsPage.fiveStarsTag);

                Assert.assertTrue(testCommons.isElementVisible(searchResultsPage.fiveStarsTag));
                break;
            case "Spa":
                testCommons.waitForElementToBeVisible(searchResultsPage.spa);
                testCommons.customClick(searchResultsPage.spa);
                testCommons.waitForElementToBeVisible(searchResultsPage.spaTag);

                Assert.assertTrue(testCommons.isElementVisible(searchResultsPage.spaTag));
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.PHASE));
        }
    }

    @Step("I can see that results are correctly by hotel name *{0}*")
    @And("I can see that results are correctly by hotel name {string}")
    public void iCanSeeThatResultsAreCorrectlyByHotelName(String checkingHotelNameResults) throws Throwable {

        logger.info(String.format("I can see that results are correctly by the name", checkingHotelNameResults));
        switch (checkingHotelNameResults) {
            case "The Savoy Hotel":
                testCommons.waitForElementToBeVisible(searchResultsPage.hotelNameTheSavoyHotel);
                Assert.assertTrue(searchResultsPage.hotelNameTheSavoyHotel.getText().contains
                        (checkingHotelNameResults));
                break;
            case "George Limerick Hotel":
                testCommons.waitForElementToBeVisible(searchResultsPage.checkHotelName);
                Assert.assertFalse(searchResultsPage.checkHotelName.getText().contains
                        (checkingHotelNameResults));
                break;
            case "Absolute Hotel Limerick":
                testCommons.waitForElementToBeVisible(searchResultsPage.checkHotelName);
                Assert.assertFalse(searchResultsPage.checkHotelName.getText().contains
                        (checkingHotelNameResults));
                break;
            case "Dromoland Castle":
                testCommons.waitForElementToBeVisible(searchResultsPage.hotelDromolandCastle);
                Assert.assertTrue(searchResultsPage.hotelDromolandCastle.getText().contains
                        (checkingHotelNameResults));
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.PHASE));
        }
    }

    @Step("I can see the take control of search by *{0}*")
    @Then("I can see the take control of search by {string}")
    public void iCanSeeTheTakeControlOfSearchBy(String takeControl) throws Throwable {

        logger.info(String.format("I can see the take control o f search by", takeControl));
        switch (takeControl) {
            case "Spa":
                Assert.assertTrue(searchResultsPage.spaTag.getText().contains
                        (takeControl));
                break;
            case "5 stars":
                Assert.assertTrue(searchResultsPage.fiveStarsTag.getText().contains
                        (takeControl));
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.PHASE));
        }
    }
}
