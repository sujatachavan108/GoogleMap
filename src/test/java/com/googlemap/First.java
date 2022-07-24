package com.googlemap;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class First {
	public RemoteWebDriver driver = null;

	@BeforeTest
	public void launchUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/maps/");

	}

	@Test(priority = -2)
	public void verifyText() throws InterruptedException {

		WebElement element = driver.findElement(By.cssSelector("input#searchboxinput"));
		element.sendKeys("Wankhede Stadium");

		Thread.sleep(5000);
		element.findElement(By.xpath("//span[text()='Vinoo Mankad Road, Churchgate, Mumbai, Maharashtra']")).click();

		Thread.sleep(10000);
	/**
		    AShot ashot=new AShot();
		    ShootingStrategy strategy=ShootingStrategies.viewportPasting(1000);
		    ashot.shootingStrategy(strategy);
		    
		    Screenshot screenshot=ashot.takeScreenshot(driver);
		    BufferedImage image=screenshot.getImage();
		    ImageIO.write(image, "PNG", new File("usingAshot.png"));
		*/
		WebElement element1 = driver.findElement(By.cssSelector("h1.DUwDvf"));
		String text = element1.getText();
		System.out.println(text);

	}

	@Test(priority = -1)
	public void verifyTitle() throws InterruptedException {
		Thread.sleep(10000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Wankhede Stadium-Google Maps";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title is matched");
		} else {
			System.out.println("Title is not Matched");
		}
	}

	@Test(priority = 0)
	public void verifyLink() throws InterruptedException {
		Thread.sleep(11000);
		WebElement elememt = driver.findElement(By.xpath("//div[text()='mumbaicricket.com']"));
		if (elememt.isDisplayed()) {
			System.out.println("Link is present");
		} else {
			System.out.println("Link is not present");
		}
	}

	@Test
	public void verifyPhoneNumber() throws InterruptedException {
		Thread.sleep(12000);
		WebElement element = driver.findElement(By.xpath("//div[text()='022 2279 5500']"));
		if (element.isDisplayed()) {
			System.out.println("Phone Number is present");
		} else {
			System.out.println("Not present");
		}
	}

	@Test
	public void printView() {
		WebElement element2 = driver.findElement(By.cssSelector("div.jANrlb"));
		String view = element2.getText();
		System.out.println(view);

	}

}
