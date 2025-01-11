package com.batch.windowtab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchToTab {

    WebDriver driver;

    @BeforeSuite
    public void StartChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(priority = 0)
    public void OpenUrl() throws InterruptedException {
        driver.get("https://ssbleather.com/");
        Thread.sleep(10000);

    }
    @Test(priority = 1)
    public void countTabNumber() throws InterruptedException {
        String parentTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        String childTab = driver.getWindowHandle();
        driver.switchTo().window(childTab);

        driver.navigate().to("https://www.skmbd.com");
        Thread.sleep(5000);
        driver.switchTo().window(parentTab);


    }



    @AfterSuite
    public void CloseChromeBrowser() {
        driver.close();
    }

}
