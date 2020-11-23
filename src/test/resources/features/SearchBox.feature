@searchBox
Feature: A a user I would like to see results of searching hotel


  Background: Navigate to booking.com website
    When I open home page

#--------------------------------------------------------------------------------#

  @non-smoke @critical @regression
  Scenario Outline:[US-555]/[1] As a user I would like to use a search and be able to see valid results for hotels filtered by spa:  "<search hotel>"
    Given I can see booking.com website
    When I enter destination "<search destination>"
    And I click check date
    And I click next month
    And I click next month
    And I choose three months from today date check in
    And I choose three months from today date check out
    When I click search
    And I click show all facilities
    And I filter by "<filtered by>"
    Then I can see that results are correctly by hotel name "<expected results>"

    Examples: SCENARIO OUTLINE DATA
      | search destination  | filtered by     | expected results    |
      | Limerick            | Spa             | Dromoland Castle    |
      | Limerick            | Spa             | The Savoy Hotel     |

#--------------------------------------------------------------------------------#

  @non-smoke @critical @regression
  Scenario Outline:[US-555]/[2] As a user I would like to use a search and be able to see invalid results for hotels filtered by spa:  "<search hotel>"
    Given I can see booking.com website
    When I enter destination "<search destination>"
    And I click check date
    And I click next month
    And I click next month
    And I choose three months from today date check in
    And I choose three months from today date check out
    When I click search
    And I filter by "<filtered by>"
    Then I can see that results are correctly by hotel name "<expected results>"

    Examples: SCENARIO OUTLINE DATA
      | search destination  | filtered by     | expected results        |
      | Limerick            | 5 stars         | George Limerick Hotel   |
      | Limerick            | 5 stars         | Absolute Hotel Limerick |

#--------------------------------------------------------------------------------#

  @non-smoke @critical @regression
  Scenario Outline:[US-555]/[3] As a user I would like to use a search and be able to see results for hotels filtered by: "<Spa>"
    Given I can see booking.com website
    When I enter destination "<search destination>"
    And I click check date
    And I click next month
    And I click next month
    And I choose three months from today date check in
    And I choose three months from today date check out
    When I click search
    And I click show all facilities
    And I filter by "<filtered by>"

    Examples: SCENARIO OUTLINE DATA
      | search destination  | filtered by    |
      | Limerick            | Spa            |
      | Limerick            | 5 stars        |