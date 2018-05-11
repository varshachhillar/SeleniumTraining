package dbConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DBConnectionTest {

	public static void main(String[] args) throws FileNotFoundException,InvalidFormatException,IOException, SQLException, ClassNotFoundException {

		// create our mysql database connection
		String host = "jdbc:mysql://mysql-master.industrybuying.com/emtex";
		String username = "readonly";
		String password = "6MYvS7wbuhznqgMq";
		String myDriver = "com.mysql.jdbc.Driver";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(host, username, password);
		String path = "C:\\Users\\User1\\Downloads\\Hot1.xls";
		String sheet = "Sheet1";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);

		for (int i=1;i< s.getLastRowNum()+1;i++){
			String sku = s.getRow(i).getCell(0).getStringCellValue();
			String query = "SELECT * FROM `catalog_sellerratechart` WHERE sku = '"+sku+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next() == false)
				System.out.println(sku);

//			while (rs.next()) {
//				String uname = rs.getString("sku");
//				System.out.print(uname);
//			}

		}
		System.out.println("Completed");
		conn.close();

//		// open new tab
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.get("http://seller.qa4.industrybuying.com");
//		String selectAll = Keys.chord(Keys.SHIFT,Keys.RETURN);
//		driver.findElement(By.linkText("linkname")).sendKeys(selectAll);


	}

}
