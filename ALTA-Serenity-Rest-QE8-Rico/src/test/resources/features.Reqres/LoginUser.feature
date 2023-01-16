Feature: Testing Login user Reqres API
  @Tugas

  Scenario: Post login new user with valid json
    Given Post login user with valid json
    When Send request post login user
    Then Should return status code 200
    And Response body name should be token "QpwL5tke4Pnpja7X4"
    And Validate json schema post login
  @Tugas
  Scenario: Post login new user with valid json
    Given Post user login with blank password with valid json
    When Send post login request is unsuccessful
    Then Should return status code 400