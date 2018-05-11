package seleniumconcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

public class DropDownFeature {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // correct but can be executed with any browser
//		WebDriver driver = new HtmlUnitDriver(); //headless browser
//		ChromeDriver driver= new ChromeDriver(); // correct but can only execute with chrome browser
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://seller.qa4.industrybuying.com");
		driver.findElement(By.name("email")).sendKeys("himanshu.singh@industrybuying.com");
		driver.findElement(By.name("password")).sendKeys("him");
		driver.findElement(By.xpath("//button[contains(text(),\"Log in\")]")).click();

//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(45, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		WebElement flu = wait.until(new Function<WebElement,WebDriver>() {
//			public WebElement apply(WebDriver driv) {
//				return driv.findElement(By.xpath("//*[contains(@href, '#/app/all-vendors')]"));
//			}
//		});
//		driver.getWindowHandles();
		driver.findElement(By.xpath("//*[contains(@href, '#/app/all-vendors')]")).click();
		WebElement dropdown = driver.findElement(By.xpath("//option[contains(text(), 'Status')]//parent::select"));
		Select options = new Select(dropdown);
		List<WebElement> alloptionsweb = options.getOptions();
		
		List<String> sortlist = new ArrayList<String>();
		List<String> alloptions = new ArrayList<String>();

		for(WebElement we : alloptionsweb) {
			alloptions.add(we.getText());
			sortlist.add(we.getText());
		}
		
		Collections.sort(sortlist);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(alloptions, sortlist);
		
		driver.quit();

	}

}
