package com.project.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setDocumentTitle("Test Execution Report");
		sparkReporter.config().setReportName("Run Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Project Name", "Simplilearn Assessment");
		extent.setSystemInfo("Application Name", "Demo -eCommerce Application");
		extent.setSystemInfo("Platform", "Win 10");
		return extent;
	}

	/*
	 * public static String screenshotPath; public static String screenshotName;
	 * 
	 * public static void captureScreenshot() throws IOException { File scrFile
	 * = ((TakesScreenshot) SeleniumDriver.getDriver()
	 * ).getScreenshotAs(OutputType.FILE); System.out.println("Test123"); Date d
	 * = new Date(); screenshotName = d.toString().replace(":",
	 * "_").replace(" ", "_") + ".jpg";
	 * 
	 * try { FileUtils.copyFile(scrFile, new File(".\\reports\\" +
	 * screenshotName)); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 */
}
