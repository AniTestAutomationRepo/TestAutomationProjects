package runner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.XMLHelper;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport          = "target/cucumber-reports/CucumberTestReport.json",
        retryCount          = 1,
        detailedReport      = true,
        overviewReport      = true,
        jsonUsageReport     = "target/cucumber-reports/cucumber.json",
        excludeCoverageTags = {"@wip"},
        outputFolder        = "target/Output")

@CucumberOptions(
        features            = "src/test/resources/features",
        glue                = {"steps"},
        plugin              = {"pretty:STDOUT", "html:target/cucumber-pretty",
                                "json:target/cucumber-reports/CucumberTestReport.json",
                                "junit:target/cucumber-reports/CucumberJunit.xml",
                                "rerun:target/rerun.txt"},
        tags                = "@reg"
)

public class TestRunner {

    @BeforeClass
    public static void setUpTestInitialise() throws Exception {
         XMLHelper.initialize();
    }

}
