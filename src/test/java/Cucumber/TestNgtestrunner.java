package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features= "src/test/java/Cucumber", glue = "MJacademy.stepDefinitions",monochrome =true,plugin = {"html:target/cucumber.html"} )
public class TestNgtestrunner extends AbstractTestNGCucumberTests {
}
