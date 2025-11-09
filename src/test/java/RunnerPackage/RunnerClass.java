package RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features=".//Feature/Feature.feature",
		          glue="StepDefinition",
		          monochrome=true,
		          dryRun=false,
		          tags="@tag",
		          plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}          
		)

public class RunnerClass extends AbstractTestNGCucumberTests {

}
 