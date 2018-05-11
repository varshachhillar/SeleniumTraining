package testngpractise;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.*;
import readfromFile.exceltoarraylistobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



public class TestNGBasic {

    @DataProvider
    public Iterator<Object[]> getdata() throws InvalidFormatException,IOException{
        ArrayList<Object[]> testdata = exceltoarraylistobject.egetdata();
        return testdata.iterator();
    }

//    @BeforeClass
//    public void launchbrowser()
//    {
//        System.out.println("BeforeClass");
//    }
//    @BeforeMethod
//    public void launchbrowser1()
//    {
//        System.out.println("BeforeMethod");
//    }
//    @BeforeSuite
//    public void launchbrowser3()
//    {
//        System.out.println("BeforeSuite");
//    }
//    @BeforeGroups
//    public void launchbrowser4() { System.out.println("BeforeGroups"); }
//    @BeforeTest
//    public void launchbrowser5()
//    {
//        System.out.println("BeforeTest");
//    }

//    @Test (priority = -2, dataProvider = "getdata")
//    public void launchbrowser7(String name, String place)
//    {
//        System.out.println("Test -2");
//        System.out.println(name);
//        System.out.println(place);
//    }
//    @Test(priority = 1, groups ="my")
//    @Parameters({"demo1","demo2"})
//    public void launchbrowser13(String demo1, String demo2)
//    {
//        System.out.println("Test 1");
//        System.out.println(demo1);
//        System.out.println(demo2);
//
//    }
//    @Test(priority = 1, retryAnalyzer = fixedretry.class )
//    public void launchbrowser8()
//    {
//        System.out.println("Test 1");
//        Assert.assertEquals(false,true);
//    }
    @Test
    public void launchbrowser14()
    {
        System.out.println("Test ");
        Assert.assertEquals(false,true);

    }
    @Test
    public void launchbrowser714()
    {
        System.out.println("Test ");
        Assert.assertEquals(true,true);

    }
//
//    @AfterClass
//    public void launchbAfterClassrowser()
//    {
//        System.out.println("AfterClass");
//    }
//    @AfterGroups
//    public void launchAfterGroupsbrowser1()
//    {
//        System.out.println("AfterGroups");
//    }
//    @AfterSuite
//    public void launchAfterSuitebrowser3()
//    {
//        System.out.println("AfterSuite");
//    }
//    @AfterMethod
//    public void launcAfterGrAfterMethodoupshbrowser4()
//    {
//        System.out.println("AfterMethod");
//    }
//    @AfterTest
//    public void launchbAfterTestrowser5()
//    {
//        System.out.println("AfterTest");
//    }

}
