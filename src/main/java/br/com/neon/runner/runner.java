package br.com.neon.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = {"br.com.neon.steps"},
        tags = {"@Mensagen"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
        }
)
public class runner {

}
