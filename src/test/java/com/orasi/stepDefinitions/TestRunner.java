package com.orasi.stepDefinitions;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        format = {"pretty",
                "html:target/cucumber-html-report"},//what formatters to use
        tags = {"@Login"})//what tags to include(@)/exclude(@~)
public class TestRunner {

}
