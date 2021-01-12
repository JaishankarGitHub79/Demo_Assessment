package com.project.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.objectmap.ObjectRepos;
import com.project.utils.CaptureScreenshot;



public class PinterestPage {

	WebDriver driver;

	@FindBy(id = ObjectRepos.PinterestPage.Pinterest_pUserName_id)
	WebElement pEmail;

	@FindBy(id = ObjectRepos.PinterestPage.Pinterest_pPassword_id)
	WebElement pPassword;

	public PinterestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterPinterest(String pUser, String pPass) throws InterruptedException, IOException {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String mainWindowId = iter.next().toString(); 
		String pInterestWindow = iter.next().toString();
		driver.switchTo().window(pInterestWindow);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ObjectRepos.PinterestPage.Pinterest_pUserName_id)));
			System.out.println("Inside " + driver.getTitle() + " window");
			CaptureScreenshot.getScreenShot(driver);
			driver.findElement(By.id(ObjectRepos.PinterestPage.Pinterest_pUserName_id)).sendKeys(pUser);
			driver.findElement(By.id(ObjectRepos.PinterestPage.Pinterest_pPassword_id)).sendKeys(pPass);
			//Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(mainWindowId); 
			Thread.sleep(2000);
			//driver.close();
		} catch (NoSuchElementException e) {
			
		}
	}
}
