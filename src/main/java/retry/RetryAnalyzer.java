package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        int maxRetry = 3;
        if(count< maxRetry){
            count++;
            return true;
        }
        return false;
    }
}
