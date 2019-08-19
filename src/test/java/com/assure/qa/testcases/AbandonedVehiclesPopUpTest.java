package com.assure.qa.testcases;

import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assure.qa.base.TestBase;
import com.assure.qa.pages.AbandonedVehiclesPopUp;
import com.assure.qa.pages.HomePage;
import com.assure.qa.pages.LoginPage;
import com.assure.qa.util.XLS_POI;
import com.assure.qa.util.dataProvider;
import com.aventstack.extentreports.Status;

public class AbandonedVehiclesPopUpTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AbandonedVehiclesPopUp abandonedvehiclespopup; 
	SoftAssert sa;
	
	public AbandonedVehiclesPopUpTest() {
		super();
		System.out.println("inside AbandonedVehiclesPopUpTest constructor...");
	}
	
	@BeforeMethod
	public void setUp(){
		System.out.println("inside setUP before method...");
		initialization();
		loginPage = new LoginPage();
//		homePage = new HomePage();
		abandonedvehiclespopup = new AbandonedVehiclesPopUp();
	}
	
	@Test
	public void isAbandonedVehiclesPopUpElementsDisplayedAndEnabled() {
		System.out.println("inside isAbandonedVehiclesPopUpElementsDisplayedAndEnabled...");
		sa = new SoftAssert();
		test = rep.createTest("Testing if Abandoned Vehicles PopUp Elements are Displayed and Enabled");
		
		homePage = loginPage.LoginSuccessfull(prop.getProperty("username"), prop.getProperty("password"));
		
		
		homePage.clickHomeButton();
		homePage.clickButton("Abandoned Vehicles");
	
		if(abandonedvehiclespopup.getAbandonedVehiclesPopUpDialogTitleText().equals("Please select abandoned vehicles type")) {
			System.out.println("Title matches...");
			test.log(Status.PASS, "Actual Title displayed matches matches with expected title");
			test.log(Status.INFO, "Title displayed is: " + abandonedvehiclespopup.getAbandonedVehiclesPopUpDialogTitleText());
		}else {
			System.out.println("Title does not match...");
			test.log(Status.FAIL, "Title displayed is incorrect");
			test.log(Status.INFO, "Expected title is: Please select abandoned vehicles type");
			test.log(Status.INFO, "Actual title is: " + abandonedvehiclespopup.getAbandonedVehiclesPopUpDialogTitleText());
		}
		
		sa.assertEquals(abandonedvehiclespopup.getAbandonedVehiclesPopUpDialogTitleText(), "Please select abandoned vehicles type");
		sa.assertTrue(abandonedvehiclespopup.isAbandonedVehiclesPopUpDialogTitleDisplayed());
		sa.assertTrue(abandonedvehiclespopup.isAbandonedVehiclesTypeTextDisplayed());
		
		sa.assertTrue(abandonedvehiclespopup.isAbandonedVehiclesTypeDropDownDisplayed());
		sa.assertTrue(abandonedvehiclespopup.isAbandonedVehiclesTypeDropDownEnabled());
		
		sa.assertTrue(abandonedvehiclespopup.isCancelButtonDisplayed());
		sa.assertTrue(abandonedvehiclespopup.isCancelButtonEnabled());
		
		sa.assertTrue(abandonedvehiclespopup.isContinueButtonDisplayed());
		sa.assertFalse(abandonedvehiclespopup.isContinueButtonEnabled());
		sa.assertAll();
	}

	
	@Test()
	public void selectAbandonedVehiclesType(ITestContext context) throws InterruptedException {
		sa = new SoftAssert();
		homePage = loginPage.LoginSuccessfull(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickHomeButton();
		homePage.clickButton("Abandoned Vehicles");
		
		testDataSheetPath = "\\src\\main\\java\\com\\assure\\qa\\testdata\\" + context.getCurrentXmlTest().getParameter("testDataSheetName");
		XLS_POI xlsx = new XLS_POI(System.getProperty("user.dir") + testDataSheetPath);
		
		Object[][] testDataSectionTable = dataProvider.getData(xlsx, context.getCurrentXmlTest().getParameter("testCaseName"), context.getCurrentXmlTest().getParameter("testDataTab"));
		
		String AbandonedVehiclesType = null;
		
		for (int i = 0; i < testDataSectionTable.length; i++) {
			Hashtable<String, String> tempHashTableData = (Hashtable<String, String>)testDataSectionTable[i][0];
			AbandonedVehiclesType = tempHashTableData.get("AbandonedVehiclesType");
		}
		
		abandonedvehiclespopup = new AbandonedVehiclesPopUp();
		abandonedvehiclespopup.selectAbandonedVehiclesType(AbandonedVehiclesType);
		
		Thread.sleep(3000);
		
		abandonedvehiclespopup.clickContinueButton();
	}
	
	@DataProvider
	public Object[][] getLoginTestData(ITestContext context) {
		testDataSheetPath = "\\src\\main\\java\\com\\assure\\qa\\testdata\\" + context.getCurrentXmlTest().getParameter("testDataSheetName");
		XLS_POI xlsx = new XLS_POI(System.getProperty("user.dir") + testDataSheetPath);
		return (dataProvider.getData(xlsx,context.getCurrentXmlTest().getParameter("testCaseName"),context.getCurrentXmlTest().getParameter("testDataTab")));
	}
	
	@AfterMethod
	public void tearDown(){
		rep.flush();
		driver.quit();
		
	}

}
