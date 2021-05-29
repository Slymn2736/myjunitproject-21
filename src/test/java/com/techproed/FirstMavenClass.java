package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        // NOTE: We no longer use Syste.setProperties for calling the driver
        //Step 1:
        WebDriverManager.chromedriver().setup();

        //Step 2
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();


    }

}
