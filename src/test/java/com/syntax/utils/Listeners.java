package com.syntax.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case started: "+result.getName());
		test=report.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case passed: "+result.getName());
		test.pass("Test Passed"+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case failed: "+result.getName());
		test.fail("Test Failed"+result.getName());
		String imagePath=CommonMethods.takeScreenshot(result.getName());
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
			test.info("Not able to attach screenshot");
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped: "+result.getName());
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Test started: "+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test finished: "+context.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	
	
	
	
	
	
	
	
	
}
