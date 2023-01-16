Feature: Testing Create user Reqres API

  @Latihan
  Scenario Outline: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code <created>
    And Response body name should be <name> and job <job>
    And Validate json schema create user
    Examples:
      | created | name           | job           |
      | 201     | "Rico Rinaldi" | "QA Engineer" |