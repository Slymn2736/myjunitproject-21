package com.techproed;

    /*
        Create test method and complete the following task.
        Go to https://the-internet.herokuapp.com/checkboxes
        Locate the elements of checkboxes
        Then click on checkbox1 if box is not selected
        Then click on checkbox2 if box is not selected
        Homework: Then verify that checkbox1 is checked.
     */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_CheckBox {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }
    @Test
    public void checkBox(){
        WebElement checkbox1 =driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        //Then click on checkbox1 if box is not selected
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }

        WebElement checkbox2 =driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //Then click on checkbox2 if box is not selected
        if(!checkbox2.isSelected()){  //!checkbox2.isSelected() = false
            checkbox2.click();
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }




}
