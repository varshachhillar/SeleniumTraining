package seleniumconcept;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot  {

    public static void main(String[] args) throws IOException{

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.DemoQA.com");
        driver.manage().window().maximize();

        //Typecast driver to Takescreenshot(Interface) or RemoteWebdriver(class)
        TakesScreenshot ts = (TakesScreenshot)driver;
//        RemoteWebDriver ts = (RemoteWebDriver)driver;
        //getscreenshot is method of Takescreenshot(Interface) and RemoteWebdriver(class) implements interface takescreenshot
        File sscrshot = ts.getScreenshotAs(OutputType.FILE);
        // copy to destination
        FileUtils.copyFile(sscrshot, new File("C:\\Users\\User1\\eclipse-workspace\\javaenv\\SeleniumTraining\\screenshot1.png"));

        driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();
        driver.quit();
    }

}
