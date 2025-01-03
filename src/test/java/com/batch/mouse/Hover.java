package com.batch.mouse;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Hover {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://ssbleather.com/");
        Thread.sleep(5000);



        WebElement element = driver.findElement(By.xpath("//header/section[@id='brxe-flmqos']/div[@id='brxe-yqtfhp']/div[@id='brxe-88a8e8']/nav[1]/ul[1]/li[1]/div[1]/a[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);

        WebElement shoes = driver.findElement(By.xpath("//header/section[@id='brxe-flmqos']/div[@id='brxe-yqtfhp']/div[@id='brxe-88a8e8']/nav[1]/ul[1]/li[1]/div[2]/section[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[4]/a[1]"));
        shoes.click();
        Thread.sleep(5000);

    }

    @AfterSuite
    public void closeChromeBrowser() {
        driver.quit();
    }


}
