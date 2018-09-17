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
      | 200       | 3000    |
      | 1000      | 100000  |

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
    When I enter to filter dropdown named - "brand" data - "<carBrand>"
    When I enter to filter dropdown named - "model" data - "<carModel>"
    And I enter to filter dropdown named - "region" data - "<region>"
    And I enter "<priceTo>" to priceFrom field and "<priceFrom>" to priceTo field
    And I click search button
    Then I see no results message "<message>"
    Examples:
      | carBrand   | carModel | region  | priceFrom | priceTo | message                                                |
      | Volkswagen | Golf R   | Винница | 1000      | 6000    | К сожалению, по Вашему запросу Объявлений не найдено. |

  Scenario Outline:Check languages
    Given I open homepage
    When I change language to "<language>"
    Then I see in title "<title>" and in url "<url>"
    Examples:
      | language | title                                                           | url                      |
      | Укр      | AUTO.RIA™ — Автобазар №1. Купити і продати авто легко як ніколи | https://auto.ria.com/uk/ |

  Scenario Outline:Check other ria services
    Given I open homepage
    When i click on link of other ria service in header "<serviceName>"
    Then i see new tab opened and check url "<url>" and i see in title "<title>"
    Examples:
      | serviceName   | url                                                                                                                      | title                                                                     |
      | Недвижимость  | "https://dom.ria.com/?utm_source=auto_ria&utm_medium=text_link&utm_content=nedvigimost&utm_campaign=header               | DOM.RIA™ — вся недвижимость Украины. Продажа и аренда любой недвижимости. |
      | RIA.com       | https://www.ria.com/                                                                                                     | RIA.com ™ — доска бесплатных частных объявлений Украины.                  |
      | Автотовары    | https://market.ria.com/?utm_source=auto.ria.com&utm_medium=text_link&utm_content=magazin_avtotovarov&utm_campaign=header | MARKET.RIA — шины, диски и аксессуары для авто по выгодным ценам"         |
      | Автозапчасти | https://zapchasti.ria.com/                                                                                               | 1 000 000+ запчастей на авто в Украине на ZAPCHASTI.RIA                   |


