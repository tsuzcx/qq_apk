package org.junit.runner.notification;

class RunNotifier$5
  extends RunNotifier.SafeNotifier
{
  RunNotifier$5(RunNotifier paramRunNotifier, Failure paramFailure)
  {
    super(paramRunNotifier);
  }
  
  protected void notifyListener(RunListener paramRunListener)
    throws Exception
  {
    paramRunListener.testAssumptionFailure(this.val$failure);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.notification.RunNotifier.5
 * JD-Core Version:    0.7.0.1
 */