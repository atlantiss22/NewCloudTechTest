package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsHhunterPage extends MainHhunterPage {

    @FindBy(xpath = "//div[@class='b-alfabeta-totals nopaddings']/strong")
    private WebElement companiesCountLabel;

    @FindBy(xpath = "//table[@class='l']//a")
    private List<WebElement> companyResults;

    @FindBy(xpath = "//table[@class='l']")
    private WebElement resultsTable;

    @FindBy(xpath = "//a[@data-qa='pager-next']")
    private WebElement nextPageButton;

    public ResultsHhunterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCompaniesCountLabel() {
        return companiesCountLabel;
    }

    public List<WebElement> getCompanyResults() {
        return companyResults;
    }

    public WebElement getResultsTable() {
        return resultsTable;
    }

    public WebElement getNextPageButton() {
        return nextPageButton;
    }
}
