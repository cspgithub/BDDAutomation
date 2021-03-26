package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
        glue= {"stepDefinitions"},
        plugin = { "pretty",
        		"timeline:test-output-thread/" }
 )
 
public class TestRunner {
 
}