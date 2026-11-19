package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

    @Test
    public void dropdownTest() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");

            driver.switchTo().frame("iframeResult");

            WebElement dropdown = driver.findElement(By.name("cars"));

            Select select = new Select(dropdown);

            select.selectByVisibleText("Saab");

            String selected = select.getFirstSelectedOption().getText();

            assertEquals("Saab", selected);

            System.out.println("Selected option: " + selected);

        } finally {
            driver.quit();
        }
    }
}
