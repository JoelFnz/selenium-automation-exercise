Feature: Login

  Scenario: Successful Login
    When I click the Signup-Login button
    Then the Login to your account form should be visible
    When I submit the login form with registered user data
    Then a caption saying 'Logged in as username' should be visible

  Scenario: Unsuccessful Login
    When I click the Signup-Login button
    Then the Login to your account form should be visible
    When I submit the login form with invalid user data
    Then an error message should appear

  Scenario: Logout
    When I click the Signup-Login button
    And I submit the login form with registered user data
    Then the Logout button should be displayed
    When I click the Logout button
    Then I should be redirected to the signup-login page
