Feature: Login Functionality Test
@regression
  Scenario: As a user I should be able to log in successfully

    Given I am on homepage
    When I click on My account
    And I fill up log in details
    And I click on Sign in
    Then I should be logged in successfully
