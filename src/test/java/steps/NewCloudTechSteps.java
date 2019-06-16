package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class NewCloudTechSteps extends DefaultSteps {

    private static final String NEW_CLOUD_TECH_PAGE = "https://spb.hh.ru/employer/213397";

    public NewCloudTechSteps(WebDriver driver) {
        super(driver);
    }

    public void openNewCloudTechPage() {
        getDriver().get(NEW_CLOUD_TECH_PAGE);
    }

    public void openAllLabels(List<WebElement> labels) {
        for (WebElement element : labels) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.click();
        }
    }

    public void shouldSeeNumberOfVacancies(List<WebElement> vacancies, int number) {
        Set<String> nameOfVacancies = new HashSet<String>();

        for (WebElement element : vacancies) {
            nameOfVacancies.add(element.getText().trim());
        }

        assertEquals("Должно быть " + number + " вакансий", nameOfVacancies.size() , number);
    }

    public void shouldSeeThisVacancy (List<WebElement> vacancies, String nameOfVacancy) {
        Set<String> nameOfVacancies = new HashSet<String>();

        for (WebElement element : vacancies) {
            nameOfVacancies.add(element.getText().trim());
        }

        assertTrue("Должна присутствовать вакансия " + nameOfVacancy, nameOfVacancies.contains(nameOfVacancy));
    }

}
