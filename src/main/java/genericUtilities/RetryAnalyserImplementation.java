package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for iretryAnalyser interface of TestNG
 * @author Nivashini R
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	int count=0;
	int retryCount = 3; //Manual analysis

	
	public boolean retry(ITestResult result) {
		while(count < retryCount)
		{
			count++;	//1 2 3
			return true; //retry retry retry
		}

		return false;	//stop retry
	}


}
