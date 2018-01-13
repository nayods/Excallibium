package com.nayods.framework;


import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = {"src/test/resources/features/wikipediaFeatures/searchWikipedia.feature"},
        format = {"pretty","html:target/PrettyCucumber"},
        plugin = {"json:C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\lib\\cucumber.json"},
        glue = {"C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\src\\test\\java\\steps\\wikipediaSteps\\SearchWikipediaSteps.java"}

)
public class RunWikipediaTest {
}