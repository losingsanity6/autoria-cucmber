# new feature
# Tags: optional

Feature: A description


  Scenario Outline: Car Filters test on Main page
    Given I enter car brand "<carBrand>"
    When I enter car model "<carModel>"
    When I click search button
    Then I see in header "<carBrand>"
    Examples:
      | carBrand   | carModel |
      | BMW        | X5       |
      | Volkswagen | Golf     |

  Scenario Outline:Test for price fields
    Given I enter "<priceFrom>" to priceFrom field and "<priceTo>" to priceTo field
    When I click search button
    Then I see on Result page in price filter "<priceFrom>"
    Examples:
      | priceFrom | priceTo |

  Scenario Outline:Extended search for checkboxes
    Given I click extended search button
    When I choose checkbox "<carType>"
    And I click origin "<origin>"
    And I click Show button
    Then I see in header "<carType>"
    Examples:
      | carType | origin |
      | Седан   | Англия |