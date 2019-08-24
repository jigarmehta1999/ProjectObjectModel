package com.assure.qa.testcases;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assure.qa.base.TestBase;
import com.assure.qa.pages.HomePage;
import com.assure.qa.pages.LoginPage;
import com.assure.qa.util.XLS_POI;
import com.assure.qa.util.dataProvider;


public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	SoftAssert sa;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		sa = new SoftAssert();
		sa.assertEquals(title.trim(), "Login Screen - Northgate Public Services.");
	}
	
	@Test(priority=2)
	public void isLoginPageElementsDisplayedAndEnabled(){
		sa = new SoftAssert();
		sa.assertTrue(loginPage.isAssureLogoDisplayed());
		
		sa.assertTrue(loginPage.isHomeDisplayed());
		sa.assertTrue(loginPage.isHomeEnabled());
		
		sa.assertTrue(loginPage.islnkForGotPasswordDisplayed());
		sa.assertTrue(loginPage.islnkForGotPasswordEnabled());
		
		sa.assertTrue(loginPage.isLoginButtonDisplayed());
		sa.assertTrue(loginPage.isLoginButtonEnabled());
		
		sa.assertTrue(loginPage.isLoginDisplayed());
		sa.assertTrue(loginPage.isLoginEnabled());
		
		sa.assertTrue(loginPage.isPasswordDisplayed());
		sa.assertTrue(loginPage.isPasswordEnabled());
		
		sa.assertTrue(loginPage.isPublicDisplayed());
		sa.assertTrue(loginPage.isPublicEnabled());
		
		sa.assertTrue(loginPage.isRegisterDisplayed());
		sa.assertTrue(loginPage.isRegisterEnabled());
		
		sa.assertTrue(loginPage.isUserNameDisplayed());
		sa.assertTrue(loginPage.isUserNameEnabled());
		
		sa.assertAll();
	}
	
	
	@Test(priority=3,dataProvider="getLoginTestData")
	public void VerifyloginSuccessfulTest(Hashtable<String, String> testdata, ITestContext context) {
		sa = new SoftAssert();
		
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.LoginSuccessfull(testdata.get("InputUsername"), testdata.get("InputPassword"));
		sa.assertEquals(homePage.verifyUserName(), testdata.get("ExpectedUsername"));
		sa.assertAll();
	}
	
	@Test(priority=4,dataProvider="getLoginTestData")
	public void VerifyloginUnsuccessfulMessageTest(Hashtable<String, String> testdata) {
		sa = new SoftAssert();
//		System.out.println("testdata.get(\"InputUsername\") = " + testdata.get("InputUsername"));
//		System.out.println("testdata.get(\"InputPassword\") = " + testdata.get("InputPassword"));
		loginPage = loginPage.LoginUnsuccessfull(testdata.get("InputUsername"), testdata.get("InputPassword"));
		sa.assertEquals(loginPage.LoginUnsuccessfullMessage(), testdata.get("ExpectedErrorMessage"));
		sa.assertAll();
	}
	
//	

	
	
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
