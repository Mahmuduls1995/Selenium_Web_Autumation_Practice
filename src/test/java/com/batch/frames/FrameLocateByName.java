package com.batch.frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FrameLocateByName {

    WebDriver driver;

    @BeforeSuite
    public void StartChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void OpenUrl() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php");
        Thread.sleep(5000);
        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.xpath("//h1[contains(text(), 'Selenium - Automation Practice Form')]"));
        System.out.println(element.getText());
        Thread.sleep(3000);

    }

    @AfterSuite
    public void CloseChromeBrowser() {
        driver.close();
    }

}
