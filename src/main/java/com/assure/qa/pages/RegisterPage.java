package com.assure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.assure.qa.base.TestBase;

public class RegisterPage extends  TestBase{
	
	@FindBy(id="Profile_Salutation")
	WebElement Profile_Salutation;
	
	@FindBy(id="Profile_FirstName")
	WebElement Profile_FirstName;
	
	@FindBy(id="Profile_LastName")
	WebElement Profile_LastName;
	
	@FindBy(id="Profile_PreferredTelephoneNumber")
	WebElement Profile_PreferredTelephoneNumber;
	
	@FindBy(id="Profile_PreferredTelephoneNumberType")
	WebElement Profile_PreferredTelephoneNumberType;
	
	@FindBy(id="Profile_AlternateTelephoneNumber")
	WebElement Profile_AlternateTelephoneNumber;
	
	@FindBy(id="Profile_AlternateTelephoneNumberType")
	WebElement Profile_AlternateTelephoneNumberType;
	
	@FindBy(id="Profile_Email")
	WebElement Profile_Email;
	
	@FindBy(id="Profile_Password")
	WebElement Profile_Password;
	
	@FindBy(id="Profile_ConfirmPassword")
	WebElement Profile_ConfirmPassword;
	
	@FindBy(id="Profile_CompanyName")
	WebElement Profile_CompanyName;
	
	@FindBy(id="RegisterAddressDialog")
	WebElement FindAddress;
	
	@FindBy(id="UserProfile_PreferredMethodOfContact_Email")
	WebElement Profile_PreferredMethodOfContact_Email;
	
	@FindBy(id="UserProfile_PreferredMethodOfContact_Post")
	WebElement Profile_PreferredMethodOfContact_Post;
	
	@FindBy(id="UserProfile_PreferredMethodOfContact_Unspecified")
	WebElement Profile_PreferredMethodOfContact_Unspecified;
	
	@FindBy(id="IsAccepted")
	WebElement IsAccepted;
	
	@FindBy(id="RegisterSubmit")
	WebElement RegisterSubmit;
	
	@FindBy(id="Cancel")
	WebElement Cancel;
	
}
