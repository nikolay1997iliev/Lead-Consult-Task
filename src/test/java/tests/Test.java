package tests;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	@org.junit.Test
	public void VerifyThatTheErrorMessageAppearsForEmptyCaptcha() throws InterruptedException {
		// Creating Chrome driver instance
		WebDriver driver = new ChromeDriver();

		// Navigating the browser to the web-site
		driver.get("https://www.leadconsult.eu/");

		// Navigating through the menu
		driver.findElement(By.id("menu-item-7437")).click();
		driver.findElement(By.id("menu-item-6153")).click();
		driver.findElement(By.id("menu-item-5819")).click();

		// Populating form fields
		driver.findElement(By.name("your-name")).sendKeys("Nikolay Iliev");
		driver.findElement(By.name("your-email")).sendKeys("nikolayiliev@test.com");
		driver.findElement(By.name("tel-760")).sendKeys("1234567890");
		driver.findElement(By.name("your-message")).sendKeys("This is a test message");

		// Checking terms and conditions field
		driver.findElement(By.name("accept-terms[]")).click();

		// Finding and clicking the "Send" button
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div/div/article/div/section[2]/div[2]/div/div[1]/div/div/div[3]/form/p[7]/input"))
				.click();

		// Wait the form to load
		Thread.sleep(5000);
		
		// Get the error message text
		String actualText = driver.findElement(By.className("wpcf7-response-output")).getText();
		
		// Verify that the text equals with expected text
		assertEquals(actualText, "One or more fields have an error. Please check and try again.");

		driver.quit();
	}

}
