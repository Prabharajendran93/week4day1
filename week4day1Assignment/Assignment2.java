package week4day1Assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		//load the url
		driver.get("https://dev121343.service-now.com/");
		//maximize the window
		driver.manage().window().maximize();
		// enter the username
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		//enter the password
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		//click login
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.switchTo().defaultContent();
		//search incident file navigator
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();													
		//click All
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(5000);
		//click new button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(5000);
		//select a value for caller
		driver.findElement(By.xpath("//div[@class='input-group ref-container']")).sendKeys("Alejandra Prenatt");
		//enter the value at short-description
		  driver.findElement(By.xpath("//input[@name='incident.short_description']")).sendKeys("Alejandra Prenatt");
		  //read the incident number and save it a variable
		  String text = driver.findElement(By.xpath("//input[@name='incident.number']")).getText();
		  System.out.println(text);
		//click the submit button 
		  driver.findElement(By.xpath("//button[text()='Submit']")).click();
		  //search the same incident number in the search screen below
		  WebElement element = driver.findElement(By.xpath("//div[@class='input group']/input[@placeholder='Search']"));
		  element.sendKeys("INCIDENT NUMBER");
		  element.sendKeys(Keys.ENTER);
		  //verify the incident is created successfully
		  String NUMBER = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/ts/a[@class=;linked form link']l")).getText();
		  if(text.equals(NUMBER)) {
			  System.out.println("the incident is created");
		  }
		  else
		  {
			  System.out.println("the incident is not created");
		  }
	}

}
