package junit.extensions;

import junit.framework.Test;
import junit.framework.TestResult;

public class RepeatedTest
  extends TestDecorator
{
  private int fTimesRepeat;
  
  public RepeatedTest(Test paramTest, int paramInt)
  {
    super(paramTest);
    if (paramInt < 0) {
      throw new IllegalArgumentException("Repetition count must be >= 0");
    }
    this.fTimesRepeat = paramInt;
  }
  
  public int countTestCases()
  {
    return super.countTestCases() * this.fTimesRepeat;
  }
  
  public void run(TestResult paramTestResult)
  {
    int i = 0;
    for (;;)
    {
      if ((i >= this.fTimesRepeat) || (paramTestResult.shouldStop())) {
        return;
      }
      super.run(paramTestResult);
      i += 1;
    }
  }
  
  public String toString()
  {
    return super.toString() + "(repeated)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     junit.extensions.RepeatedTest
 * JD-Core Version:    0.7.0.1
 */