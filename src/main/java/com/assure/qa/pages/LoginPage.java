package com.assure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assure.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "UserName")
	WebElement UserName;

	@FindBy(id = "Password")
	WebElement Password;

	@FindBy(id = "lnkForGotPassword")
	WebElement lnkForGotPassword;

	@FindBy(id = "btnLogin")
	WebElement btnLogin;

	@FindBy(id = "Cancel")
	WebElement registerButton;

	@FindBy(xpath = "//a[text()='Home']")
	WebElement Home;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement Register;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement Login;

	@FindBy(xpath = "//a[text()='Public']")
	WebElement Public;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement AssureLogo;
	
	
	@FindBy(xpath="//div[@class='validation-summary-errors']//li")
	WebElement LoginUnsuccessfullMessage;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Login Screen - Northgate Public Services.
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isUserNameDisplayed() {
		return UserName.isDisplayed();
	}

	public boolean isUserNameEnabled() {
		return UserName.isEnabled();
	}
	
	public boolean isPasswordDisplayed() {
		return Password.isDisplayed();
	}

	public boolean isPasswordEnabled() {
		return Password.isEnabled();
	}
	
	public boolean islnkForGotPasswordDisplayed() {
		return lnkForGotPassword.isDisplayed();
	}

	public boolean islnkForGotPasswordEnabled() {
		return lnkForGotPassword.isEnabled();
	}
	
	
	public boolean isLoginButtonDisplayed() {
		return btnLogin.isDisplayed();
	}

	public boolean isLoginButtonEnabled() {
		return btnLogin.isEnabled();
	}

	public boolean isHomeDisplayed() {
		return Home.isDisplayed();
	}

	public boolean isHomeEnabled() {
		return Home.isEnabled();
	}

	public boolean isRegisterDisplayed() {
		return Register.isDisplayed();
	}

	public boolean isRegisterEnabled() {
		return Register.isEnabled();
	}

	public boolean isLoginDisplayed() {
		return Login.isDisplayed();
	}

	public boolean isLoginEnabled() {
		return Login.isEnabled();
	}

	public boolean isPublicDisplayed() {
		return Public.isDisplayed();
	}

	public boolean isPublicEnabled() {
		return Public.isEnabled();
	}

	public boolean isAssureLogoDisplayed() {
		return AssureLogo.isDisplayed();
	}

	public RegisterPage clickOnRegisterLink() {
		Register.click();
		return new RegisterPage();
	}

	public HomePage LoginSuccessfull(String un, String pwd) {
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		btnLogin.click();
	
		return new HomePage();
	}

	public LoginPage LoginUnsuccessfull(String un, String pwd) {
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		btnLogin.click();
	
		return new LoginPage();
	}

	public String LoginUnsuccessfullMessage() {
		return LoginUnsuccessfullMessage.getText();
	}
	
	
	/*
	 * public DealsPage clickOnDealsLink(){ dealsLink.click(); return new
	 * DealsPage(); }
	 * 
	 * public TasksPage clickOnTasksLink(){ tasksLink.click(); return new
	 * TasksPage(); }
	 * 
	 * public void clickOnNewContactLink(){ Actions action = new Actions(driver);
	 * action.moveToElement(contactsLink).build().perform(); newContactLink.click();
	 * 
	 * }
	 */

}
