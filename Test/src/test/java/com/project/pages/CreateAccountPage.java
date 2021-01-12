package com.project.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.project.objectmap.ObjectRepos;
import com.project.utils.CaptureScreenshot;
import com.project.utils.GenRandom;

public class CreateAccountPage {

	WebDriver driver;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_id)
	WebElement createAccount;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_login_Email_id)
	WebElement loginEmail;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_login_Password_id)
	WebElement loginPassword;

	@FindBy(xpath = ObjectRepos.CreateAccountPage.createAccount_validateAccount_xpath)
	WebElement accountValidation;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_loginBtn_id)
	WebElement loginBtn;

	@FindBy(linkText = ObjectRepos.CreateAccountPage.createAccount_signOut_linkText)
	WebElement logoutBtn;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_errorAlert_id)
	WebElement createAccScreen;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_createAccountBtn_id)
	WebElement createAccountBtn;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_accountTitle_id)
	WebElement accountTitleSelect;

	@FindBy(xpath = ObjectRepos.CreateAccountPage.createAccount_validateAccount_xpath)
	WebElement myAccScreen;

	@FindBy(xpath = ObjectRepos.CreateAccountPage.createAccount_afterlogout_xpath)
	WebElement afterlogout;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_firstName_id)
	WebElement firstName;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_LastName_id)
	WebElement lastName;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_PassWord_id)
	WebElement passWord;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_addfirstName_id)
	WebElement addfirstName;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_addLastName_id)
	WebElement addlastName;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_address_id)
	WebElement address;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_city_id)
	WebElement city;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_state_id)
	WebElement state;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_zip_id)
	WebElement zip;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_country_id)
	WebElement country;

	@FindBy(xpath = ObjectRepos.CreateAccountPage.createAccount_emptyCountryAlert_xpath)
	WebElement emptyCountryAlert;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_mobilePhone_id)
	WebElement phoneNumber;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_registerBtn_id)
	WebElement registerBtn;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_searchKey_id)
	WebElement searchEdit;

	@FindBy(xpath = ObjectRepos.CreateAccountPage.createAccount_searchBtn_xpath)
	WebElement searchBtn;

	@FindBy(xpath = ObjectRepos.CreateAccountPage.createAccount_invalidLogin_Error_xpath)
	WebElement invalidLoginMessage;

	@FindBy(xpath = ObjectRepos.CreateAccountPage.createAccount_productSearchResult_xpath)
	WebElement productSearch;

	@FindBy(id = ObjectRepos.CreateAccountPage.createAccount_searchResults_xpath)
	WebElement sOutput;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.id(ObjectRepos.CreateAccountPage.createAccount_id)));
			createAccount.clear();
			createAccount.sendKeys(GenRandom.randomInteger() + "a1" + email);
		} catch (NoSuchElementException e) {
		}
	}

	public void enterLoginEmail(String loginId) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.id(ObjectRepos.CreateAccountPage.createAccount_login_Email_id)));
			loginEmail.clear();
			loginEmail.sendKeys(loginId);
		} catch (NoSuchElementException e) {
		}
	}

	public void enterLoginPassword(String loginPwd) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.id(ObjectRepos.CreateAccountPage.createAccount_login_Password_id)));
			loginPassword.clear();
			loginPassword.sendKeys(loginPwd);
		} catch (NoSuchElementException e) {
		}
	}

	public void clickCreateAccountBtn() throws IOException {

		createAccountBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(ObjectRepos.CreateAccountPage.createAccount_validateAccount_xpath)));
			System.out.println("Valid Email ; Continue Registration");
			CaptureScreenshot.getScreenShot(driver);
		} catch (NoSuchElementException e) {
		}
	}

	public void clickSignIn() throws NoSuchElementException {
		loginBtn.click();
	}

	public void clickAccountTitle() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.id(ObjectRepos.CreateAccountPage.createAccount_accountTitle_id)));
			accountTitleSelect.click();

		} catch (NoSuchElementException e) {
		}
	}

	public void enterFirstName(String firstname) throws NoSuchElementException {
		firstName.clear();
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) throws NoSuchElementException {
		lastName.clear();
		lastName.sendKeys(lastname);
	}

	public void enterPassWord(String password) throws NoSuchElementException {
		passWord.clear();
		passWord.sendKeys(password);
	}

	public void enterAddFirstName(String firstname) throws NoSuchElementException {
		addfirstName.clear();
		addfirstName.sendKeys(firstname);
	}

	public void enterAddLastName(String lastname) throws NoSuchElementException {
		addlastName.clear();
		addlastName.sendKeys(lastname);
	}

	public void enterAddress(String sname) throws NoSuchElementException {
		address.clear();
		address.sendKeys(sname);
	}

	public void enterCity(String cname) {
		city.clear();
		city.sendKeys(cname);
	}

	public void selectState(String stname) {
		Select stateDropDown = new Select(state);
		stateDropDown.selectByVisibleText(stname);
	}

	public void enterZip(String zcode) {
		zip.clear();
		zip.sendKeys(zcode);
	}

	public void selectCountry(String sCountry) {
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText(sCountry);
	}

	public void enterMobileNumber(String smobile) {
		phoneNumber.clear();
		phoneNumber.sendKeys(smobile);
	}

	public void clickRegisterBtn() {
		registerBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(ObjectRepos.CreateAccountPage.createAccount_validateAccount_xpath)));
			System.out.println("Registration Successful ; Account Created");
		} catch (NoSuchElementException e) {
		}
	}

	public void validateEmptyCountry(String sAlert) throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(ObjectRepos.CreateAccountPage.createAccount_emptyCountryAlert_xpath)));
			Assert.assertEquals(sAlert, emptyCountryAlert.getText());
			System.out.println(emptyCountryAlert.getText());
			CaptureScreenshot.getScreenShot(driver);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.close();
		} catch (NoSuchElementException e) {
		}
	}
				
	public void verifyLogout(String slogout) throws IOException {
		Assert.assertEquals(slogout, logoutBtn.getText());
		CaptureScreenshot.getScreenShot(driver);
	}

	public void clickLogoutBtn() throws IOException {

		logoutBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(ObjectRepos.CreateAccountPage.createAccount_afterlogout_xpath)));
			System.out.println("Successful logout; Login with valid credentials to access account");
			CaptureScreenshot.getScreenShot(driver);
		} catch (NoSuchElementException e) {
		}
	}

	public void selectEmptyCountry(String sCountry) {
		Select selectEmptyCountry = new Select(country);
		selectEmptyCountry.selectByVisibleText(sCountry);
	}

	public void enterSearchKey(String sProduct) {
		searchEdit.clear();
		searchEdit.sendKeys(sProduct);
	}

	public void clickSearch() throws IOException {
		searchBtn.click();
	}

	public void clickSearchProduct(String sResult) throws IOException {
		searchBtn.click();
		// System.out.println(sOutput.getText());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(ObjectRepos.CreateAccountPage.createAccount_searchResults_xpath)));
			Assert.assertEquals(sOutput.getText(), sResult);
			CaptureScreenshot.getScreenShot(driver);
			// driver.close();
		} catch (NoSuchElementException e) {
		}

	}

	public void enterInvalidLoginEmail(String loginId) {
		loginEmail.clear();
		loginEmail.sendKeys(GenRandom.randomString() + loginId);
	}

	public void verifyInvalidLoginError(String sloginError) throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(ObjectRepos.CreateAccountPage.createAccount_invalidLogin_Error_xpath)));
			Assert.assertEquals(sloginError, invalidLoginMessage.getText());
			System.out.println("Invalid Login " + invalidLoginMessage.getText());
			CaptureScreenshot.getScreenShot(driver);
			driver.close();
		} catch (NoSuchElementException e) {
		}
	}

	public void enterManufacturerKey(String sManufacturer) {
		searchEdit.clear();
		searchEdit.sendKeys(sManufacturer);
		searchBtn.click();

	}

	public void validateManufacturerSearchResults(String sProduct) throws IOException {
		Assert.assertEquals(sProduct, productSearch.getText());
		CaptureScreenshot.getScreenShot(driver);
	}

}