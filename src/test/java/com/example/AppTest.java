package com.example;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testWikipediaPage() {
        //здесь нужно поменять путь к своему файлу msedgedriver.exe
        
        System.setProperty("webdriver.edge.driver", "C:\\Users\\dukue\\Downloads\\edgedriver_win64_123\\msedgedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\dukue\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");

        WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
        
        
        
        
        
        
        
        driver.manage().window().maximize();
        String wikipediaURL = "https://ru.wikipedia.org/wiki/Заглавная_страница";

        driver.get(wikipediaURL);
        String inputString = "Тес";
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Википедия"));
        driver.findElement(By.className("vector-search-box-input")).sendKeys(inputString);
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.className("suggestions-result"));
        for (int i = 0; i < 5; i++){
            WebElement Suggest = elements.get(i);
            String boldText = Suggest.findElement(By.className("highlight")).getText();

            String regularText = Suggest.getText().replace(boldText, "");
            assertTrue(Suggest.getText().contains(inputString));
            System.out.println(Suggest.getText());
            System.out.println(boldText);
            System.out.println(regularText);


            // WebElement boldTextElement = suggestion.findElement(By.className("highlight"));
            // String boldText = boldTextElement.getText();
            // String regularText = suggestion.getText().replace(boldText, "");
        }
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Закрытие браузера
        driver.quit();
    }
}
