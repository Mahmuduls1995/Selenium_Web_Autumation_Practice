package com.batch.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HeadlessChromeBrowserInit {

    WebDriver driver;

    @BeforeSuite
    public void StartChromeBrowser() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }



    @Test
    public void OpenUrl() throws InterruptedException {
        driver.get("https://ssbleather.com/");
        Thread.sleep(10000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @AfterSuite
    public void CloseChromeBrowser() {
        driver.close();
    }


}
