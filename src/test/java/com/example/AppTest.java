package com.example;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    public WebDriver initDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\dukue\\Downloads\\edgedriver_win64_123\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        
        driver.manage().window().maximize();
        String wikipediaURL = "https://ru.wikipedia.org/wiki/Заглавная_страница";
        driver.get(wikipediaURL);
        return driver;
    }


    @Test
    public void testWikipediaPage_1() {
        
        WebDriver driver = initDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String inputString = "Тесл"; // вводимый текст
        
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("vector-search-box-input")));
        inputField.sendKeys(inputString);
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("suggestions-result")));

        for (int i = 0; i < 5; i++){
            WebElement Suggest = elements.get(i);
            String boldText = Suggest.findElement(By.className("highlight")).getText();
            System.out.println(Suggest.getText());
            System.out.println(boldText);
            System.out.println(inputString);
            assertTrue(Suggest.getText().contains(inputString)); // проверка, что в выданных запросах присутствует введённый текст
            assertTrue(boldText == inputString); // проверка что введённый текст - жирный
        }
        driver.quit();
    }

    @Test
    public void testWikipediaPage_2() {
        WebDriver driver = initDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String inputString = "Тесл"; // вводимый текст
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("vector-search-box-input")));
        inputField.sendKeys(inputString);
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("suggestions-result")));
        WebElement el = elements.get(0);
        String text = el.getText();
        elements.get(0).click();
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mw-page-title-main")));
        assertTrue(text == title.getText());

    }

}

