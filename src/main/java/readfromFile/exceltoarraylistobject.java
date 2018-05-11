package readfromFile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class exceltoarraylistobject {
    public static ArrayList<Object[]> egetdata() throws FileNotFoundException,InvalidFormatException,IOException{
        ArrayList<Object[]> Aob = new ArrayList<Object[]>();
        String path = "C:\\Users\\User1\\Desktop\\QA Task.xlsx";
        String sheet = "sheet2";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet s = wb.getSheet(sheet);

        for (int i=1;i< s.getLastRowNum()+1;i++){
            String name = s.getRow(i).getCell(0).getStringCellValue();
            String place = s.getRow(i).getCell(1).getStringCellValue();
            Object[] data = {name,place};
            Aob.add(data);
        }
        return Aob;


    }
}
