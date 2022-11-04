@Tugas
  Feature: Login with valid email and password
    Scenario: User Login with valid email and password
      Given Post user login with valid json
      When Send post login user request
      Then Status code should be 200 OK
      And Response body contain token "QpwL5tke4Pnpja7X4"
      And Validate valid login user schema

    Scenario: User Login with valid email and without password
      Given Post user login with invalid json
      When Send post invalid login user request
      Then Status code should be 400 bad request
      And Response body contain error "Missing password"
      And Validate invalid login user schema
