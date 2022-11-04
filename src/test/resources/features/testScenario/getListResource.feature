@Tugas
Feature: Get list resource
  Scenario Outline: Get list user with valid parameter page
    Given Get list resource with parameter page <page>
    When Send get list resource request
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list resource json scheme
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario Outline: Get list user with invalid parameter page
    Given Get user with parameter <id>
    When Send get user request
    Then Status code should be 404 not found
      Examples:
        | id |
        | 32 |
        | 23 |