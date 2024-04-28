Feature: Login feature

  Scenario: Login Successful
    Given I open Login Page
    When I enter valid email "grigore.crepciuc@testpro.io"
    And I enter valid password "te$t$tudent"
    And I click submit
    Then I am logged in

  Scenario: Wrong password test
    Given I open Login Page
    When I enter valid email "grigore.crepciuc@testpro.io"
    And I enter wrong password "wrongerte$t$tudent"
    And I click submit
    Then I am not logged in