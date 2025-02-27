package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.PlaywrightManager;

import static utils.PlaywrightManager.initializePlaywright;

public class Hooks {
    private static Scenario scenario;
    @Before
    public void setUp(Scenario scenario) {
        Hooks.scenario = scenario;
        initializePlaywright();
    }

    public static Scenario getScenario() {
        return scenario; // Provide access to the Scenario object
    }

//        @After
//        public void tearDown() {
//            // Close the browser and Playwright after each scenario
//            PlaywrightManager.tearDown();
//        }

}
