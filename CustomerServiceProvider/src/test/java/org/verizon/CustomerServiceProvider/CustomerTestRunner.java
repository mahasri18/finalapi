package org.verizon.CustomerServiceProvider;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "path/to/api_consumer.feature",
        glue = "path.to.your.step.definitions",
        plugin = {"pretty", "html:target/cucumber-reports"})
public class CustomerTestRunner {

}
