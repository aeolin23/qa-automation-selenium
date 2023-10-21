Feature: Filter products Swag Labs

  @Positive @Filter
  Scenario: User can sort product
    Given user open https://www.saucedemo.com/ in browser
    When user input a registered user
    And user input registered password
    And user tap login button
    And user see dashboard
    And user filter product by name Z to A
    And user filter product by price high to low
    Then user filter product by price low to high