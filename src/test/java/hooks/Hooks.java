package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	@BeforeAll
	public static void initilizingExtentReport() {
		BaseClass.init("ExtentReport");
	}
	@Before
	public static void creatingExtentTest(Scenario scenario) {
		logger1 = extent.createTest(scenario.getName());
	}
	@After
	public static void closeapplication() {
		BaseClass.closeBrowser();
		extent.flush();
	}
	

}
