package tests.WebAPP;

import com.steps.*;
import io.qameta.allure.*;
import com.buildListeners.TestNGListener;
import com.steps.hooks.WEB_Hooks;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Web App Tests")
@Feature("SEARCH TESTS")
@Listeners({TestNGListener.class})
public class SearchBox_Tests extends WEB_Hooks {

    @Story("POSITIVE FLOW")
    @Owner("Jader Cunha")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[1] As a user I would like to use a search and be able to see valid results for hotels filtered by 5 starts: \"The Savoy Hotel\"")
    @Test(description = "[US-555]/[1] I would like to use a search and be able to see valid results for hotels filtered by 5 starts: \"The Savoy Hotel\"")
    public void searchResultsFilterByHotelFiveStartsValid() throws Throwable {

        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();

        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeBookingComWebsite();
        mainPageSteps.iClickBookingLogo();
        mainPageSteps.iEnterAddress("Limerick");
        mainPageSteps.iClickCheckDate();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckIn();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckOut();
        mainPageSteps.iClickSearch();
        searchResultsPageSteps.iFilterBy("5 stars");

        searchResultsPageSteps.iCanSeeThatResultsAreCorrectlyByHotelName("The Savoy Hotel");
    }

    @Story("NEGATIVE FLOW")
    @Owner("Jader Cunha")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[1] As a user I would like to use a search and be able to see invalid results for hotels filtered by 5 starts: \"George Limerick Hotel\"")
    @Test(description = "[US-555]/[1] I would like to use a search and be able to see invalid results for hotels filtered by 5 starts : \"George Limerick Hotel\"")
    public void searchResultsFilterByHotelFiveStartsInvalid() throws Throwable {

        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();

        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeBookingComWebsite();
        mainPageSteps.iClickBookingLogo();
        mainPageSteps.iEnterAddress("Limerick");
        mainPageSteps.iClickCheckDate();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckIn();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckOut();
        mainPageSteps.iClickSearch();
        searchResultsPageSteps.iFilterBy("5 stars");

        searchResultsPageSteps.iCanSeeThatResultsAreCorrectlyByHotelName("George Limerick Hotel");
    }

    @Story("Negative FLOW")
    @Owner("Jader Cunha")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[2] As a user I would like to use a search and be able to see invalid results for hotels filtered by spa: \"George Limerick Hotel\"")
    @Test(description = "[US-555]/[2] I would like to use a search and be able to see invalid results for hotels filtered by spa: \"George Limerick Hotel\"")
    public void searchResultsHotelFilterBySpaInvalid() throws Throwable {

        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();

        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeBookingComWebsite();
        mainPageSteps.iClickBookingLogo();
        mainPageSteps.iEnterAddress("Limerick");
        mainPageSteps.iClickCheckDate();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckIn();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckOut();
        mainPageSteps.iClickSearch();
        searchResultsPageSteps.iClickShowAllFacilities();
        searchResultsPageSteps.iFilterBy("Spa");

        searchResultsPageSteps.iCanSeeThatResultsAreCorrectlyByHotelName("George Limerick Hotel");
    }

    @Story("POSITIVE FLOW")
    @Owner("Jader Cunha")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[2] As a user I would like to use a search and be able to see invalid results for hotels filtered by spa: \"Absolute Hotel Limerick\"")
    @Test(description = "[US-555]/[2] I would like to use a search and be able to see invalid results for hotels filtered by spa: \"Absolute Hotel Limerick\"")
    public void searchResultsHotelFilterBySpaValid() throws Throwable {

        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();

        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeBookingComWebsite();
        mainPageSteps.iClickBookingLogo();
        mainPageSteps.iEnterAddress("Limerick");
        mainPageSteps.iClickCheckDate();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckIn();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckOut();
        mainPageSteps.iClickSearch();
        searchResultsPageSteps.iClickShowAllFacilities();
        searchResultsPageSteps.iFilterBy("Spa");

        searchResultsPageSteps.iCanSeeThatResultsAreCorrectlyByHotelName("Absolute Hotel Limerick");
    }

    @Story("POSITIVE FLOW")
    @Owner("Jader Cunha")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[3] As a user I would like to use a search and be able to see results for hotels filtered by: \"Spa\"")
    @Test(description = "[US-555]/[3] I would like to use a search and be able to see results for hotels filtered by: \"Spa\"")
    public void searchHotelResultsFilteredBySpa() throws Throwable {

        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();

        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeBookingComWebsite();
        mainPageSteps.iClickBookingLogo();
        mainPageSteps.iEnterAddress("Limerick");
        mainPageSteps.iClickCheckDate();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckIn();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckOut();
        mainPageSteps.iClickSearch();
        searchResultsPageSteps.iClickShowAllFacilities();
        searchResultsPageSteps.iFilterBy("Spa");

        searchResultsPageSteps.iCanSeeTheTakeControlOfSearchBy("Spa");

    }

    @Story("POSITIVE FLOW")
    @Owner("Jader Cunha")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[3] As a user I would like to use a search and be able to see results for hotels filtered by: \"5 starts\"")
    @Test(description = "[US-555]/[3] I would like to use a search and be able to see results for hotels filtered by: \"5 starts\"")
    public void searchHotelResultsFilteredByFiveStars() throws Throwable {

        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();

        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeBookingComWebsite();
        mainPageSteps.iClickBookingLogo();
        mainPageSteps.iEnterAddress("Limerick");
        mainPageSteps.iClickCheckDate();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iClickNextMonth();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckIn();
        mainPageSteps.iChooseThreeMonthsFromTodayDateCheckOut();
        mainPageSteps.iClickSearch();
        searchResultsPageSteps.iClickShowAllFacilities();
        searchResultsPageSteps.iFilterBy("5 stars");

        searchResultsPageSteps.iCanSeeTheTakeControlOfSearchBy("5 stars");

    }
}