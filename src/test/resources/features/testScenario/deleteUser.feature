@Tugas
  Feature: Delete User
    Scenario Outline: Delete user with valid id
      Given Delete user with <id>
      When Send delete user request
      Then Status code should be 204 No Content
      Examples:
        | id |
        | 1  |
        | 2  |