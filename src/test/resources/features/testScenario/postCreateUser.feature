@Tugas
Feature: Create user
  Scenario: Create user with valid email and password json
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 created
    And Response body contain name "morpheus" job "leader"
    And Validate create user json schema