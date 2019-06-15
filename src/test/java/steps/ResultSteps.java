package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class ResultSteps extends DefaultSteps {

    public void shouldSeeThisCompany(List<WebElement> elements, String name) {
        boolean contains = false;
        for (WebElement element : elements) {
            if (element.getText().trim().equals(name)) {
                contains = true;
            }
        }
        assertTrue("Должны видеть компанию", contains);
    }

    public ResultSteps(WebDriver driver) {
        super(driver);
    }
}
