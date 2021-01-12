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
import com.project.pages.FaceBookPage;
import com.project.pages.GPlusPage;
import com.project.pages.PinterestPage;
import com.project.pages.ProductPage;
import com.project.pages.SignInPage;
import com.project.utils.NewReadXL;
import com.project.utils.PropertyReader;

public class TestSearch {

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

	// Manufacturer Search
	@Test(dataProvider = "getTestData", priority = 1)
	public void searchManufacturer(Hashtable<String, String> data) throws InterruptedException, IOException {

		SignInPage sPage = new SignInPage(driver);
		sPage.clickSignIn();
		CreateAccountPage createAccPage = new CreateAccountPage(driver);
		createAccPage.enterLoginEmail(data.get("loginEmail"));
		createAccPage.enterLoginPassword(data.get("loginPassword"));
		createAccPage.clickSignIn();
		createAccPage.enterManufacturerKey(data.get("manufacturer"));
		createAccPage.clickSearch();
		createAccPage.validateManufacturerSearchResults(data.get("manSearchResults"));
		//createAccPage.clickLogoutBtn();
		driver.close();
	}

	// Product Search
	@Test(dataProvider = "getTestData", priority = 1)
	public void searchProduct(Hashtable<String, String> data) throws InterruptedException, IOException {

		SignInPage sPage = new SignInPage(driver);
		sPage.clickSignIn();
		CreateAccountPage createAccPage = new CreateAccountPage(driver);
		createAccPage.enterLoginEmail(data.get("loginEmail"));
		createAccPage.enterLoginPassword(data.get("loginPassword"));
		createAccPage.clickSignIn();
		createAccPage.enterSearchKey(data.get("searchItem1"));
		createAccPage.clickSearchProduct(data.get("sResult"));
		//createAccPage.validateManufacturerSearchResults(data.get("manSearchResults"));
		driver.close();
	}

	// Enter Review
	@Test(dataProvider = "getTestData", priority = 3)
	public void enterReview(Hashtable<String, String> data) throws InterruptedException, IOException {

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
		pPage.clickEnterReview();
		pPage.enterReviewTitle(data.get("reviewTitle"));
		// pPage.enterReviewComment(data.get("comment"));
		pPage.clickSend();
		pPage.validateInvalidComments(data.get("commentAlert"));
		pPage.closeReview();
		// createAccPage.clickLogoutBtn();
		driver.close();
	}

	// Enter Pinterest and return back
	@Test(dataProvider = "getTestData", priority = 4)
	public void enterPinterest(Hashtable<String, String> data) throws InterruptedException, IOException {

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
		pPage.enterPinterestPage();
		PinterestPage pIntPage = new PinterestPage(driver);
		pIntPage.enterPinterest((data.get("pintUser")), (data.get("pintPass")));
		//createAccPage.clickLogoutBtn();
		driver.close();
	}

	// Enter FaceBook and return back
	@Test(dataProvider = "getTestData", priority = 5)
	public void enterFaceBook(Hashtable<String, String> data) throws InterruptedException, IOException {

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
		pPage.enterFacebookPage();
		FaceBookPage fPage = new FaceBookPage(driver);
		fPage.enterFacebook(data.get("fbUser"), data.get("fbPass"));
	}

	// Enter GooglePlus and return back
	@Test(dataProvider = "getTestData", priority = 6)
	public void enterGPlus(Hashtable<String, String> data) throws InterruptedException, IOException {

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
		pPage.enterGPlusPage();
		GPlusPage gPage = new GPlusPage(driver);
		gPage.enterGPlus(data.get("fbUser"));
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