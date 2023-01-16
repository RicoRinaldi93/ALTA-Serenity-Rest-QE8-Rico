Feature: Testing Delete user Reqres API
  @Latihan
  Scenario Outline: Delete users with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario Outline: Delete users with invalid id
    Given Delete user with invalid id <id>
    When Send request delete user
    Then Should return status code <No Content>
    Examples:
      | id   | No Content |
      | 1555 | 204        |