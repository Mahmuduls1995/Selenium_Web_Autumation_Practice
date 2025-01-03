package com.batch.locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LocateById {

    WebDriver driver;

    @BeforeSuite
    public void StartChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void OpenUrl() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(5000);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Sheikh Mahmudul");
        Thread.sleep(5000);



    }

    @AfterSuite
    public void CloseChromeBrowser() {
        driver.close();
    }

}
