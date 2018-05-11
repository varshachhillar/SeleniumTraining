package dbConnection;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class checkskumap {

    public static void main(String[] args) throws FileNotFoundException,InvalidFormatException,IOException, SQLException, ClassNotFoundException {

        // create our mysql database connection
        String host = "jdbc:mysql://mysql-master.industrybuying.com/vikreta";
        String username = "readonly";
        String password = "6MYvS7wbuhznqgMq";
        String myDriver = "com.mysql.jdbc.Driver";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(host, username, password);
        String path = "C:\\Users\\User1\\Downloads\\unmapping.xls";
        String sheet = "sheet1";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet s = wb.getSheet(sheet);

        for (int i=1;i< s.getLastRowNum()+1;i++){
            String sku = s.getRow(i).getCell(1).getStringCellValue();
            s.getRow(i).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            String ven = s.getRow(i).getCell(0).getStringCellValue();
            String query = "SELECT * FROM `dealers_vendorskumap` WHERE sku = '"+sku+"' and vendor_id = '"+ven+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next() == false)
                System.out.println("SKU "+sku);
            int count = 0;
            while (rs.next()) {
                ++count;
            }
            if (count >1)
                System.out.println("vendor "+ ven+ "SKU " + sku);
        }
        System.out.println("Completed");
        conn.close();



    }

}
