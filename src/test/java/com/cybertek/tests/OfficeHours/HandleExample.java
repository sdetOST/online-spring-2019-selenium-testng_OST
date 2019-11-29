package com.cybertek.tests.OfficeHours;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class HandleExample {

    WebDriver driver;

    @BeforeClass
    public void XX() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void setup() {
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");

    }
    @Test
    public void handleWindows() {

// Store and Print the name of the First window on the console
        String handle= driver.getWindowHandle();
        System.out.println(handle);

// Click on the Button "New Message Window"
 //       driver.findElement(By.name("New Message Window")).click();

// Store and Print the name of all the windows open
        Set handles = driver.getWindowHandles();
        System.out.println(handles);

// Pass a window handle to the other window

        for (String handle1 : driver.getWindowHandles()) {
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }

    }


    @Test(priority=2, description="xxx" )
    public void Test2() {

        assertFalse(driver.getTitle().contains("Google"));
        assertFalse(driver.getCurrentUrl().equals("www.google.com"));

        System.out.println("Test 2 completed");


    }


    @Test(description="Verify all drop down boxes working properly")
    public void Test3() {

        /*
        //select[@class='_5dba']
         */

        List<WebElement> list=driver.findElements(By.xpath("//select[@class='_5dba']"));
        // to verify all drop down boxes are enabled
        for (WebElement each : list) {
            assertTrue(each.isEnabled());
            library.sleep(1);
        }


        WebElement MonthDropDownBox=list.get(0);
        Select Month=new Select(MonthDropDownBox);
        // select class is used for hadling drop down boxes with tagname of select

        List<WebElement> Months=Month.getOptions();
        WebElement July=null;
        // verify that July is selected by default
        for (WebElement each : Months) {
            if (each.getText().equals("Jul")) {
                July=each;
                break;
            }
        }
        library.sleep(2.5);

        assertTrue(July.isSelected());

        library.sleep(3);

        // select by visible text:
        Month.selectByVisibleText("Oct");
        library.sleep(3);

        // select by index:
        Month.selectByIndex(3);
        library.sleep(3);

        // select By value:
        Month.selectByValue("9");


        System.out.println("Test 3 completed");

    }


    @AfterMethod
    public void teardown() {
        SeleniumUtils.waitPlease(1);
        driver.close();
        SeleniumUtils.waitPlease(1);
        driver.quit();
    }

}
