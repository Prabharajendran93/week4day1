package week4day1Assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4Screenshot {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// enter the url
		driver.get("http://leafground.com/pages/frame.html");
		// switch to frame
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		// find the xpath of the element
		WebElement Element = driver.findElement(By.xpath("(//button[text()='Click Me'])[1]"));
		// click the element
		Element.click();
		Thread.sleep(5000);
		// take the screenshot of the click me button
		File source = Element.getScreenshotAs(OutputType.FILE);
		File destination = new File("./shots/screenshots.png");
		FileUtils.copyFile(source, destination);
		driver.switchTo().defaultContent();
		// find the number of frames
		List<WebElement> number = driver.findElements(By.tagName("iframe"));
		System.out.println("the number of frames is " + number.size());

	}

}
