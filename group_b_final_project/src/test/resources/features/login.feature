@regression @login
Feature: Login feature

  Background:
    Given I am on search vacation package

@regression-1
  Scenario: Verify Invalid Login
    When I enter mohammad@technosoftacademy.io into username text fields on home screen
    And I enter test1234 into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am an invalid login page

  @regression-2
  Scenario: Verify Invalid Login two
    When I enter chris@technosoftacademy.io into username text fields on home screen
    And I enter abc1234 into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am an invalid login page
    And I see number 12 in text field

  @regression-3
  Scenario Outline: Verify Invalid Login for multiple users
    When I enter <username> into username text fields on home screen
    And I enter <password> into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am an invalid login page

    Examples:
      | username                      | password |
      | mohammad@technosoftacademy.io | test1234 |
      | chris@technosoftacademy.io    | abc123   |

  @regression-4
  Scenario:  Verify Vacation Packages
    When I click on flight/hotel button
    And I enter Charlotte, NC (CLT-Charlotte-Douglas Intl.) into origin destination text fields on home screen
    And I enter New York, New York into final destination text fields on home screen
#    And I select dates from calendar on home screen
    And I enter dates to calendar
    And I select 1 from rooms dropdown button
    And I select 1 from adult dropdown button
    And I select 1 from children dropdown button
    And I select 4 from child1age dropdown button
    And I click on Advanced dropdown button select Business
    And I click on Search button
    Then I verify that departing text displayed what's expected
    Then I verify that dates text displayed what's expected
    Then I verify that arriving text displayed what's expected
    Then I verify that 1room text displayed what's expected
    Then I verify that 1adult text displayed what's expected
    Then I verify that 1child text displayed what's expected
#    Then I verify that business text displayed what's expected




