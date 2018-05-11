package readfromFile;

 import org.apache.poi.ss.usermodel.*;

 import java.io.FileInputStream;
import java.io.IOException;
 import java.util.Iterator;

public class Excelread {
    public  static void main(String[] args) {
        try{
            String path = "C:\\Users\\User1\\Desktop\\QA Task.xlsx";
            String sheet = "sheet2";
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheet);
            String value = s.getRow(1).getCell(0).getStringCellValue();
            System.out.println(value);

            //Get row count
            int rowcount = s.getLastRowNum();
            System.out.println(rowcount);

            //Iterate through sheet
            Row onerow;
            Cell onece;
            Iterator<Row>  rw = s.iterator();
            while (rw.hasNext()){
                onerow = rw.next();
                Iterator<Cell> ce = onerow.cellIterator();
                while (ce.hasNext()){
                    onece = ce.next();
                    onece.setCellType(Cell.CELL_TYPE_STRING);
                    System.out.println(onece.getStringCellValue());
                }
            }



        }catch (Exception e){
            System.out.println("Exception "+ e.getMessage());

    }
    }
}
