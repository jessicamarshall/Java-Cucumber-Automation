package com.orasi.stepDefinitions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        format = {"pretty",
                "html:target/cucumber-html-report/newTitle",//what formatters to use
                "html:target/cucumber-json-report/newTitle"},//what formatters to use
        tags = {"@newTitle"})//what tags to include(@)/exclude(@~)
public class TestNewTitle {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}



}
