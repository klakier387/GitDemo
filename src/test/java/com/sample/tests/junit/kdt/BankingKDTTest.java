package com.sample.tests.junit.kdt;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:build/cucumber-html-report",
                "junit:build/cucumber-junit.xml",
                "json:build/cucumber.json",
                "pretty:build/cucumber-pretty.txt",
                "usage:build/cucumber-usage.json"},
        features = {"src/test/java/com/sample/tests/junit/kdt/features"},
        glue = {"com/sample/tests/junit/kdt/steps"}
)
public class BankingKDTTest {
}
