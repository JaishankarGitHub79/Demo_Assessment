package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.objectmap.ObjectRepos;

public class SignInPage {

	WebDriver driver;

	@FindBy(linkText = ObjectRepos.SignInPage.signIn_linkText)
	public WebElement signInLink;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignIn() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(ObjectRepos.SignInPage.signIn_linkText)));
		signInLink.click();
	}

}
