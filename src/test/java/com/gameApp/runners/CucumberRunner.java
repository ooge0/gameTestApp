package com.gameApp.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/home/roman/GIT/git_JAVA/gameTestApp/src/test/resources/features",
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        tags = "@baseTest",
        glue = {"com.gameApp.stepDefinitions"}
)
public class CucumberRunner {

}
