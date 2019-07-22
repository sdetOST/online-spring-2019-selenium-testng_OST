package com.cybertek.tests.OfficeHours;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BriteErpTests {

    WebDriver driver = Driver.getDriver();

    @BeforeMethod
    public void setup(){
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213");
    }




    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }




}
