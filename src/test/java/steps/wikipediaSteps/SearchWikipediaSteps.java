package steps.wikipediaSteps;


import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;


public class SearchWikipediaSteps {

    private WebDriver driver = new ChromeDriver();

    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver", "D:\\Testing Systems\\Java-Testing-Projects\\Libraries\\chromedriver\\chromedriver.exe");
        driver.navigate().to("http://en.wikipedia.org");
    }

    @After
    public void after () {
        driver.quit();
    }

    @Given("^Enter search term '(.*?)'$")
    public void searchFor (String searchTerm) {
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys(searchTerm);
    }

    @After
    public void tearDown (Scenario scenario) {
        getScreenShotFile();

        if (scenario.getStatus().equalsIgnoreCase("failed")) {
            try {
                File scrFile = getScreenShotFile();
                byte[] data = FileUtils.readFileToByteArray(scrFile);
                scenario.embed(data, "image/png");
                scenario.write("Failed Test");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
@AfterClass
    private File getScreenShotFile () {
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
        return reportOutputDirectory;
    }



    @When("^Do search$")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
    }

    @Then("^Single result is shown for '(.*?)'$")
    public void assertSingleResult(String searchResult) {
        WebElement results = driver
                .findElement(By.cssSelector("div#mw-content-text.mw-content-ltr p"));
        assertFalse(results.getText().contains(searchResult + " may refer to:"));
        assertTrue(results.getText().startsWith(searchResult));
    }


    @Then("^Multiple results are shown for '(.*?)'$")
    public void multipleResultsAreShownForResult (String[] searchResultants) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement resultant = (WebElement) driver.findElements(By.cssSelector("div#mw-content-text.mw-content-ltr p"));
        assertFalse(resultant.getText().contains(searchResultants + "May Contain:"));
        assertTrue(resultant.getText().startsWith(searchResultants.toString()));
    }

    @When("^I enter text into the search field'(.*?)'$")
    public void iEnterTextIntoTheSearchField (String searchTerm) throws Throwable {
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys(searchTerm);
    }
}