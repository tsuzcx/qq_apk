package junit.extensions;

import junit.framework.Protectable;
import junit.framework.TestResult;

class TestSetup$1
  implements Protectable
{
  TestSetup$1(TestSetup paramTestSetup, TestResult paramTestResult)
    throws Exception
  {}
  
  public void protect()
    throws Exception
  {
    this.this$0.setUp();
    this.this$0.basicRun(this.val$result);
    this.this$0.tearDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     junit.extensions.TestSetup.1
 * JD-Core Version:    0.7.0.1
 */