Feature: Checkout products Swag Labs

  @Positive @Checkout
  Scenario: User can sort product
    Given user open https://www.saucedemo.com/ in browser
    When user input a registered user
    And user input registered password
    And user tap login button
    And user see dashboard
    And user click add to cart
    And user click cart
    And user click checkout
    And user input first name
    And user input last name
    And user input postal code
    And user click continue
    And user click finish
    Then user see checkout complete page