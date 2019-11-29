package com.cybertek.tests.OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.io.File;


public class ChromeOptionsExample {
/*
    Chrome Options : Customize and configure ChromeDriver sesion
*/

    @Test
    public void chromeOptionsDemo1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("test-type");
        options.addArguments("allow-running-insecure-content");
        options.addArguments("disable-extentions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");

// for headless mode
        options.addArguments("--headless");
        options.addArguments("disable-gbu");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://google.com");

    }

    @Test
    public void chromeOptionsDemo2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\ostur\\AppData\\Local\\app"));  // could not enter correct path
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://google.com");

    }



}
