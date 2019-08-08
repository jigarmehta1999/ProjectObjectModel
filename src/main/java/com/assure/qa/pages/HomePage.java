package com.assure.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assure.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[@class='accordion-toggle']/strong")
	List<WebElement> sections;
	
	@FindBy(xpath="//div[@class='col-xs-3']/input | //div[@class='col-xs-3']/a")
	List<WebElement> buttons;
	
	@FindBy(name="UserNameLoggedIn")
	WebElement UserNameLoggedIn;
	
	@FindBy(id="CurrentUserName")
	WebElement CurrentUserName;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUserName() {
		return(UserNameLoggedIn.getText());
	}
	
	public String verifyEmailID() {
		return(CurrentUserName.getAttribute("value"));
	}
	
	public List<String> verifySections() {
		List<String> tempsections = new ArrayList<String>();
		for (int i = 0; i < sections.size(); i++) {
			tempsections.add(sections.get(i).getText());
		}
		return tempsections;
	}
	
	public List<String> verifyButtons() {
		List<String> tempbuttons = new ArrayList<String>();
		for (int i = 0; i < buttons.size(); i++) {
			tempbuttons.add(buttons.get(i).getAttribute("value").trim());
			System.out.println("button = " + buttons.get(i).getAttribute("value"));
		}
		return tempbuttons;
	}
}
