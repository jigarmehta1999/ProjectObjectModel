package com.assure.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.assure.qa.base.TestBase;

public class AbandonedVehiclesPage extends TestBase{

	@FindBy(id="ui-id-1")
	WebElement DialogTitle;
	
	@FindBy(id="btnContinue")
	WebElement ContinueButton;
	
	@FindBy(id="Cancel")
	WebElement CancelButton;
	
	@FindBy(xpath="//label[@for='Abandoned_Vehicles_Type']")
	WebElement AbandonedVehiclesTypeText;
	
	@FindBy(id="ApplicationType")
	WebElement SelectApplicationType;
	
	public AbandonedVehiclesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDialogTitle() {
		return(DialogTitle.getText());
	}
	
	public String verifyAbandonedVehiclesTypeText() {
		return(AbandonedVehiclesTypeText.getText());
	}
	
	public void selectVehicleType(String VehicleTypeValue) {
		Select VehicleType = new Select(SelectApplicationType);
		VehicleType.selectByValue(VehicleTypeValue);
	}
	
	public void verifyButtons() {
	
	}
}
