# new feature
# Tags: optional

Feature: Tests on Main page


  Scenario Outline: Car Filters test on Main page
    Given  I open homepage
    When I enter car brand "<carBrand>"
    When I enter car model "<carModel>"
    When I click search button
    Then I see in header "<carBrand>"
    Examples:
      | carBrand   | carModel |
      | BMW        | X5       |
      | Volkswagen | Golf     |

  Scenario Outline:Test for price fields
    Given I open homepage
    When I enter "<priceFrom>" to priceFrom field and "<priceTo>" to priceTo field
    When I click search button
    Then I see on Result page in price filter "<priceFrom>"
    Examples:
      | priceFrom | priceTo |

  Scenario Outline:Extended search for checkboxes
    Given I open homepage
    When  I click extended search button
    When I choose checkbox "<carType>"
    And I click origin "<origin>"
    And I click Show button
    Then I see in header "<carType>"
    Examples:
      | carType | origin |
      | Седан   | Англия |

  Scenario Outline: click on Links
    Given I open homepage
    When I click on link that has a name "<linkName>"
    Then I see in url "<linkName>"
    Examples:
      | linkName   |
      | Volkswagen |
      | Skoda      |
      | Renault    |

  Scenario Outline: Used car filters and no results Message
    Given I open homepage
    When I enter car brand "<carBrand>"
    And I enter car model "<carModel>"
    And I enter region "<region>"
    And I enter "<priceTo>" to priceFrom field and "<priceFrom>" to priceTo field
    And I click search button
    Then I see no results message "<message>"
    Examples:
      | carBrand   | carModel | region  | priceFrom | priceTo | message                                                              |
      | Volkswagen | Golf R   | Винница | 1000      | 6000    | К сожалению, по Вашему запросу Объявлений не найдено. |