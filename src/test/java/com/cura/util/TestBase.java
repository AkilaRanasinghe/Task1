package com.cura.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    public static SoftAssert softAssert;

    public static Object[][] addDataToHashmap(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        wb.close();
        int lastRowNum = sheet.getLastRowNum() ;
        int lastColNum = sheet.getRow(0).getLastCellNum();
        Object[][] obj = new Object[lastRowNum][1];
        for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> datamap = new HashMap<>();
            for (int j = 0; j < lastColNum; j++) {
                try {
                    datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
                } catch (Exception exception) {
                    System.out.println("Exception : " + exception);
                }
            }
            obj[i][0] = datamap;
        }
        return  obj;
    }
}
