package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.pages.CreateAccountPage;
import com.project.pages.FaceBookPage;
import com.project.pages.PinterestPage;
import com.project.pages.ProductPage;
import com.project.pages.SignInPage;
import com.project.utils.NewReadXL;
import com.project.utils.PropertyReader;


public class SearchTest {

	static WebDriver driver = null;

	@BeforeMethod
	public void LaunchBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", PropertyReader.ReadProperty("chromedriverpath"));
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver = new ChromeDriver();
		driver.get(PropertyReader.ReadProperty("appurl"));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getTestData")
	public void testSearch(Hashtable<String, String> data) throws InterruptedException, IOException {

		SignInPage sPage = new SignInPage(driver);
		sPage.clickSignIn();

		CreateAccountPage createAccPage = new CreateAccountPage(driver);
		createAccPage.enterLoginEmail(data.get("loginEmail"));
		createAccPage.enterLoginPassword(data.get("loginPassword"));
		createAccPage.clickSignIn();
		// Manufacturer Search
		createAccPage.enterManufacturerKey(data.get("manufacturer"));
		createAccPage.clickSearch();
		createAccPage.validateManufacturerSearchResults(data.get("manSearchResults"));
		
		// Product Search
		createAccPage.enterSearchKey(data.get("searchItem1"));
		createAccPage.clickSearchProduct(data.get("sResult"));
/*
		ProductPage pPage = new ProductPage(driver);
		pPage.clickProduct1();
		pPage.clickEnterReview();
		pPage.enterReviewTitle(data.get("reviewTitle"));
		// pPage.enterReviewComment(data.get("comment"));
		pPage.clickSend();
		pPage.validateInvalidComments(data.get("commentAlert"));
		pPage.closeReview();
		// driver.close();
		
		pPage.enterPinterestPage();
		PinterestPage pIntPage = new PinterestPage(driver);
		pIntPage.enterPinterest((data.get("pintUser")),(data.get("pintPass")));
		
		pPage.enterFacebookPage();
		FaceBookPage fPage = new FaceBookPage(driver);
		fPage.enterFacebook(data.get("fbUser"),data.get("fbPass"));*/
		
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

