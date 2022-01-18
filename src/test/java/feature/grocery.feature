Feature: test Grocery facilities
@regression
  Scenario: As a user I want to be able to complete grocery shopping

    Given I am logged in
    When I click on Grocery Orders
    And I search for required item
    Then I should be able to able to amend qty on related items and add to cart
    And I should be able to checkout and book delivery slot

