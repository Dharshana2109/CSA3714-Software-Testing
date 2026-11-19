
package selenium;

import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EXP36 {

    @Test
    public void verifyTitle() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com/");

            String title = driver.getTitle();

            System.out.println("Website Title: " + title);

            assertTrue(title.length() > 0);

        } finally {
            driver.quit();
        }
    }
}
