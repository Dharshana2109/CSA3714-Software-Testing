
package selenium;

import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EXP37 {

    @Test
    public void googleSearchTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com/");

            driver.findElement(By.name("q"))
                  .sendKeys("Saveetha School of Engineering" + Keys.ENTER);

            Thread.sleep(3000);

            System.out.println("Page Title: " + driver.getTitle());

            assertTrue(driver.getTitle().contains("Saveetha"));

        } finally {
            driver.quit();
        }
    }
}
