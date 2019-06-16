package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewCloudTechPage extends MainHhunterPage{

    @FindBy(xpath = "//h4/span[contains(text(), 'в текущем')]")
    private WebElement thisRegionLabel;

    @FindBy(xpath = "//h4/span[contains(text(), 'в текущем')]/following-sibling::span")
    private WebElement thisRegionVacancyCount;

    @FindBy(xpath = "//h4/span[contains(text(), 'в других')]")
    private WebElement otherRegionLabel;

    @FindBy(xpath = "//h4/span[contains(text(), 'в других')]/following-sibling::span")
    private WebElement otherRegionVacancyCount;

    @FindBy(xpath = "//div[@class='b-employerpage-vacancies g-expand']//span[@data-qa='vacancies-group-title-link']")
    private List<WebElement> thisRegionVacancyTypes;

    @FindBy(xpath = "//a[@data-qa='vacancy-serp__vacancy-title']")
    private List<WebElement> thisRegionVacancies;

    public NewCloudTechPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getThisRegionLabel() {
        return thisRegionLabel;
    }

    public int getThisRegionVacancyCount() {
        return Integer.parseInt(thisRegionVacancyCount.getText().trim());
    }

    public WebElement getOtherRegionLabel() {
        return otherRegionLabel;
    }

    public int getOtherRegionVacancyCount() {
        return Integer.parseInt(otherRegionVacancyCount.getText().trim());
    }

    public List<WebElement> getThisRegionVacancyTypes() {
        return thisRegionVacancyTypes;
    }

    public List<WebElement> getThisRegionVacancies() {
        return thisRegionVacancies;
    }
}
