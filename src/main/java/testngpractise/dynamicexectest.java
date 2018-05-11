package testngpractise;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class dynamicexectest  {

    public static void main(String args[]) throws FileNotFoundException,IOException,InvalidFormatException {
        System.out.print("execute started");

        String path = "C:\\Users\\User1\\Desktop\\AutoEnv\\runtimeexe.xlsx";
        FileInputStream fs = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fs);
        TestNG tng = new TestNG();
        List<XmlSuite> suites = new ArrayList<XmlSuite>();


        for(int i =0 ;i<wb.getNumberOfSheets();i++){
            Sheet sh = wb.getSheetAt(i);
            XmlSuite suite = new XmlSuite();
            suite.setName(sh.getSheetName());
            XmlTest test = new XmlTest(suite);
            List<XmlClass> classes = new ArrayList<XmlClass>();
            test.setName(sh.getRow(0).getCell(1).getStringCellValue());
            for (int j =2;j<=sh.getLastRowNum();j++){
                if(sh.getRow(j).getCell(1).getStringCellValue().equals("Yes")){
                    XmlClass class1 = new XmlClass(sh.getRow(j).getCell(0).getStringCellValue());
                    classes.add(class1);
                }
            }
            test.setXmlClasses(classes);
            suites.add(suite);
        }
        tng.setXmlSuites(suites);
        tng.run();



//        Sheet sh1 = wb.getSheet("suite1");
//
//        XmlSuite suite1 = new XmlSuite();
//        suite1.setName(sh1.getSheetName());
//
//        XmlTest test1 = new XmlTest(suite1);
//        test1.setName(sh1.getRow(0).getCell(1).getStringCellValue());
//
//        XmlClass class1 = new XmlClass(sh1.getRow(2).getCell(0).getStringCellValue());
//
//        List<XmlClass> classes = new ArrayList<XmlClass>();
//        classes.add(class1);
//        test1.setXmlClasses(classes);
//        TestNG tng = new TestNG();
//        List<XmlSuite> suites = new ArrayList<XmlSuite>();
//        suites.add(suite1);
//        tng.setXmlSuites(suites);
//        tng.run();

    }

}
