package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainHhunterPage;
import pages.ResultsHhunterPage;
import rules.WebDriverRule;
import steps.DefaultSteps;
import steps.ResultSteps;

import static enums.Browser.*;

public class NewCloudTechTest {

    private static WebDriverRule webDriverRule = new WebDriverRule(CHROME);
    private static DefaultSteps defaultSteps = new DefaultSteps(webDriverRule.getDriver());
    private static ResultSteps resultSteps = new ResultSteps(webDriverRule.getDriver());

    private WebDriverWait wait = new WebDriverWait(webDriverRule.getDriver(), 20);

    private MainHhunterPage onMainPage() {
        return new MainHhunterPage(webDriverRule.getDriver());
    }

    private ResultsHhunterPage onResultsPage() {
        return new ResultsHhunterPage(webDriverRule.getDriver());
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
}
