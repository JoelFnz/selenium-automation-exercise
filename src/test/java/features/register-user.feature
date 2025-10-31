Feature: Register User
  As user
  I want to create an account
  to gain access to the application

  Scenario: Successful Register
    When I click the Signup-Login button
    Then the New User Signup! form should be visible
    When I submit the New User Signup! form with unregistered user data
    Then the Enter Account Information form should be visible
    When I submit the Enter Account Information form with unregistered user data
    Then a message saying 'ACCOUNT CREATED!' should appear
    When I click the 'Continue' button
    Then a caption saying 'Logged in as username' should be visible
    When I click the 'Delete account' button
    Then a message saying 'ACCOUNT DELETED' should appear

  Scenario: Register with existing email
    When I click the Signup-Login button
    Then the New User Signup! form should be visible
    When I submit the New User Signup! form with registered user data
    Then an error message should appear
