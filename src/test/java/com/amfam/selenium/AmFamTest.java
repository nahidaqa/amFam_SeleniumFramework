package com.amfam.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmFamTest {

	WebDriver driver;// WebDriver is interface & driver is a object

	@Test
	public void seleniumTest() throws InterruptedException {

		System.out.println("Test Starting.........");
		// setup driver
		WebDriverManager.chromedriver().setup(); 
		// Chrome browser launch
		driver = new ChromeDriver(); 
		// maximize the window
		driver.manage().window().maximize(); 
		// open page/url/Open Target Website
		driver.get("https://www.connectbyamfam.com/");
		// page load time 10 sec
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));  
		// to read title of the page
		System.out.println("Title of the home page--->" + driver.getTitle());
		// to make sure that the element is on the page, before you attempt to locate it
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		// zip code send
		driver.findElement(By.xpath("//input [@id='uid_225']")).sendKeys("07306");
		// Select Auto option from drop-down
		Thread.sleep(2000);
		WebElement selectAuto = driver.findElement(By.xpath("//select[@id='uid_228']"));
		Select select = new Select(selectAuto);
		select.selectByVisibleText("Auto");
		// click Get A Quote
		Thread.sleep(2000);
		WebElement getQuoteClick = driver.findElement(By.xpath("//button[normalize-space()='Get a Quote']"));
		System.out.println(getQuoteClick.getText());
		getQuoteClick.click();

		// driver.quit(); //to close all sessions

	}

}
