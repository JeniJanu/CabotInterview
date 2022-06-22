@tag
Feature: Amazon buy a product

  Scenario: Verify is make payment page is navigated
    Given Launch the <chrome> with <https://www.amazon.in>
    When user searches a product <product>
    And User clicks <Add to cart>
    Then user click <makepayment>
