package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SignInHomework {
    /*
        1. Create a class SignInHomework
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. Go to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
    }
    @Test
    public void createAccount() throws InterruptedException {
        Faker faker = new Faker();
//3. Click on sign in button
        driver.findElement(By.xpath("//*[@class='login']")).click();
//4.Send your email and click on create an account button
        driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
//5.Verify the Text : CREATE AN ACCOUNT
        WebElement createAcc = driver.findElement(By.className("page-heading"));
        Assert.assertTrue(createAcc.isDisplayed());
 // 6. Verify the Text : YOUR PERSONAL INFORMATION
        WebElement yourPersonalInfo = driver.findElement(By.className("page-subheading"));
        Assert.assertTrue(yourPersonalInfo.isDisplayed());
//7. Verify the Text : Title
        WebElement title = driver.findElement(By.xpath("(//*[@class='clearfix'])[2]"));
        Assert.assertTrue(title.isDisplayed());
            Thread.sleep(3000);
//        8. Select your title
        WebElement maleGender = driver.findElement(By.xpath("(//input[@name='id_gender'])[1]"));
        if(!maleGender.isSelected()){
            maleGender.click();
        }
//        9. Enter your first name
        driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys(faker.name().firstName());
//        10. Enter your last name
        driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys(faker.name().lastName());
//        11. Enter your email (It is automatically displayed)
        Thread.sleep(3000);
//        12. Enter your password
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(faker.internet().password());Thread.sleep(3000);
//        13. Enter your birthday
        WebElement dayElement = driver.findElement(By.id("days"));
        Select day = new Select(dayElement);
        day.selectByValue("25");

        WebElement monthElement = driver.findElement(By.id("months"));
        Select month = new Select(monthElement);
        month.selectByValue("11");

        WebElement yearElement = driver.findElement(By.id("years"));
        Select year = new Select(yearElement);
        year.selectByValue("1990");
//        14. Click on Sign up for our newsletter!
        WebElement newsletter=driver.findElement(By.xpath("//input[@id='newsletter']"));
        newsletter.click();

        WebElement option=driver.findElement(By.xpath("//input[@id='optin']"));
        option.click();

        Thread.sleep(3000);

//       Verify YOUR ADDRESS
        WebElement yourAddress = driver.findElement(By.xpath("(//h3[@class='page-subheading'])[2]"));
        Assert.assertTrue(yourAddress.isDisplayed());
//        15. Enter your first name
       // driver.findElement(By.id("firstName")).sendKeys(faker.name().firstName());
//        16. Enter your last lane
       // driver.findElement(By.id("lastName")).sendKeys(faker.name().lastName());
//        17. Enter your company
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
//        18. Enter your Address
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("address2")).sendKeys(faker.address().fullAddress());

        Thread.sleep(3000);

//        19. Enter your City
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
//        20. Select State
        WebElement stateElement = driver.findElement(By.id("id_state"));
        Select state = new Select(stateElement);
        state.selectByValue("5");
//        21. Enter Postal Code
        driver.findElement(By.id("postcode")).sendKeys(faker.address().zipCode());
//        22.Select Country
        WebElement countryElement = driver.findElement(By.id("id_country"));
        Select country = new Select(countryElement);
        country.selectByValue("21");
//        23. Enter additional information
        driver.findElement(By.id("other")).sendKeys("Other Information");

        Thread.sleep(3000);

//        24. Enter home phone
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().phoneNumber());
//        25. Enter mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
//        26. Enter reference name
        driver.findElement(By.id("alias")).sendKeys(faker.address().fullAddress());
//        27. Click Register
        driver.findElement(By.id("submitAccount")).click();
//        28. Then verify the error message CONTAINS ‘error’
        WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
       System.out.println(alert.getText());
       Assert.assertTrue(alert.getText().contains("error"));

        Thread.sleep(3000);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
