package pages;

import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import utils.PlaywrightManager;

public class SignupandLoginPage {

    private final Page page;
    private Scenario scenario;


    private static final String SIGNUP_BUTTON_XPATH ="//a[@class='btn btn-warning']";
    private static final String USERNAME_INPUT_XPATH ="//input[@id='id_username']";
    private static final String PASSWORD_INPUT_XPATH ="//input[@id='id_password1']";
    private static final String LOGIN_PASSWORD_INPUT_XPATH ="//input[@id='id_password']";
    private static final String PASSWORDCONFIRM_INPUT_XPATH ="//input[@id='id_password2']";
    private static final String SIGNUP_SUBMIT_BUTTON_XPATH ="//input[@id='submit-id-submit']";
    private static final String SIGNUP_SUCCESS_MESSAGE_XPATH="//div[contains(text(),'Great success! Enjoy :)')]";
    private static final String LOGIN_BUTTON_XPATH="//a[@href='/accounts/login/']";
    private static final String LOGIN_USER_BUTTON_XPATH="//input[@class='btn btn-success btn-sm']";
    private static final String FEEDS_HEADER_XPATH="//nav[@class='navbar']/following-sibling::header";


    private static final String ERROR_USERNAME_XPATH="//*[@id='error_1_id_username']";
    private static final String PASSWORD_ERROR_XPATH="//span[@id='error_1_id_password1']";
    private static final String PASSWORDCONFIRM_ERROR_XPATH="//span[@id='error_1_id_password2']";
    private static final String COMMONERROR_LOGIN_XPATH="//div[@class='alert alert-block alert-danger']/ul/li";
    private static final String LOGIN_PASSWORD_ERROR_XPATH="//p[@id='error_1_id_password']";

    private static final String LOGOUT_BUTTON_XPATH="//a[@href='/accounts/logout/']";


    public SignupandLoginPage(Scenario scenario) {
        this.page = PlaywrightManager.getPage();
        this.scenario = scenario;
    }

    public void clickOnSignUpButton(){
        page.locator(SIGNUP_BUTTON_XPATH).click();
        scenario.log("Clicked on Sign Up Button");
    }

    public void enterSignUpUserDetails(String userName,String password,String passwordConfirm){
        page.locator(USERNAME_INPUT_XPATH).fill(userName);
        scenario.log("Entered Username" + userName);
        page.locator(PASSWORD_INPUT_XPATH).fill(password);
        scenario.log("Entered Password" + password);
        page.locator(PASSWORDCONFIRM_INPUT_XPATH).fill(passwordConfirm);
        scenario.log("Entered Password Confirmation" + passwordConfirm);
    }

    public void clickSignUpSubmit(){
        page.locator(SIGNUP_SUBMIT_BUTTON_XPATH).click();
        scenario.log("Clicked on Submit Button On Sign Up Page");
    }

    public Boolean verifyUserIsCreated(){
        boolean flag;
        if((page.locator(SIGNUP_SUCCESS_MESSAGE_XPATH).textContent()).contains("Great success! Enjoy :)")){
            scenario.log("User is created successfully");
            flag=true;
        }else if((page.locator(SIGNUP_SUCCESS_MESSAGE_XPATH).textContent()).contains("A user with that username already exists.")) {
            scenario.log("Username already exist");
            flag = false;
        }
        else{
            scenario.log("User is not created");
            flag=false;
        }
        return flag;
    }

    public Boolean verifyUserNameErrorMessage(String usernameErrorMessageText){
        boolean flag=false;
        if(page.locator(ERROR_USERNAME_XPATH).isVisible()) {
            if ((page.locator(ERROR_USERNAME_XPATH).textContent()).contains(usernameErrorMessageText)) {
                scenario.log(usernameErrorMessageText + " is displayed");
                flag = true;
            }
        }else if((page.locator(COMMONERROR_LOGIN_XPATH).textContent()).contains(usernameErrorMessageText)){
            scenario.log(usernameErrorMessageText + " is displayed");
            flag = true;
        }
        return flag;
    }

    public Boolean verifyPasswordErrorMessage(String passwordErrorMessage) {
        boolean flag = false;
            if ((page.locator(PASSWORD_ERROR_XPATH).textContent()).contains(passwordErrorMessage)) {
                scenario.log(passwordErrorMessage + " is displayed");
                flag = true;
            } else if ((page.locator(COMMONERROR_LOGIN_XPATH).textContent()).contains(passwordErrorMessage)) {
                scenario.log(passwordErrorMessage + " is displayed");
                flag = true;
            }
        return flag;
    }

    public Boolean verifyLoginPasswordErrorMessage(String passwordErrorMessage){
        boolean flag=false;
        if(page.locator(LOGIN_PASSWORD_ERROR_XPATH).isVisible()){
            if ((page.locator(LOGIN_PASSWORD_ERROR_XPATH).textContent()).contains(passwordErrorMessage)) {
                scenario.log(passwordErrorMessage + " is displayed");
                flag = true;
            }
        }else if((page.locator(COMMONERROR_LOGIN_XPATH).textContent()).contains(passwordErrorMessage)){
            scenario.log(passwordErrorMessage + " is displayed");
            flag = true;
        }
        return flag;
    }

    public Boolean verifyPasswordConfirmErrorMessage(String passwordConfirmErrorMessage){
        boolean flag=false;
        if((page.locator(PASSWORDCONFIRM_ERROR_XPATH).textContent()).contains(passwordConfirmErrorMessage)){
            scenario.log(passwordConfirmErrorMessage + " is displayed");
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }


    public void clickOnLoginButton(){
        page.locator(LOGIN_BUTTON_XPATH).click();
    }

    public void enterLoginUserCredentials(String username,String password){
        page.locator(USERNAME_INPUT_XPATH).fill(username);
        scenario.log("Entered Username" + username);
        page.locator(LOGIN_PASSWORD_INPUT_XPATH).fill(password);
        scenario.log("Entered Password" + password);
        page.locator(LOGIN_USER_BUTTON_XPATH).click();
    }

    public Boolean verifyUserIsLoggedIn() {
        boolean flag;
        if ((page.locator(FEEDS_HEADER_XPATH).textContent()).contains("Feeds")) {
            scenario.log("User is logged in successfully");
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void logout(){
        page.locator(LOGOUT_BUTTON_XPATH).click();
    }
}
