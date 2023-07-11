package com.bdd.runnerclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featurefiles/",
        glue = {"com/bdd/stepdefinitions", "com/bdd/hooks"},
        plugin = {"pretty"},
        tags = "@Regression"
)
public class RunnerClass {

}