import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebFormAutomation2 {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void guestRegistrationForm() throws InterruptedException {

        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");

        driver.findElement(By.id("first_name")).sendKeys("Raima Haque");
        driver.findElement(By.id("last_name")).sendKeys("Mina");
        driver.findElement(By.id("user_email")).sendKeys("raima35@gmail.com");
        List<WebElement> genderSelect = driver.findElements(By.cssSelector("[type=radio]"));
        genderSelect.get(1).click();
        driver.findElement(By.id("user_pass")).sendKeys("?ABcd_123!");


        WebElement dobField = driver.findElement(By.xpath("//input[@data-label='Date of Birth']"));
        dobField.click();
        Thread.sleep(1000);

        WebElement yearInput = driver.findElement(By.xpath("//input[contains(@class, 'numInput cur-year')]"));
        int currentYear = Integer.parseInt(yearInput.getAttribute("value"));
        while (currentYear > 2001) {
            WebElement arrowDown = driver.findElement(By.xpath("//span[contains(@class, 'flatpickr-prev-month')]"));
            arrowDown.click();
            currentYear = Integer.parseInt(yearInput.getAttribute("value"));
        }

        WebElement monthDropdown = driver.findElement(By.xpath("//select[contains(@class, 'flatpickr-monthDropdown-months')]"));
        monthDropdown.click();
        monthDropdown.findElement(By.xpath("//option[@value='7']")).click();

        WebElement birthDay = driver.findElement(By.xpath("//span[contains(@class, 'flatpickr-day') and text()='26']"));
        birthDay.click();

        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");

        List<WebElement> phoneElement = driver.findElements(By.cssSelector("[type=text]"));
        phoneElement.get(4).sendKeys("01635786534");
        phoneElement.get(5).sendKeys("01635784569");


        WebElement arrivalField = driver.findElement(By.xpath("//input[@data-label='Date of Arrival']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='2024-10-14';", arrivalField);  // Setting the date to '26th September 2024'

        driver.findElement(By.id("number_box_1665629930")).sendKeys("5");

        Select selectCountry = new Select(driver.findElement(By.id("country_1665629257")));
        selectCountry.selectByValue("BD");

        List<WebElement> room_bed = driver.findElements(By.cssSelector("[type=text]"));
        room_bed.get(9).sendKeys("Room: 404 & Bed: 8");

        driver.findElement(By.id("textarea_1665630078")).sendKeys("Software Engineer at ABC Company, Dhaka");

        List<WebElement> relatedOption = driver.findElements(By.cssSelector("[type=radio]"));
        relatedOption.get(3).click();
        relatedOption.get(5).click();
        relatedOption.get(8).click();

        Select selectActivities = new Select(driver.findElement(By.id("select_1665628361")));
        selectActivities.selectByValue("Town Hall");

        driver.findElement(By.id("privacy_policy_1665633140")).click();


        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        JavascriptExecutor newjs = (JavascriptExecutor) driver;
        newjs.executeScript("arguments[0].click();", submitButton);

        String textActual = driver.findElement(By.className("user-registration-message")).getText();
        String textExpected = "User successfully registered.";
        System.out.println(textActual);
        Assertions.assertEquals(textExpected,textActual);


    }
}
