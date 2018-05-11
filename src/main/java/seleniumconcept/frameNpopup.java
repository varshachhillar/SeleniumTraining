package seleniumconcept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class frameNpopup {
    public  static void main(String[] args)throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demoqa.com/frames-and-windows/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[contains(text(),'Frameset')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Open Frameset')]")).click();

        //Switch to new tab
        Set<String> alltab = driver.getWindowHandles();
        Iterator<String> it = alltab.iterator();
        String tab1 = it.next();
        String tab2 = it.next();
        driver.switchTo().window(tab2);
        System.out.println(driver.getCurrentUrl());

        //Count number of frames on web Page
        int count = driver.findElements(By.tagName("frame")).size();
        for(int i =0;i<=count;i++){
            driver.switchTo().frame(i).getClass();
        }

        //Switch to frame
        driver.switchTo().frame("contentFrame");
        WebElement para = driver.findElement(By.xpath("//p"));
        System.out.println(para.getText());
        driver.close();

        //switch to new window
        driver.switchTo().window(tab1);
        driver.findElement(By.xpath("//li/a[contains(text(),'Seprate New Window')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'New Seprate Window')]")).click();
        Set<String> allwin = driver.getWindowHandles();
        for(String win : allwin) {
            driver.switchTo().window(win);}
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(4000);
        driver.quit();

        //Alerts (JavaScript)
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
        driver.findElement(By.name("proceed")).submit();
        Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        al.accept();

    }
}
