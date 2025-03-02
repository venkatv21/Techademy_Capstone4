package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber.html",  // HTML Report
                "json:target/cucumber.json",  // JSON Report
                "junit:target/cucumber.xml",  // JUnit Report
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
