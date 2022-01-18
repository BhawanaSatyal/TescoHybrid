Feature: Test Social media Functionality
@regression
  Scenario: As a user I should be able to connect to Facebook page when I click on facebook icon

    Given I am on a homepage
    When I click on facebook icon
    Then I should be able to navigate to facebook page
  And I click on twitter icon
  Then I should be able to navigate to twitter page

#  Scenario Outline:As a user I should be able to connect to Facebook page when I click on facebook icon
#
#    Given I am on a homepage
#    When I click on "<social_media>" icon
#    Then I should be able to navigate to facebook page
#
#    Examples:
#      | social_media |
#      | Facebook     |
#      | Twitter      |
