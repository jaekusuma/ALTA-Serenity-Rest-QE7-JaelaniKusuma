@Tugas
  Feature: Get single users
    Scenario Outline: Get single users with valid parameter
      Given Get user with parameter <id>
      When Send get user request
      Then Status code should be 200 OK
      And Response body should contain id <id>
      And Validate get single user json scheme
      Examples:
        | id |
        | 1  |
        | 2  |
        | 3  |
        | 4  |
        | 5  |
        | 6  |
        | 7  |
        | 8  |
        | 9  |
        | 10 |
        | 11 |
        | 12 |

    Scenario Outline: Get single users with invalid parameter
      Given Get user with parameter <id>
      When Send get user request
      Then Status code should be 404 not found

      Examples:
        | id |
        | 32 |
        | 23 |