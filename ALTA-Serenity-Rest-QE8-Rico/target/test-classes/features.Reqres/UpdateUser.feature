Feature: Testing Update user Reqres API
  @Latihan
  Scenario Outline: Put update user with valid json
    Given Put update user with valid json with id <id>
    When Send request put update user
    Then Should return status code <ok>
    And Response body name should be <name> and job <job>
    And Validate json schema update user
    Examples:
      | id | ok  | name           | job           |
      | 2  | 200 | "Rico Rinaldi" | "QA Engineer" |
