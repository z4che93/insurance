package src;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public  class MortalityTable {
    private static final String FIRSTLEVEL_PATH = ".\\files\\MortalityTable_FirstLevel.xlsx";
    private static final String SECONDLEVEL_PATH = ".\\files\\MortalityTable_SecondLevel.xlsx";
    public static final List<Double> mortalityTable_FirstLevel = new ArrayList();
    public static final List<Double> mortalityTable_SecondLevel = new ArrayList();


    MortalityTable() throws IOException {
        mortalityTablesInit();
    }

    private void mortalityTablesInit() throws IOException {
        FileInputStream streamFirstLevel = new FileInputStream(FIRSTLEVEL_PATH),
                streamSecondLevel = new FileInputStream(SECONDLEVEL_PATH);
        XSSFSheet sheetFirstLevel = new XSSFWorkbook(streamFirstLevel).getSheetAt(0),
                sheetSecondLevel = new XSSFWorkbook(streamSecondLevel).getSheetAt(0);
        XSSFRow rowFirstLevel = null, rowSecondLevel = null;

        for(int r = 1;r<=sheetFirstLevel.getLastRowNum();r++){
            rowFirstLevel = sheetFirstLevel.getRow(r);
            rowSecondLevel = sheetSecondLevel.getRow(r);
            mortalityTable_FirstLevel.add(r-1,rowFirstLevel.getCell(1).getNumericCellValue());
            mortalityTable_SecondLevel.add(r-1,rowSecondLevel.getCell(1).getNumericCellValue());
        }
        streamFirstLevel.close();
        streamSecondLevel.close();
    }
}