package com.cybertek.tests.day15_review;

import com.cybertek.pages.vytrack.CalendarEventsPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import com.cybertek.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends TestBase {
    //BeforeMethod is coming from TestBase
    CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions(){
        //we are reading username from .properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        //we are reading password from .properties file
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        VYTrackUtils.login(driver, username, password); //login

       //go to Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");

       driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
       driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

       List<String> expectedOptions = Arrays.asList("Daily", "Weekly","Monthly");
       List<String> actualOptions = calendarPage.getRepeatOptions();

       Assert.assertTrue(actualOptions.contains(expectedOptions));
    }

    //AfterMethod id coming from TestBase
}
