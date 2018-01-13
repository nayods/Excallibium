package com.nayods.framework;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/features/wikipediaFeatures/searchWikipedia.feature"},
        format = {"pretty","html:target/site/PrettyCucumber"},
        plugin = {"json:C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\lib\\cucumber.json"},
        glue = {"C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\src\\test\\java\\steps\\wikipediaSteps\\SearchWikipediaSteps.java"}

)
public class RunWikipediaTest {
}