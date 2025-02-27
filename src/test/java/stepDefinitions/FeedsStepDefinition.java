package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.FeedsPage;
import pages.SignupandLoginPage;
import utils.CommonContent;
import utils.PlaywrightManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeedsStepDefinition {

    private Page page = PlaywrightManager.getPage();
    private FeedsPage feedsPage;

    public FeedsStepDefinition() {
        this.feedsPage = new FeedsPage(Hooks.getScenario()); // Pass the Scenario object to the LoginPage
    }

    @Given("Click on New Feed and add a feed url {string}")
    public void clickOnNewFeedAndAddAFeedUrl(String feedUrl) {
        feedsPage.addFeedURL(feedUrl);
    }

    @Then("Verify error message when feed url is empty {string}")
    public void verifyErrorMessageWhenFeedUrlIsEmpty(String errormessage) {
      String urlerrormessage= CommonContent.getErrorMessage(errormessage);
      assertTrue(feedsPage.verifyFeedUrl(urlerrormessage));
    }
}
