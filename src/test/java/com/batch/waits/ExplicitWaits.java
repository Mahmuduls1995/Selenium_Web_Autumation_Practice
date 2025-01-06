package com.batch.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaits {

    WebDriver driver;

    @BeforeSuite
    public void StartChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void OpenUrl() throws InterruptedException {
       driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = wait.until(driver -> driver.findElement(By.xpath("//label[contains(text(),'sadjfsadfsadkfj")));

        System.out.println("Element found: " + element.getText());


    }

    @AfterSuite
    public void CloseChromeBrowser() {
        driver.close();
    }

}
