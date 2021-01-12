package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.pages.CreateAccountPage;
import com.project.pages.ProductPage;
import com.project.pages.SignInPage;
import com.project.utils.NewReadXL;
import com.project.utils.PropertyReader;



public class PurchaseProducts {

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

	@Test(dataProvider = "getTestData", priority = 1)
	public void createOrder(Hashtable<String, String> data) throws InterruptedException, IOException {

		SignInPage sPage = new SignInPage(driver);
		sPage.clickSignIn();

		CreateAccountPage createAccPage = new CreateAccountPage(driver);
		createAccPage.enterLoginEmail(data.get("loginEmail"));
		createAccPage.enterLoginPassword(data.get("loginPassword"));
		createAccPage.clickSignIn();
		createAccPage.enterSearchKey(data.get("searchItem1"));
		createAccPage.clickSearch();
		ProductPage pPage = new ProductPage(driver);
		pPage.clickProduct1();
		pPage.addToCart();
		createAccPage.enterSearchKey(data.get("searchItem2"));
		createAccPage.clickSearch();
		pPage.clickProduct2();
		pPage.addToCart();
		createAccPage.enterSearchKey(data.get("searchItem3"));
		createAccPage.clickSearch();
		pPage.clickProduct3();
		pPage.addToCart();
		pPage.proceedToCheckout(data.get("orderConfirmation"));
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
