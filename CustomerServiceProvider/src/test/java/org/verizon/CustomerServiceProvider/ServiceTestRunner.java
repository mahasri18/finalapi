package org.verizon.CustomerServiceProvider;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "path/to/api_service.feature",
        glue = "path.to.your.step.definitions",
        plugin = {"pretty", "html:target/cucumber-reports"})
public class ServiceTestRunner {

}
