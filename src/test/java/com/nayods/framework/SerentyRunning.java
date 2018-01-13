package com.nayods.framework;


import cucumber.api.CucumberOptions;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = {"src/test/resources/features/wikipediaFeatures/searchWikipedia.feature"},
        format = {"pretty","html:target/CucumberSerenity/site"},
        plugin = {"json:C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\lib\\cucumberSerenity.json"},
        glue = {"C:\\Users\\Nayods\\eclipse-workspace\\Excallibium\\src\\test\\java\\steps\\wikipediaSteps\\SearchWikipediaSteps.java"}

)
public class SerentyRunning {

    @AfterClass
    public static void generateReport(){
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("cucumber-report-1.json");
        jsonFiles.add("cucumber-report-2.json");

        String buildNumber = "1";
        String projectName = "Reusable Framework With Cucumber";
        boolean runWithJenkins = true;
        boolean parallelTesting = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Browser", "chrome");
        configuration.addClassifications("Branch", "release/1.0");

// optionally add metadata presented on main page via properties file
        java.util.List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add("properties-1.properties");
        classificationFiles.add("properties-2.properties");
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
        result.getStatus();
// and here validate 'result' to decide what to do
// if report has failed features, undefined steps etc

    }
}
