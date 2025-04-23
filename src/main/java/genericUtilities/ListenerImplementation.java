package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation ITestListener interface of TestNG
 * @author Nivashini R
 *
 */

public class ListenerImplementation implements ITestListener {
	ExtentTest test;
    ExtentReports report;
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ " ->@Test execution started");

		//Intimate Extent report for test
		test=report.createTest(methodName);
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ " ->@Test is success");

		//Log the test results as PASS in Extent reports
		test.log(Status.PASS, methodName+"->@test is pass");

	}

	
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "->@Test is Fail");

		//Log the test results as PASS in Extent reports
		test.log(Status.FAIL, methodName+"->@test is Fail");

		//capture the exception
		System.out.println(result.getThrowable());

		//Log the exception in Extent report
		test.log(Status.WARNING,result.getThrowable());

		//Capture the screenshot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		String screenshotname=methodName+"-"+j.getSystemDateInFormat();
		try {
			String path=s.captureScreenShot(BaseClass.sdriver, screenshotname);

			//Attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}


	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "->@Test is skip");

		//log the status as SKIP in extent report
		test.log(Status.SKIP, methodName+"->@Test is skip");

		//capture the exception
		System.out.println(result.getThrowable());

		//Log the exception in extent report
		test.log(Status.WARNING,result.getThrowable());

	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	
	public void onStart(ITestContext context) {
		System.out.println("suite execution started");
		//Configure the extent reports
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Execution Report");

		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Nivashini");

	}


	public void onFinish(ITestContext context) {
		System.out.println("suite Execution finished");
		//Generate extent reports
		report.flush();

	}

}
