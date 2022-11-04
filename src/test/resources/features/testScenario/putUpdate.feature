@Tugas
Feature: Put update user
  Scenario Outline: Put update user with valid json
    Given Put update user with valid json with <id>
    When Send put update user request
    Then Status code should be 200 OK
    And Response body should contain name "Jaelani Kusuma" and job "Teknisi"
    And Validate put update json scheme
    Examples:
      | id |
      | 1  |
      | 2  |