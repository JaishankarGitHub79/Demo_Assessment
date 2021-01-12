package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.pages.CreateAccountPage;
import com.project.pages.SignInPage;
import com.project.utils.NewReadXL;
import com.project.utils.PropertyReader;

public class CreateNewAccount {

	static WebDriver driver = null;
	String testBrowser = null;

	@BeforeMethod
	public void LaunchBrowser() throws IOException {
		testBrowser = (PropertyReader.ReadProperty("browser"));
		if (testBrowser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", PropertyReader.ReadProperty("firefoxdriverpath"));
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", PropertyReader.ReadProperty("chromedriverpath"));
			driver = new ChromeDriver();
		}
		driver.get(PropertyReader.ReadProperty("appurl"));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getTestData")
	public static void accountSetup(Hashtable<String, String> data) throws IOException {

		SignInPage sPage = new SignInPage(driver);
		sPage.clickSignIn();

		CreateAccountPage createAccPage = new CreateAccountPage(driver);
		createAccPage.enterEmail(data.get("email"));
		createAccPage.clickCreateAccountBtn();
		createAccPage.clickAccountTitle();
		createAccPage.enterFirstName(data.get("firstname"));
		createAccPage.enterLastName(data.get("lastname"));
		createAccPage.enterPassWord(data.get("password"));
		createAccPage.enterAddFirstName(data.get("addfirstname"));
		createAccPage.enterAddLastName(data.get("addlastname"));
		createAccPage.enterAddress(data.get("address"));
		createAccPage.enterCity(data.get("city"));
		createAccPage.selectState(data.get("state"));
		createAccPage.enterZip(data.get("zip"));
		createAccPage.selectCountry(data.get("country"));
		createAccPage.enterMobileNumber(data.get("cell"));
		createAccPage.clickRegisterBtn();
		createAccPage.clickLogoutBtn();
	}

	@DataProvider
	public Object[][] getTestData() throws IOException {
		String ProjectPath = System.getProperty("user.dir");
		String FilePath = ProjectPath + "/src/test/java/com/project/testdata";
		String FileName = "Data.xlsx";
		String SheetName = "DataSet";
		return NewReadXL.ReadFromExcelToObjectArray(FilePath, FileName, SheetName);
	}

	@AfterMethod
	public void CloseBrowser() throws IOException {
		driver.close();
	}
}
