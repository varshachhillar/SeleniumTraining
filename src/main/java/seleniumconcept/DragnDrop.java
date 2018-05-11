package seleniumconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DragnDrop  {
    public static void main(String[] args) throws InterruptedException, AWTException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demoqa.com/droppable/");

        WebElement to = driver.findElement(By.id("draggableview"));
        WebElement from = driver.findElement(By.id("droppableview"));

        Actions act = new Actions(driver);
        act.clickAndHold(to).moveToElement(from).release().build().perform();
        act.dragAndDrop(to,from).build().perform();


        Thread.sleep(4000);

        //Right click
//        act.contextClick(from).build().perform();
//        Thread.sleep(4000);
//
//        Robot rb = new Robot();
//        rb.mousePress(InputEvent.BUTTON2_DOWN_MASK);
//        rb.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);

        //MouseHover
        WebElement ser = driver.findElement(By.id("menu-item-155"));
        act.moveToElement(ser).build().perform();
        Thread.sleep(4000);


        driver.quit();

    }


}
