package com.assure.qa.util;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class practise {

	public static void main(String[] args) throws InterruptedException {
	
		
/*		String testDataSheetPath = "\\src\\main\\java\\com\\assure\\qa\\testdata\\" + "AssureTestData.xlsx";
		XLS_POI xlsx = new XLS_POI(System.getProperty("user.dir") + testDataSheetPath);
		
		Object[][] testDataTable = dataProvider.getData(xlsx, "VerifySectionNames", "VerifySectionNames");
		
		for (int i = 0; i < testDataTable.length; i++) {
			Hashtable<String, String> ii = (Hashtable<String, String>)testDataTable[i][0];
			System.out.println("data = " + ii.get("SectionName"));
		}
*/		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://lp-new-qa-web/ENGAGE_M3PPORACLE/ES/Presentation/Account/Logon");
		System.out.println(" Page title = " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed());
		
		
		driver.findElement(By.id("UserName")).sendKeys("abhilasha.jha@northgateps.com");
		driver.findElement(By.id("Password")).sendKeys("N0rthg4t31");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		
		driver.findElement(By.xpath("//input[@value='Abandoned Vehicles']")).click();;
		
		Thread.sleep(3000);
		
		Select type = new Select(driver.findElement(By.id("ApplicationType")));
		type.selectByValue("ABVC");
		
		Thread.sleep(5000);
		
		type.selectByValue("ABVD");
		
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
