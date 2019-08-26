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
	// ignore comments
	
	@FindBy(name="UserNameLoggedIn")
	WebElement UserNameLoggedIn;
	
	@FindBy(id="CurrentUserName")
	WebElement CurrentUserName;
	
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement HomeButton;
	
	@FindBy(xpath="//a[text()='Reports']")
	WebElement ReportsButton;
	
	@FindBy(xpath="//a[text()='Dashboard']")
	WebElement DashboardButton;
	
	@FindBy(xpath="//a[text()='Notifications']")
	WebElement NotificationsButton;
	
	@FindBy(xpath="//a[text()='Letters']")
	WebElement LettersButton;
	
	@FindBy(xpath="//a[text()='Search']")
	WebElement SearchButton;
	
	@FindBy(xpath="//a[text()='Public']")
	WebElement PublicButton;
	
	@FindBy(xpath="//a[text()='Support']")
	WebElement SupportButton;
	
	
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
	
	public void clickHomeButton() {
		HomeButton.click();
	}
	
	public void clickButton(String buttonName) {
		for (int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).getAttribute("value").equals(buttonName)) {
				buttons.get(i).click();
			}
		}
	}
}
