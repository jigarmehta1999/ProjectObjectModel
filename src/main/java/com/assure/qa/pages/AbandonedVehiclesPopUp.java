package com.assure.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.assure.qa.base.TestBase;

public class AbandonedVehiclesPopUp extends TestBase{

	@FindBy(id="ui-id-1")
	List<WebElement> AbandonedVehiclesPopUpDialogTitle;
	
	@FindBy(xpath="//label[contains(text(),'Abandoned Vehicles Type')]")
	WebElement AbandonedVehiclesTypeText;
	
	@FindBy(id="ApplicationType")
	WebElement AbandonedVehicleDropDown;
	
	@FindBy(id="btnContinue")
	WebElement ContinueButton;
	
	@FindBy(id="Cancel")
	WebElement CancelButton;
	
	
	public AbandonedVehiclesPopUp() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAbandonedVehiclesPopUpDialogTitleDisplayed() {
		return(AbandonedVehiclesPopUpDialogTitle.get(1).isDisplayed());
	}
	
	public boolean isAbandonedVehiclesTypeTextDisplayed() {
		return(AbandonedVehiclesTypeText.isDisplayed());
	}
	
	public boolean isAbandonedVehiclesTypeDropDownEnabled() {
		return(AbandonedVehicleDropDown.isEnabled());
	}
	
	public boolean isAbandonedVehiclesTypeDropDownDisplayed() {
		return(AbandonedVehicleDropDown.isDisplayed());
	}
	
	public boolean isContinueButtonEnabled() {
		return(ContinueButton.isEnabled());
	}
	
	public boolean isContinueButtonDisplayed() {
		return(ContinueButton.isDisplayed());
	}
	
	public boolean isCancelButtonEnabled() {
		return(CancelButton.isEnabled());
	}
	
	public boolean isCancelButtonDisplayed() {
		return(CancelButton.isDisplayed());
	
	}
	
	public String getAbandonedVehiclesPopUpDialogTitleText() {
		return(AbandonedVehiclesPopUpDialogTitle.get(1).getText());
	}
	
	public String getAbandonedVehiclesTypeText() {
		return(AbandonedVehiclesTypeText.getText());
	}
	
	
	public void clickContinueButton() {
		ContinueButton.click();
	}
	
	public void selectAbandonedVehiclesType(String VehicleTypeValue) {
		Select VehicleType = new Select(AbandonedVehicleDropDown);
		VehicleType.selectByValue(VehicleTypeValue);
	}
}
