Feature: add to Cart

  Scenario: Add to Cart
    Given user success login
    When user click AddtoCart button
    And button text change
    Then system add detail cart
