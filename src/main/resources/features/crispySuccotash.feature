Feature: User account creation and login

#  Scenario Outline: Open a website and Sign Up using valid credentials
##    Given I open the browser
#    Then I Navigate to Crispy Succotash Application "http://localhost:8000/"
#    And I click on Sign Up Button
#    Then Enter the Sign Up user details "<Username>" "<Password>" "<PasswordConfirmation>"
#    And  Click on Sign Up Submit Button
#    Then Verify User is created or not
#
#    Examples:
#    |Username|Password|PasswordConfirmation|
#    |manasa123@gmail.com|crispy@123|crispy@123|

  Scenario: Open Crispy Succotash Application
    Then I Navigate to Crispy Succotash Application "http://localhost:8000/"
    And I click on Sign Up Button

  Scenario Outline: Sign Up using invalid credentials and verify Error Messages
    Then Enter the Sign Up user details "<Username>" "<Password>" "<PasswordConfirmation>"
    And  Click on Sign Up Submit Button
    Then Verify UserName Error Message on SignUp Page "<UsernameErrorMessage>"
    Then Verify Password Error Message on SignUp Page "<PasswordErrorMessage>"
    Then Verify Password Confirm Error Message on SignUp Page "<PasswordConfirmErrorMessage>"

    Examples:
      | Username            | Password   | PasswordConfirmation | UsernameErrorMessage | PasswordErrorMessage | PasswordConfirmErrorMessage|
      | crispy)             | succo       | succo                 | InvalidUserNameError |                      | ShortPasswordConfirmError       |
      |                     |             |                       | EmptyFieldError       |   EmptyFieldError                   |   EmptyFieldError     |

  Scenario Outline:Sign Up using valid credentials
    Then Enter the Sign Up user details "<Username>" "<Password>" "<PasswordConfirmation>"
    And  Click on Sign Up Submit Button
    Then Verify User is created or not

    Examples:
    |Username|Password|PasswordConfirmation|
    |manasa123@gmail.com|crispy@123|crispy@123|


  Scenario Outline: Login using invalid/existing credentials and verify the error messages
  Scenario Outline: Login using valid credentials a
