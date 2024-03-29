package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DefaultSteps {

    private static final String MAIN_PAGE = "https://hh.ru/";

    private WebDriver driver;

    public DefaultSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE);
    }

    public void navigateToMainPage() {
        driver.navigate().to(MAIN_PAGE);
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void shouldBeVisible(WebElement element) {
        assertTrue("������ ������ �������", element.isDisplayed());
    }

    public void selectValueFromDropdown(List<WebElement> valuesOfSelect, String value) {
        for (WebElement item : valuesOfSelect) {
            if (item.getText().trim().equals(value)) {
                item.click();
                break;
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }
}
