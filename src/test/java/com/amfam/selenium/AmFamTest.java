package com.amfam.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmFamTest {

	WebDriver driver;// WebDriver is interface & driver is a object

	@Test(priority = 1)
	public void homePage() throws InterruptedException {

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
		// to perform Scroll on application using javascript
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		// zip code send
		driver.findElement(By.xpath("//input [@id='uid_225']")).sendKeys("07306");
		// Select Auto option from drop-down
		Thread.sleep(2000);
		WebElement selectAutoElement = driver.findElement(By.xpath("//select[@id='uid_228']"));
		Select select = new Select(selectAutoElement);
		select.selectByVisibleText("Auto");
		// click Get A Quote button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Get a Quote']")).click();

	}

	@Test(priority = 2)
	public void policyHolderDetailsYou() throws InterruptedException {
		// getText and Assert>PolicyHolderDetails
		String actualPolicyHolderDetails = driver
				.findElement(By.xpath("//div[@class='fl padLeft10 tab']//h1[contains(text(),'Policyholder Details')]")).getText();
		System.out.println("Asserted>>>"+actualPolicyHolderDetails);
		String expectedPolicyHolderDetails = "Policyholder Details";
		Assert.assertEquals(actualPolicyHolderDetails, expectedPolicyHolderDetails);

		// first name>
		driver.findElement(By.xpath("//input[@id='F_PH_FirstName_0']")).sendKeys("Nadia");
		// Mid>
		driver.findElement(By.xpath("//input[@id='F_PH_MiddleInitial_0']")).sendKeys("A");
		// last>
		driver.findElement(By.xpath("//input[@id='F_PH_LastName_0']")).sendKeys("Ihlam");
		// DOB>
		driver.findElement(By.xpath("//input[@id='F_PH_DOB_0']")).sendKeys("01/01/1989");
		// to perform Scroll on application using javascript
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 450)", "");
		// email>
		driver.findElement(By.xpath(" //input[@id='F_PH_email_0']")).sendKeys("abcd@gmail.com");
		// Add-1>
		driver.findElement(By.xpath("//input[@id='F_street_0']")).sendKeys("88 Van Reypen");
		// Add-2>
		driver.findElement(By.xpath("//input[@id='F_unitNo_0']")).sendKeys("1A");
		// city-state-zip >default , no need
		// year living start>
		driver.findElement(By.xpath("//input[@name='F_livingYear']")).sendKeys("1988");
		// continue button 1> //span[contains(text(),'Continue')]
		driver.findElement(By.xpath("//span[normalize-space()='Continue'] ")).click();
		// Use this residence address:auto selected
		// scroll to click
		Thread.sleep(3000); // for to slow down the test
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 250)", "");
		// click button>2
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
	}

	@Test(priority = 3)
	public void policyHolderDetailsDriver() throws InterruptedException {
		// getText and Assert>Vehicle details
		String vehicleActualDetails = driver
				.findElement(By.xpath("//div[@class='fl padLeft10 tab']//h1[contains(text(),'Vehicle Details')]"))
				.getText();
		System.out.println("Asserted>>>"+vehicleActualDetails);
		String expectedVehicleDetails = "Vehicle Details";
		Assert.assertEquals(vehicleActualDetails, expectedVehicleDetails);
		// get text: Your Summary
		String yourSummary = driver.findElement(By.xpath("//h6[normalize-space()='Your Summary']")).getText();
		System.out.println(yourSummary);
		// get text: Quote Number
		String quoteNumber = driver.findElement(By.xpath("//p[@class='fontN']")).getText();
		System.out.println(quoteNumber);
		// get text : Numeric quote number
		String numericQuoteNumber = driver.findElement(By.xpath("//p[@class='quoteno']")).getText();
		System.out.println(numericQuoteNumber);

	}

	@Test(priority = 4)
	public void tearUp() {
		// to close all sessions
		driver.quit();
	System.err.println("Test Completed......");
	}
}
