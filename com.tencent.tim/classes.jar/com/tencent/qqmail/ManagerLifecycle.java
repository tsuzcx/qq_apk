package com.tencent.qqmail;

import com.tencent.qqmail.utilities.thread.Threads;

public abstract class ManagerLifecycle
{
  private static final int DELAY_TIME = 500;
  private static final String TAG = "ManagerLifecycle";
  private boolean bTerminated = false;
  private boolean bTerminating = false;
  private int nLocking = 0;
  private int retryCount = 0;
  
  public boolean isTerminated()
  {
    return this.bTerminated;
  }
  
  public boolean isTerminating()
  {
    return this.bTerminating;
  }
  
  protected void lockRunning()
  {
    try
    {
      this.nLocking += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract void onTerminate();
  
  public void terminate()
  {
    if (this.bTerminated) {
      return;
    }
    this.bTerminating = true;
    Threads.runInBackground(new ManagerLifecycle.1(this), 500L);
  }
  
  /* Error */
  protected void unlockRunning()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/qqmail/ManagerLifecycle:nLocking	I
    //   6: ifle +16 -> 22
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 24	com/tencent/qqmail/ManagerLifecycle:nLocking	I
    //   14: iconst_1
    //   15: isub
    //   16: putfield 24	com/tencent/qqmail/ManagerLifecycle:nLocking	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: iconst_5
    //   23: ldc 11
    //   25: new 56	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   32: ldc 59
    //   34: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 24	com/tencent/qqmail/ManagerLifecycle:nLocking	I
    //   41: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 76	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   50: goto -31 -> 19
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	ManagerLifecycle
    //   53	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	53	finally
    //   22	50	53	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.ManagerLifecycle
 * JD-Core Version:    0.7.0.1
 */