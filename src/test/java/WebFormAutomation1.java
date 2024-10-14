import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utils;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class WebFormAutomation1 {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void formAutomation() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");

        driver.findElement(By.id("edit-name")).sendKeys("Efter Jahan");

        driver.findElement(By.id("edit-number")).sendKeys("1568794850");

        WebElement txtCalendarElem= driver.findElement(By.id("edit-date"));
        txtCalendarElem.sendKeys("10/12/2024");

        driver.findElement(By.id("edit-email")).sendKeys("efter45@gmail.com");

        //Utils.scroll(driver,700);

        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I am Ema.");

        String relativePath="\\src\\test\\resources\\img.png";
        String absolutePath=System.getProperty("user.dir")+relativePath;
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(absolutePath);

        Utils.scroll(driver,700);
        Thread.sleep(1000);

        driver.findElement(By.id("edit-age")).click();
        //Thread.sleep(1000);

        //Utils.scroll(driver,500);
        Thread.sleep(2000);
        driver.findElement(By.id("edit-submit")).click();
        //Thread.sleep(2000);

        String textActual= driver.findElement(By.tagName("h1")).getText();
        String textExpected="Thank you for your submission!";
        Assertions.assertTrue(textActual.contains(textExpected));

    }
    @AfterAll
    public void finishTest(){
        driver.quit();
    }
}
