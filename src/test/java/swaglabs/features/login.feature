Feature: Login page Swag Labs

  @Positive @Login
  Scenario: User can login with correct credential
    Given user open https://www.saucedemo.com/ in browser
    When user input a registered user
    And user input registered password
    And user tap login button
    Then user redirect to dashboard

  @Negative @Login
  Scenario: User can't login with wrong credential
    Given user open https://www.saucedemo.com/ in browser
    When user input a wrong registered user
    And user input registered password
    And user tap login button
    Then user see error message