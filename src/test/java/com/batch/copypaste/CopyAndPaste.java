package com.batch.copypaste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CopyAndPaste {

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

        Actions action = new Actions(driver);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Mahmudul");
        //Thread.sleep(5000);


        // select all
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        // copy
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        Thread.sleep(5000);

        //Tab
        action.sendKeys(Keys.TAB);
        action.build().perform();

        // paste
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();


    }

    @AfterSuite
    public void CloseChromeBrowser() {
        driver.close();
    }

}
