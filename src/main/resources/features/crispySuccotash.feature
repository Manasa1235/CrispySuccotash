Feature: User account creation and login

  Scenario: Open Crispy Succotash Application
    Then I Navigate to Crispy Succotash Application "http://localhost:8000/"
    And I click on Sign Up Button

  Scenario Outline: Sign Up using invalid credentials and verify Error Messages
    Then Enter the Sign Up user details "<Username>" "<Password>" "<PasswordConfirmation>"
    And  Click on Sign Up Submit Button
    Then Verify UserName Error Message "<UsernameErrorMessage>"
    Then Verify Password Error Message "<PasswordErrorMessage>"
    Then Verify Password Confirm Error Message on SignUp Page "<PasswordConfirmErrorMessage>"

    Examples:
      | Username            | Password   | PasswordConfirmation | UsernameErrorMessage | PasswordErrorMessage | PasswordConfirmErrorMessage|
      | crispy)             | succo       | succo                 | InvalidUserNameError |                      | ShortPasswordConfirmError       |
      |                     |             |                       | EmptyFieldError       |   EmptyFieldError                   |   EmptyFieldError     |

  Scenario Outline:Sign Up using valid credentials
    Then Enter the Sign Up user details "<Username>" "<Password>" "<PasswordConfirmation>"
    And  Click on Sign Up Submit Button
    Then Verify User is created or not
    And Logout

    Examples:
    |Username|Password|PasswordConfirmation|
    |testing3@gmail.com|crispy@123|crispy@123|


  Scenario Outline: Login using invalid/existing credentials and verify the error messages
    Then Click on Login Button
    And Enter user credentials "<Username>" "<Password>" to login
    Then Verify UserName Error Message "<UsernameErrorMessage>"
    Then Verify Login Password Error Message "<PasswordErrorMessage>"
    Examples:
      |Username|Password|UsernameErrorMessage|PasswordErrorMessage|
      |manasa123@gmail.com|crispy@456|   LoginCommonError     |  LoginCommonError           |
      |        |        |EmptyFieldError     |EmptyFieldError     |



  Scenario Outline: Login using valid credentials
    And Enter user credentials "<Username>" "<Password>" to login
    Then Verify user is logged in succesfully

    Examples:
      |Username|Password|
      |manasa123@gmail.com|crispy@123|

