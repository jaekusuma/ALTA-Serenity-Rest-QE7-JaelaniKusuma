@Tugas
Feature: patch update user
  Scenario Outline: Patch update user with valid json
    Given Patch update user with valid json with <id>
    When Send patch update user request
    Then Status code should be 200 OK
    And Response body should contain name "Jaelani Kusuma" and job "Teknisi"
    And Validate patch update json scheme
    Examples:
      | id |
      | 1  |
      | 2  |