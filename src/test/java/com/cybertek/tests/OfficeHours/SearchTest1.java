package com.cybertek.tests.OfficeHours;


import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest1 {


    WebDriver driver;
    String searchQueryLocator="#search-input";                 // css
    String searchButtonLocator="#search-button";               //css
    String ResultsLocator="#search-results>li";                //css
    String blankSearchResultLocator="#search-results>div";     //css
    String noResultLocator="#error-no-results";                //css

//    WebElement searchQuery = driver.findElement(By.cssSelector(searchQueryLocator));
//    WebElement searchButton = driver.findElement(By.cssSelector(searchButtonLocator));
//    WebElement Results = driver.findElement(By.cssSelector(ResultsLocator));
//    WebElement blankSearchResult = driver.findElement(By.cssSelector(blankSearchResultLocator));
//    WebElement noResult = driver.findElement(By.cssSelector(noResultLocator));

    @BeforeClass
    public void setup() {
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html");

    }
    @Test
    public void searchTest1() {
        System.out.println("Verify serch query and search button ids");
        WebElement searchQuery = driver.findElement(By.cssSelector(searchQueryLocator));
        WebElement searchButton = driver.findElement(By.cssSelector(searchButtonLocator));
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(searchQuery.getAttribute("id"), "search-input");
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(searchButton.getAttribute("id"), "search-button");

        System.out.println("Verified that the search query id is: " + searchQuery.getAttribute("id"));
        System.out.println("Verified that the search button id is: " + searchButton.getAttribute("id"));

    }
    @Test
    public void searchTest2() {
        System.out.println("Verify that if emty serch query is forbidden");
        WebElement searchQuery = driver.findElement(By.cssSelector(searchQueryLocator));
        WebElement searchButton = driver.findElement(By.cssSelector(searchButtonLocator));
        SeleniumUtils.waitPlease(2);
        searchQuery.clear();
        searchButton.click();
        SeleniumUtils.waitPlease(2);
        WebElement blankSearchResult = driver.findElement(By.cssSelector(blankSearchResultLocator));
        Assert.assertEquals(blankSearchResult.getAttribute("id"), "error-empty-query");
        System.out.println("Verified that the blank search result id is: " + blankSearchResult.getAttribute("id"));

    }

    @Test
    public void searchTest3() {
        System.out.println("Check if at list one result is returned after querying for \"isla\"");
        WebElement searchQuery = driver.findElement(By.cssSelector(searchQueryLocator));
        WebElement searchButton = driver.findElement(By.cssSelector(searchButtonLocator));
        searchQuery.sendKeys("isla");
        searchButton.click();
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(getSearchResults().size()>0);
        System.out.println("Verified that at list one  result returned after search for 'isla': " + getSearchResults().size());
        System.out.println("The search results are: "+getSearchResults());
    }

    @Test
    public void searchTest4() {
        System.out.println("Check if user gets feedback if there are no result");
        WebElement searchQuery = driver.findElement(By.cssSelector(searchQueryLocator));
        WebElement searchButton = driver.findElement(By.cssSelector(searchButtonLocator));
        WebElement noResult = driver.findElement(By.cssSelector(noResultLocator));
        searchQuery.sendKeys("abcde");
        searchButton.click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(noResult.getAttribute("id"), "error-no-results");
        System.out.println("Verified that the blank search result id is: " + noResult.getAttribute("id"));

    }
    @Test
    public void searchTest5() {
        System.out.println("Check if the results match the query");
        WebElement searchQuery = driver.findElement(By.cssSelector(searchQueryLocator));
        WebElement searchButton = driver.findElement(By.cssSelector(searchButtonLocator));
        WebElement Results = driver.findElement(By.cssSelector(ResultsLocator));
        searchQuery.sendKeys("Port Royal");
        searchButton.click();
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(getSearchResults().size()==1);
        System.out.println("Verified that the query for \"Port Royal\" is: " + Results.getText() );

    }

    @AfterClass
    public void teardown() {
        driver.close();
    }


//------------------------------------------



    public static List<String> getSearchResults() {
        List<WebElement> lst=Driver.getDriver().findElements(By.cssSelector("#search-results>li"));
        List<String> list=new ArrayList<>();
        for (WebElement results : lst) {
            String value=results.getText();
            list.add(value);
        }
        return list;
    }

}
