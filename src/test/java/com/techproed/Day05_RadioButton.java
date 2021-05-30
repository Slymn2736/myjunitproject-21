package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_RadioButton {

    /*
        Complete the following task.
        Go to https://www.facebook.com/
        Click on Create an Account button
        Locate the elements of radio buttons
        Then click on the radio buttons for your gender if they are not selected
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void accountCreate(){
        //        We can chain the methods
        driver.findElement(By.partialLinkText("Create New Account")).click();
//        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
//        firstName.sendKeys("FakeName");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("FakeName");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("FakeLast");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("1234");

        //        SELECT GENDER
//        This is radio button
//        Identify the button element and click on it
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();


    }

}