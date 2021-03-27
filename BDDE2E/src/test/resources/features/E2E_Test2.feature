Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

  Scenario: Verify22 Login Page successfully Loaded
    Given I enter url on browser
    When I enter credentials
    Then I verify user logged successfully

  