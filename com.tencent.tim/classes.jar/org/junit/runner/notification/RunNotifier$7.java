package org.junit.runner.notification;

import org.junit.runner.Description;

class RunNotifier$7
  extends RunNotifier.SafeNotifier
{
  RunNotifier$7(RunNotifier paramRunNotifier, Description paramDescription)
    throws Exception
  {
    super(paramRunNotifier);
  }
  
  protected void notifyListener(RunListener paramRunListener)
    throws Exception
  {
    paramRunListener.testFinished(this.val$description);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.notification.RunNotifier.7
 * JD-Core Version:    0.7.0.1
 */