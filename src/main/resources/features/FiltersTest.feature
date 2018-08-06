# new feature
# Tags: optional

Feature: A description
  Background: I open home page

  Scenario: Car Filters test on Main page
    When I enter car brand "BMW"
    And I enter car model "X5"
    And I click search button
    Then I see in header "BMW"

    Scenario:Test for price fields
      When I enter "1000" to priceFrom field and "1000000000" to priceTo field
      And I click search button
      Then I see on Result page in price filter "1000"

      Scenario:Extended search for checkboxes
        When I click extended search button
        And I choose checkbox "Седан"
        And I click origin "Англия"
        And I click Show button
        Then I see in header "Седан"