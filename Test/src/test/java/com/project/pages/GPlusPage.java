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

public class GPlusPage {

	WebDriver driver;

	@FindBy(id = ObjectRepos.GPlusPage.GPlus_Email)
	WebElement gEmail;

	public GPlusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterGPlus(String gUser) throws InterruptedException, IOException {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String mainWindowId = iter.next().toString();
		String gPluswindow = iter.next().toString();
		driver.switchTo().window(gPluswindow);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
			System.out.println("Inside " + driver.getTitle() + " window");
			CaptureScreenshot.getScreenShot(driver);
			gEmail.sendKeys(gUser);
			driver.close();
			Thread.sleep(2000);
			driver.switchTo().window(mainWindowId);
			driver.close();
		} catch (NoSuchElementException e) {

		}

	}

}