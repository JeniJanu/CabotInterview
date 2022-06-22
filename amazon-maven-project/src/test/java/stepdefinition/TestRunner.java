package stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features/", glue={
"stepdefinition"},

plugin = {"pretty", "html:target/cucumber", 
"com.cucumber.listener.ExtentCucumberFormatter:"},

monochrome=true,

tags = {"@tag"}
)

public class TestRunner{
}
