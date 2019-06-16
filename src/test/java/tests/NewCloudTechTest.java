package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.MainHhunterPage;
import pages.NewCloudTechPage;
import pages.ResultsHhunterPage;
import rules.WebDriverRule;
import steps.DefaultSteps;
import steps.NewCloudTechSteps;
import steps.ResultSteps;

import static enums.Browser.*;

public class NewCloudTechTest {

    private static WebDriverRule webDriverRule = new WebDriverRule(CHROME);

    private static DefaultSteps defaultSteps = new DefaultSteps(webDriverRule.getDriver());
    private ResultSteps resultSteps = new ResultSteps(webDriverRule.getDriver());
    private NewCloudTechSteps newCloudTechSteps = new NewCloudTechSteps(webDriverRule.getDriver());

    private MainHhunterPage onMainPage() {
        return new MainHhunterPage(webDriverRule.getDriver());
    }
    private ResultsHhunterPage onResultsPage() {
        return new ResultsHhunterPage(webDriverRule.getDriver());
    }
    private NewCloudTechPage onNewCloudTechPage() {
        return new NewCloudTechPage(webDriverRule.getDriver());
    }

    @BeforeClass
    public static void startTests() {
        defaultSteps.openMainPage();
    }

    @After
    public void afterTest() {
        defaultSteps.navigateToMainPage();
    }

    @AfterClass
    public static void closeDriver() {
        defaultSteps.closeDriver();
    }

    @Test
    public void shouldSeeNewCloudTechInResults() {
        defaultSteps.clickOn(onMainPage().getSearchTypeSelect());
        defaultSteps.selectValueFromDropdown(onMainPage().getSearchTypeOptions(), "Компании");
        defaultSteps.enterText(onMainPage().getSearchInput(), "новые облачные");
        defaultSteps.clickOn(onMainPage().getSearchButton());

        resultSteps.shouldBeVisible(onResultsPage().getResultsTable());
        resultSteps.shouldSeeThisCompany(onResultsPage().getCompanyResults(), "Новые Облачные Технологии");
    }

    @Test
    public void shouldSeeVacanciesOnThisRegion() {
        newCloudTechSteps.openNewCloudTechPage();
        newCloudTechSteps.openAllLabels(onNewCloudTechPage().getThisRegionVacancyTypes());

        newCloudTechSteps.shouldSeeNumberOfVacancies(onNewCloudTechPage().getThisRegionVacancies(), onNewCloudTechPage().getThisRegionVacancyCount());
    }

    @Test
    public void shouldSeeThisVacancy() {
        newCloudTechSteps.openNewCloudTechPage();
        newCloudTechSteps.openAllLabels(onNewCloudTechPage().getThisRegionVacancyTypes());

        newCloudTechSteps.shouldSeeThisVacancy(onNewCloudTechPage().getThisRegionVacancies(), "QA Automation Engineer");
    }
}
