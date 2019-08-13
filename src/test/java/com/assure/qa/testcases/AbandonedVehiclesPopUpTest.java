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

public class AbandonedVehiclesPopUpTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AbandonedVehiclesPopUp abandonedvehiclespopup; 
	SoftAssert sa;
	
	public AbandonedVehiclesPopUpTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
//		homePage = new HomePage();
		abandonedvehiclespopup = new AbandonedVehiclesPopUp();
	}
	
	@Test
	public void isAbandonedVehiclesPopUpElementsDisplayedAndEnabled() {
		sa = new SoftAssert();
		homePage = loginPage.LoginSuccessfull(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickHomeButton();
		homePage.clickButton("Abandoned Vehicles");
	
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
		driver.quit();
		
	}

}
