package seleniumconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Googlesearch {
    public static void main(String args[]) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.findElement(By.id("lst-ib")).sendKeys("testing");
        Thread.sleep(3000);
        List<WebElement> wblist = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class ='sbqs_c']"));
        System.out.println("total suggestion"+ wblist.size());
        for(int i=0;i<wblist.size();i++){
            System.out.println(wblist.get(i).getText());
        }

        driver.quit();
    }
}
