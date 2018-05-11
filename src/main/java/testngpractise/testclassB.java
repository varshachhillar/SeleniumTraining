package testngpractise;

import org.testng.annotations.*;

public class testclassB  extends testclassA{


    @BeforeSuite
    public  void BeforeSuiteB(){
        System.out.println("BeforeSuiteB");
    }
    @BeforeTest
    public  void BeforeTestB(){
        System.out.println("BeforeTestB");
    }
    @BeforeMethod
    public  void BeforeMethodB(){
        System.out.println("BeforeMethodB");
    }
    @BeforeClass
    public  void BeforeClassB(){
        System.out.println("BeforeClassB");
    }
    @BeforeGroups
    public  void BeforeGroupsB(){
        System.out.println("BeforeGroupsB");
    }

    @AfterMethod
    public  void AfterMethodB(){
        System.out.println("AfterMethodB");
    }
    @AfterTest
    public  void AfterTestB(){
        System.out.println("AfterTestB");
    }
    @AfterGroups
    public  void AfterGroupsB(){
        System.out.println("AfterGroupsB");
    }
    @AfterSuite
    public  void AfterSuiteB(){
        System.out.println("AfterSuiteB");
    }
    @AfterClass
    public  void AfterClassB(){
        System.out.println("AfterClassB");
    }

    @Test
    public void testB(){
        System.out.println("testB");
    }

}
