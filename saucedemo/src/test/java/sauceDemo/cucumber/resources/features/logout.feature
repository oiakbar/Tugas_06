Feature: Logout system

  Scenario: Success Logout
    Given user success login
    When user click menu
    And user click logout password
    Then user exit system