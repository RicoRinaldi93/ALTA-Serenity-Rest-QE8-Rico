Feature: Testing Register User Reqres API
  @Tugas
  Scenario: Post register new user with valid json
    Given Post register user with valid json
    When Send request post register user
    Then Should return status code 200
    And Response body name should be id 4 and token "QpwL5tke4Pnpja7X4"
    And Validate json schema register user

  @Tugas
  Scenario: Post register new user with valid json
    Given Post user register user with blank password with valid json
    When Send post register request is unsuccessful
    Then Should return status code 400
    And Validate json schema register unsuccessful


