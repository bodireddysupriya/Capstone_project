package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\feature\\AddMultipleProducts.feature",
glue= {"stepDef","hooks"},
plugin = {"pretty","html:target/CucumberReports/report5.html"})

public class AddingMultipleProductsTestRunner extends AbstractTestNGCucumberTests  {

}
