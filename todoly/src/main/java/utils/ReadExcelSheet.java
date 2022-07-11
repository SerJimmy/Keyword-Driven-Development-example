package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcelSheet {
    private String excelFileName;

    public ReadExcelSheet(String excelFileName) {
        this.excelFileName = excelFileName;
    }
    public ArrayList readExcelData(int colNo, String sheetTest) {

        String filePath = "\\src\\main\\java\\resources\\" + excelFileName;
        File file = new File(System.getProperty("user.dir") + filePath);
        ArrayList ar = new ArrayList();

        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetTest);
            Iterator row = sheet.rowIterator();
            row.next();

            while (row.hasNext()) {
                Row r = (Row) row.next();
                Cell c = r.getCell(colNo);
                String data = c.getStringCellValue();
                ar.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ar;
    }
}
