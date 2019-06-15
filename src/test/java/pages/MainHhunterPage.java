package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainHhunterPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='query']")
    private WebElement searchInput;

    @FindBy(xpath = "//select[@data-qa='navi-search__select']")
    private WebElement searchTypeSelect;

    @FindBy(xpath = "//select[@data-qa='navi-search__select']//option")
    private List<WebElement> searchTypeOptions;

    @FindBy(xpath = "//form[@action='/employers_list']//button")
    private WebElement searchButton;

    public MainHhunterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchTypeSelect() {
        return searchTypeSelect;
    }

    public List<WebElement> getSearchTypeOptions() {
        return searchTypeOptions;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
