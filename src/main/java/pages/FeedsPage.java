package pages;

import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import utils.PlaywrightManager;

public class FeedsPage {

    private final Page page;
    private Scenario scenario;


    public FeedsPage(Scenario scenario) {
        this.page = PlaywrightManager.getPage();
        this.scenario = scenario;
    }

    private static final String NEW_FEED_BUTTON_XPATH ="//a[@href='/feeds/new/']";
    private static final String FEED_URL_ADD_XPATH ="//input[@id='id_feed_url']";
    private static final String FEED_SUBMIT_BUTTON_XPATH ="//input[@id='submit-id-submit']";

    private static final String FEED_ERROR_XPATH ="//span[@id='error_1_id_feed_url']/strong";

    public void addFeedURL(String feedUrl){
        page.locator(NEW_FEED_BUTTON_XPATH).click();
        page.locator(FEED_URL_ADD_XPATH).fill(feedUrl);
        page.locator(FEED_SUBMIT_BUTTON_XPATH).click();
    }

    public Boolean verifyFeedUrl(String errorMessage){
        boolean flag=false;
        if((page.locator(FEED_ERROR_XPATH).textContent()).contains(errorMessage)){
            flag=true;
        }else{
            flag= false;
        }
    return flag;
    }
}
