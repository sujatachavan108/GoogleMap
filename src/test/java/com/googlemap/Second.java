package com.googlemap;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Second {
	public RemoteWebDriver driver=null;
	@Test
	public void launchUrl() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.allmovie.com/search/movies/The+Godfather");
		List<WebElement> movie=driver.findElements(By.cssSelector("ul.search-results"));
		System.out.println(movie.size());
		
		for (WebElement element : movie) {
			String text=element.getText();
			System.out.println(text);
		}
		
	}
	@Test
	public void verifyClickOnMovieLink() {
		driver.findElement(By.xpath("(//a[text()='The Godfather'])[1]")).click();

	}
	@Test
	public void verifyDirectorName() {
		WebElement element=driver.findElement(By.cssSelector("h3#movie-director-link"));
		String expected="Francis Ford Coppola";
		String actual=element.getText();
		System.out.println(actual);
		
		if(expected.equals(actual))
		{
			System.out.println("Matched");
		}
		else
		{
			System.out.println("Not matched");
		}
		
	}
	
	
	

}
