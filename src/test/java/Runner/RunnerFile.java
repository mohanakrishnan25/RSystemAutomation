package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"./src/test/resources/Features"},
		glue= {"StepDefinition"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary"},
		tags="@redbus",
		dryRun=false,
		strict=true,
		monochrome=true
		)
public class RunnerFile extends AbstractTestNGCucumberTests{

}
