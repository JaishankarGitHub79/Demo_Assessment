package com.project.testcases;

import java.io.IOException;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.project.pages.CreateAccountPage;
import com.project.pages.SignInPage;
import com.project.utils.NewReadXL;
import com.project.utils.PropertyReader;

public class TestLogin {

	static WebDriver driver = null;
	String testBrowser = null;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeMethod
	public void LaunchBrowser() throws IOException {
		testBrowser = (PropertyReader.ReadProperty("browser"));
		if (testBrowser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", PropertyReader.ReadProperty("firefoxdriverpath"));
			driver = new FirefoxDriver();
			driver.get(PropertyReader.ReadProperty("appurl"));
			driver.manage().window().maximize();
		} else {
			System.setProperty("webdriver.chrome.driver", PropertyReader.ReadProperty("chromedriverpath"));
			driver = new ChromeDriver();
			driver.get(PropertyReader.ReadProperty("appurl"));
			driver.manage().window().maximize();
		}
	}

	@Test(dataProvider = "getTestData", priority = 1)
	public static void testValidLogin(Hashtable<String, String> data) throws IOException {

		SignInPage sPage = new SignInPage(driver);
		sPage.clickSignIn();
		CreateAccountPage createAccPage = new CreateAccountPage(driver);
		createAccPage.enterLoginEmail(data.get("loginEmail"));
		createAccPage.enterLoginPassword(data.get("loginPassword"));
		createAccPage.clickSignIn();
		createAccPage.verifyLogout(data.get("verifyLogout"));
		createAccPage.clickLogoutBtn();
		driver.close();
	}

	@Test(dataProvider = "getTestData", priority = 2)
	public static void testInValidLogin(Hashtable<String, String> data) throws IOException {

		SignInPage sPage = new SignInPage(driver);
		sPage.clickSignIn();
		CreateAccountPage createAccPage = new CreateAccountPage(driver);
		createAccPage.enterInvalidLoginEmail(data.get("loginEmail"));
		createAccPage.enterLoginPassword(data.get("loginPassword"));
		createAccPage.clickSignIn();
		createAccPage.verifyInvalidLoginError(data.get("loginErrorMessage"));
		// driver.close();
	}

	@DataProvider
	public Object[][] getTestData() throws IOException {
		String ProjectPath = System.getProperty("user.dir");
		String FilePath = ProjectPath + "/src/test/java/com/project/testdata";
		String FileName = "Data.xlsx";
		String SheetName = "DataSet";
		return NewReadXL.ReadFromExcelToObjectArray(FilePath, FileName, SheetName);
	}

}