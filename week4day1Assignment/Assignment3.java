package week4day1Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// launch the url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		// maximize the window
		driver.manage().window().maximize();
		// traverse to the first frame
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("selenium");
		// traverse to the second frame
		Thread.sleep(5000);
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		// traverse to the third frame
		Thread.sleep(5000);
		driver.switchTo().frame(2);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select dd = new Select(dropdown);
		dd.selectByValue("babycat");
	}

}
