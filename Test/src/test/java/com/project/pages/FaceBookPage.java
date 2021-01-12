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

public class FaceBookPage {

	WebDriver driver;

	@FindBy(id = ObjectRepos.FacebookPage.Facebook_fUserName_id)
	WebElement fEmail;

	@FindBy(id = ObjectRepos.FacebookPage.Facebook_fPassword_id)
	WebElement fPassword;

	public FaceBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFacebook(String fbUser, String fbPass) throws InterruptedException, IOException {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String mainWindowId = iter.next().toString();
		String facebookWindow = iter.next().toString();
		driver.switchTo().window(facebookWindow);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
			System.out.println("Inside " + driver.getTitle() + " window");
			CaptureScreenshot.getScreenShot(driver);
			fEmail.sendKeys(fbUser);
			fPassword.sendKeys(fbPass);
			// Thread.sleep(2000);
			driver.close();
			Thread.sleep(2000);
			driver.switchTo().window(mainWindowId);
			driver.close();
		} catch (NoSuchElementException e) {

		}

	}

}
