package org.junit.runner.notification;

import java.util.Iterator;
import java.util.List;

class RunNotifier$4
  extends RunNotifier.SafeNotifier
{
  RunNotifier$4(RunNotifier paramRunNotifier, List paramList1, List paramList2)
    throws Exception
  {
    super(paramRunNotifier, paramList1);
  }
  
  protected void notifyListener(RunListener paramRunListener)
    throws Exception
  {
    Iterator localIterator = this.val$failures.iterator();
    while (localIterator.hasNext()) {
      paramRunListener.testFailure((Failure)localIterator.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.notification.RunNotifier.4
 * JD-Core Version:    0.7.0.1
 */