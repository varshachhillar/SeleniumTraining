package seleniumconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

public class NewTab {
    public static void main(String[] args) throws AWTException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com/");
        System.out.println(driver.getWindowHandle());

        Robot rb = new Robot();
        //new tab
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_T);
        Thread.sleep(4000);
        //new window
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_N);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_N);
        Thread.sleep(4000);

        Set<String> tabs = driver.getWindowHandles();

        for(String tab : tabs)
        {
            driver.switchTo().window(tab);
            System.out.println(driver.getTitle());
            if(driver.getTitle().contains(""))
                driver.get("http://www.abc.com/");
        }

        //Close window using robot class
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_W);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_W);



    }




}
