package com.nayods.framework;


import cucumber.api.CucumberOptions;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = {"src/test/resources/features/wikipediaFeatures/searchWikipedia.feature"},
        format = {"pretty","html:target/CucumberSerenity/site"},
        plugin = {"json:C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\lib\\cucumberSerenity.json"},
        glue = {"C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\src\\test\\java\\steps\\wikipediaSteps\\SearchWikipediaSteps.java"}

)
public class SerentyRunning {
}
