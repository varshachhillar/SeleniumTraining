package seleniumconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewLineinTextBox {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demoqa.com/registration/");
        driver.manage().window().maximize();

        driver.findElement(By.name("description")).sendKeys("test line 1 \n line 2 fndnkldk");
        driver.quit();


    }
}
