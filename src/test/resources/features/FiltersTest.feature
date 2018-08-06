# new feature
# Tags: optional

Feature: A description

  Background: I open home page

  Scenario Outline: Car Filters test on Main page
    When I enter car brand "<carBrand>"
    And I enter car model "<carModel>"
    And I click search button
    Then I see in header "<carBrand>"
    Examples:
      | carBrand   | carModel |
      | BMW        | X5       |
      | Volkswagen | Golf     |

  Scenario Outline:Test for price fields
    When I enter "<priceFrom>" to priceFrom field and "<priceTo>" to priceTo field
    And I click search button
    Then I see on Result page in price filter "<priceFrom>"
    Examples:
      | priceFrom | priceTo |

  Scenario Outline:Extended search for checkboxes
    When I click extended search button
    And I choose checkbox "<carType>"
    And I click origin "<origin>"
    And I click Show button
    Then I see in header "<carType>"
    Examples:
      | carType | origin |
      | Седан   | Англия |