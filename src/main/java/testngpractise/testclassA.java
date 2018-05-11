package testngpractise;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.*;

import java.io.IOException;

public class testclassA {

    @BeforeSuite
    public  void BeforeSuiteA() throws IOException,InvalidFormatException{
        System.out.println("BeforeSuiteA");
    }
    @BeforeTest
    public  void BeforeTestA(){
        System.out.println("BeforeTestA");
    }
    @BeforeMethod
    public  void BeforeMethodA(){
        System.out.println("BeforeMethodA");
    }
    @BeforeClass
    public  void BeforeClassA(){
        System.out.println("BeforeClassA");
    }
    @BeforeGroups
    public  void BeforeGroupsA(){
        System.out.println("BeforeGroupsA");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }


    @AfterMethod
    public  void AfterMethodA(){
        System.out.println("AfterMethodA");
    }
    @AfterTest
    public  void AfterTestA(){
        System.out.println("AfterTestA");
    }
    @AfterGroups
    public  void AfterGroupsA(){
        System.out.println("AfterGroupsA");
    }
    @AfterSuite
    public  void AfterSuiteA(){
        System.out.println("AfterSuiteA");
    }
    @AfterClass
    public  void AfterClassA(){
        System.out.println("AfterClassA");
    }

}
