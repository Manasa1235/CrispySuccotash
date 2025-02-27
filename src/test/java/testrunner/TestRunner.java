package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/main/resources/features/crispySuccotash.feature",
            glue = {"stepDefinitions", "utils"}, // Include the package containing Hooks
            plugin = {
                    "pretty",                             // Prints logs to the console
                    "html:target/cucumber-reports.html",  // Generates an HTML report
                    "json:target/cucumber-reports.json"   // Generates a JSON report
            },
            monochrome = true
    )
    public class TestRunner {

    }


