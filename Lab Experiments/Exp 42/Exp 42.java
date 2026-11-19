package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxradioselection {

    @Test
    public void checkboxRadioSelection() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://demo.guru99.com/test/radio.html");

            WebElement checkbox = driver.findElement(By.id("vfb-6-0"));
            checkbox.click();
            Thread.sleep(3000);
            assertTrue(checkbox.isSelected());
            System.out.println("Checkbox selected successfully");

            WebElement radio = driver.findElement(By.id("vfb-7-1"));
            radio.click();
            Thread.sleep(3000);
            assertTrue(radio.isSelected());
            System.out.println("Radio button selected successfully");

        } finally {
            //driver.quit();
        }
    }
}
