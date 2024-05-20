package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature",
        glue = {"StepDefinition"},
        plugin = {"pretty","html:target/HtmlReports/report.html","json:target/JsonReports/report.json","junit:target/JUnitReports/report.xml"},
        monochrome = true

)

public class TestRunner {
}
