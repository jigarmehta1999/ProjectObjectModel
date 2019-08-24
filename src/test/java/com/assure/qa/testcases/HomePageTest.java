package com.assure.qa.testcases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.assure.qa.base.TestBase;
import com.assure.qa.pages.HomePage;
import com.assure.qa.pages.LoginPage;
import com.assure.qa.util.XLS_POI;
import com.assure.qa.util.dataProvider;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SoftAssert sa;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 5)
	public void VerifySectionNamesTest(ITestContext context) {
		System.out.println("VerifySectionNamesTest begins...");
		sa = new SoftAssert();
		homePage = loginPage.LoginSuccessfull(prop.getProperty("username"), prop.getProperty("password"));
		ArrayList<String> actualSectionList = (ArrayList<String>) homePage.verifySections();

		ArrayList<String> expectedSectionList = new ArrayList<String>();

		testDataSheetPath = "\\src\\main\\java\\com\\assure\\qa\\testdata\\"
				+ context.getCurrentXmlTest().getParameter("testDataSheetName");
		XLS_POI xlsx = new XLS_POI(System.getProperty("user.dir") + testDataSheetPath);

		Object[][] testDataSectionTable = dataProvider.getData(xlsx,
				context.getCurrentXmlTest().getParameter("testCaseName"),
				context.getCurrentXmlTest().getParameter("testDataTab"));

		for (int i = 0; i < testDataSectionTable.length; i++) {
			Hashtable<String, String> tempHashTableData = (Hashtable<String, String>) testDataSectionTable[i][0];
			expectedSectionList.add(tempHashTableData.get("SectionName"));
		}
		System.out.println("VerifySectionNamesTest ends...");
		sa.assertEquals(actualSectionList, expectedSectionList);
		sa.assertAll();
	}

	@Test(priority = 5)
	public void VerifyButtonNamesTest(ITestContext context) {
		System.out.println("VerifyButtonNamesTest begins...");
		sa = new SoftAssert();
		homePage = loginPage.LoginSuccessfull(prop.getProperty("username"), prop.getProperty("password"));

		ArrayList<String> actualButtonList = (ArrayList<String>) homePage.verifyButtons();

		ArrayList<String> expectedButtonList = new ArrayList<String>();

		testDataSheetPath = "\\src\\main\\java\\com\\assure\\qa\\testdata\\"
				+ context.getCurrentXmlTest().getParameter("testDataSheetName");
		XLS_POI xlsx = new XLS_POI(System.getProperty("user.dir") + testDataSheetPath);

		Object[][] testDataSectionTable = dataProvider.getData(xlsx,
				context.getCurrentXmlTest().getParameter("testCaseName"),
				context.getCurrentXmlTest().getParameter("testDataTab"));

		for (int i = 0; i < testDataSectionTable.length; i++) {
			Hashtable<String, String> tempHashTableData = (Hashtable<String, String>) testDataSectionTable[i][0];
			expectedButtonList.add(tempHashTableData.get("ButtonNames"));
		}
		
		System.out.println("VerifyButtonNamesTest ends...");
		sa.assertEquals(actualButtonList, expectedButtonList);
		sa.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
