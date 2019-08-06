package com.assure.qa.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class practise {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://lp-new-qa-web/ENGAGE_M3PPORACLE/ES/Presentation/Account/Logon");
		System.out.println(" Page title = " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed());
		
		
		driver.findElement(By.id("UserName")).sendKeys("abhilasha.jha@northgateps.com");
		driver.findElement(By.id("Password")).sendKeys("N0rthg4t31");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		
		System.out.println(driver.findElement(By.name("UserNameLoggedIn")).getText());
		System.out.println(driver.findElement(By.id("CurrentUserName")).getAttribute("value"));
		
		
//		List<WebElement> sections = driver.findElements(By.xpath("//a[@class='accordion-toggle']/strong"));
		
//		System.out.println(sections.get(0).getText());
//		System.out.println(sections.get(1).getText());
		
//		List<WebElement> buttons = driver.findElements(By.xpath("//input[@type='button']"));
//		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='col-xs-3']"));
		
//		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='col-xs-3']/input | //div[@class='col-xs-3']/a"));
		
//		for (int i = 0; i < buttons.size(); i++) {
//			System.out.println(buttons.get(i).getAttribute("value"));
//		}

	}

}