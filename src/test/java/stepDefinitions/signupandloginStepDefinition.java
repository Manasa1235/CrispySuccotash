package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SignupandLoginPage;
import utils.CommonContent;
import utils.PlaywrightManager;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class signupandloginStepDefinition {

    private Page page = PlaywrightManager.getPage();
    private SignupandLoginPage signupandLoginPage;

    public signupandloginStepDefinition() {
        this.signupandLoginPage = new SignupandLoginPage(Hooks.getScenario()); // Pass the Scenario object to the LoginPage
    }

//    @Given("I open the browser")
//    public void iOpenTheBrowser() {
//        // Initialize Playwright
//        PlaywrightManager.initializePlaywright();
//        page = PlaywrightManager.getPage();
//    }



    @Then("I Navigate to Crispy Succotash Application {string}")
    public void iNavigateToCrispySuccotashApplication(String url) {
//        Hooks.getScenario().log("Navigating to the signup page");
        page.navigate(url);
    }

    @And("I click on Sign Up Button")
    public void iClickOnSignUpButton() {
        signupandLoginPage.clickOnSignUpButton();
    }

    @Then("Enter the Sign Up user details {string} {string} {string}")
    public void enterTheSignUpUserDetails(String userName, String password, String passwordConfirm) {
        signupandLoginPage.enterSignUpUserDetails(userName,password,passwordConfirm);
    }

    @And("Click on Sign Up Submit Button")
    public void clickOnSignUpSubmitButton() {
        signupandLoginPage.clickSignUpSubmit();
    }

    @Then("Verify User is created or not")
    public void verifyUserIsCreatedOrNot() {
        boolean result = signupandLoginPage.verifyUserIsCreated();
        assertTrue(result,"User should be created");
    }

    @Then("Verify UserName Error Message on SignUp Page {string}")
    public void verifyUserNameErrorMessageOnSignUpPage(String usernameErrorMessage) {
        String usernameErrorMessageText = CommonContent.getErrorMessage(usernameErrorMessage);
        assertTrue(signupandLoginPage.verifyUserNameErrorMessage(usernameErrorMessageText),"Expected Result is not displayed");
    }

    @Then("Verify Password Error Message on SignUp Page {string}")
    public void verifyPasswordErrorMessageOnSignUpPage(String passwordErrorMessage) {
        if(!Objects.equals(passwordErrorMessage, "")) {
        String passwordErrorMessageText = CommonContent.getErrorMessage(passwordErrorMessage);
            assertTrue(signupandLoginPage.verifyPasswordErrorMessage(passwordErrorMessageText), "Expected Result is not displayed");
        }
    }

    @Then("Verify Password Confirm Error Message on SignUp Page {string}")
    public void verifyPasswordConfirmErrorMessageOnSignUpPage(String passwordConfirmErrorMessage) {
        String passwordConfirmErrorMessageText = CommonContent.getErrorMessage(passwordConfirmErrorMessage);
        assertTrue(signupandLoginPage.verifyPasswordConfirmErrorMessage(passwordConfirmErrorMessageText),"Expected Result is not displayed");
    }
}
