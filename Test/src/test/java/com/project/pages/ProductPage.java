package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.project.objectmap.ObjectRepos;
import com.project.utils.CaptureScreenshot;

public class ProductPage {

	WebDriver driver;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_searchResult1_xpath)
	public WebElement productSearch1;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_searchResult2_xpath)
	WebElement productSearch2;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_searchResult3_xpath)
	WebElement productSearch3;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_writeReviewLink_xpath)
	public WebElement writeReviewLink;

	@FindBy(id = ObjectRepos.ProductPage.Product_titleReview_id)
	WebElement titleEdit;

	@FindBy(id = ObjectRepos.ProductPage.Product_comments_id)
	WebElement commentsEdit;

	@FindBy(id = ObjectRepos.ProductPage.Product_sendReview_id)
	WebElement reviewSendBtn;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_incorrectComment_xpath)
	WebElement commentAlert;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_closeReview_xpath)
	WebElement closeReviewWindow;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_pInterestLink_xpath)
	WebElement clickPinterestLink;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_facebookLink_xpath)
	WebElement clickFacebookLink;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_GPlusLink_xpath)
	WebElement clickGPlusLink;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_Addtocart_xpath)
	WebElement clickAddToCart;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_Verifycart_xpath)
	WebElement verifycart;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_Proceed1_xpath)
	WebElement clickProceed1;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_Proceed2_xpath)
	WebElement clickProceed2;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_Proceed3_xpath)
	WebElement clickProceed3;

	@FindBy(id = ObjectRepos.ProductPage.Product_AgreeTerms_id)
	WebElement agreeTerms;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_Proceed4_xpath)
	WebElement clickProceed4;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_CheckPay_xpath)
	WebElement payByCheck;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_ConfirmOrder_xpath)
	WebElement confirmOrder;

	@FindBy(xpath = ObjectRepos.ProductPage.Product_OrderConfirmationAlert_xpath)
	WebElement confirmationAlert;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickProduct1() {
		productSearch1.click();
	}

	public void clickProduct2() {
		productSearch2.click();
	}

	public void clickProduct3() {
		productSearch3.click();
	}

	public void clickEnterReview() throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(ObjectRepos.ProductPage.Product_writeReviewLink_xpath)));
			System.out.println("Inside " + driver.getTitle() + " window");
			CaptureScreenshot.getScreenShot(driver);
			writeReviewLink.click();

		} catch (NoSuchElementException e) {
		}
	}

	public void enterReviewTitle(String sTitle) {
		titleEdit.sendKeys(sTitle);
	}

	public void enterReviewComment(String sComment) {
		commentsEdit.sendKeys(sComment);
	}

	public void clickSend() {
		reviewSendBtn.click();
	}

	public void validateInvalidComments(String sInvalidComment) throws IOException {

		// System.out.println(commentAlert.getTagName());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(ObjectRepos.ProductPage.Product_incorrectComment_xpath)));
			System.out.println("Inside " + driver.getTitle() + " window");
			Assert.assertEquals(commentAlert.getTagName(), sInvalidComment);
			CaptureScreenshot.getScreenShot(driver);

		} catch (NoSuchElementException e) {

		}
	}

	public void closeReview() {
		closeReviewWindow.click();
	}

	public void enterPinterestPage() {
		clickPinterestLink.click();
	}

	public void enterFacebookPage() {
		clickFacebookLink.click();
	}

	public void enterGPlusPage() {
		clickGPlusLink.click();
	}

	public void addToCart() {
		clickAddToCart.click();
	}

	public void verifyCartItems() {
		// System.out.println(verifycart.getAttribute("text"));
	}

	public void proceedToCheckout(String sConfirmation) throws InterruptedException, IOException {
		Thread.sleep(1000);
		clickProceed1.click();
		clickProceed2.click();
		// System.out.println(verifycart.getAttribute("text"));
		clickProceed3.click();
		agreeTerms.click();
		clickProceed4.click();
		payByCheck.click();
		Thread.sleep(1000);
		confirmOrder.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(ObjectRepos.ProductPage.Product_OrderConfirmationAlert_xpath)));
			Assert.assertEquals(sConfirmation, confirmationAlert.getText());
			System.out.println(confirmationAlert.getText());
			CaptureScreenshot.getScreenShot(driver);
			driver.close();
		} catch (NoSuchElementException e) {
		}

	}

}
