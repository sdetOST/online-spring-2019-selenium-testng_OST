package com.cybertek.tests.excel_io_day1;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadDemo {
    //to create on object that will store excel file
    Workbook workbook;
    //to create an object that will store specific sheet
    Sheet sheet;
    //to provide path to the file
    String path = "src/test/resources/Countries.xlsx";
    //to establish connection with excel file
    FileInputStream inputStream;

    @BeforeMethod
    public void setUp() throws IOException {
        inputStream = new FileInputStream(path);
        workbook = WorkbookFactory.create(inputStream);
        sheet = workbook.getSheet("Countries");
    }

    @Test
    public void readExcelFileRowAndColTest(){

    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        inputStream.close();
    }
}
