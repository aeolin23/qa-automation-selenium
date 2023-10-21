package swaglabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/swaglabs/features",
        glue = "swaglabs.stepDef",
        plugin = {"html:target/HTML_report.html"},
        tags = "@Positive and @Filter"
)

public class runFilter {
}
