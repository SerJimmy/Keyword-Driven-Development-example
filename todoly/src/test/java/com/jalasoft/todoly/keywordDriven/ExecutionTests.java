package com.jalasoft.todoly.keywordDriven;

import org.testng.annotations.Test;
import utils.ReadExcelSheet;

import java.util.ArrayList;
import java.util.Map;

public class ExecutionTests {
    public final static ReadExcelSheet rs = new ReadExcelSheet("GetAllProjectsTests.xlsx");

    @Test
    public void getAllProjectsTest() {
        ActionKeywords ak = new ActionKeywords();
        Map<String, Runnable> mapToExec = ak.createFunctionMap();
        ArrayList<String> data = rs.readExcelData(4, "TC_01");
        for (String keyWord : data) {
            mapToExec.get(keyWord).run();
        }
    }
}
