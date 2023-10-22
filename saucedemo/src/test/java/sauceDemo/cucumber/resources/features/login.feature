Feature: Login to system

  @Positive
  Scenario: Success Login
    Given user open website
    When user input username
    And user input password
    And user click login
    Then user entering system

    Example:
    visual_user  secret_sauce  success


  @Negative
  Scenario: Failed Login
    Given user open website
    When user input username
    And user input invalid password
    And user click login
    Then error system alert

  Example:
  visual_user  secret_receipe  error
