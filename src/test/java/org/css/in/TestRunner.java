package org.css.in;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\SATHYA ECLIPSE FILES\\MacCosmetics\\src\\test\\resources\\Mac.feature",glue="org.css.in",dryRun=false,tags= {"@tag1"},plugin={"json:target/cucumber-reports/Cucumber.json"})

public class TestRunner {

}
