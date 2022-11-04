@Tugas
Feature: Register with email and password
  Scenario: User register with valid email and password
    Given Post user register with valid json
    When Send post register user request
    Then Status code should be 200 OK
    And Response body contain id 4 token "QpwL5tke4Pnpja7X4"
    And Validate post register user schema

  Scenario: User register with valid email and without password
    Given Post user register with invalid json
    When Send post invalid register user request
    Then Status code should be 400 bad request
    And Response body contain error "Missing password"
    And Validate post invalid register user schema

  Scenario: User register without email and password
    Given Post user register with null json
    When Send post invalid user register request
    Then Status code should be 400 bad request
    And Response body contain error "Missing email or username"
    And Validate post invalid user register schema