package junit.framework;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

class JUnit4TestAdapterCache$1
  extends RunListener
{
  JUnit4TestAdapterCache$1(JUnit4TestAdapterCache paramJUnit4TestAdapterCache, TestResult paramTestResult) {}
  
  public void testFailure(Failure paramFailure)
    throws Exception
  {
    this.val$result.addError(this.this$0.asTest(paramFailure.getDescription()), paramFailure.getException());
  }
  
  public void testFinished(Description paramDescription)
    throws Exception
  {
    this.val$result.endTest(this.this$0.asTest(paramDescription));
  }
  
  public void testStarted(Description paramDescription)
    throws Exception
  {
    this.val$result.startTest(this.this$0.asTest(paramDescription));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     junit.framework.JUnit4TestAdapterCache.1
 * JD-Core Version:    0.7.0.1
 */