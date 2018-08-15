Feature: Login tests

  Scenario Outline: Login via Facebook account
    Given I open login Page
    When I click facebook login button
    And I enter facebook credentials "<e-mail>", "<password>"
    Then I see message "<message>" on login page
    Examples:
      | e-mail               | password             | message    |
      | tanyalondon1@mail.ru | donotusethispassword | Не удалось |

