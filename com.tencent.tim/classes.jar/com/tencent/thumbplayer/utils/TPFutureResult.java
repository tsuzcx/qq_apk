package com.tencent.thumbplayer.utils;

public class TPFutureResult
{
  private static final int INTERRUPTED_TIMES = 2;
  private static final String TAG = "TPFutureResult";
  private Throwable mException = null;
  private boolean mIsReady = false;
  private Object mRealResult = null;
  
  private void waitAndDealInterrupted()
  {
    int j = 2;
    int i = 0;
    for (;;)
    {
      j -= 1;
      if (j >= 0) {}
      try
      {
        wait();
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = 1;
        TPLogUtil.i("TPFutureResult", "getResult wait has InterruptedException, interrupted:" + j);
      }
    }
  }
  
  private void waitAndDealInterrupted(long paramLong)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    for (;;)
    {
      if (paramLong > 0L) {}
      try
      {
        wait(paramLong);
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = 1;
        paramLong -= System.currentTimeMillis() - l;
        TPLogUtil.i("TPFutureResult", "getResult wait has InterruptedException, remainTime:" + paramLong);
      }
    }
  }
  
  public Object getResult()
    throws Throwable
  {
    try
    {
      if (!this.mIsReady) {
        waitAndDealInterrupted();
      }
      if (this.mException != null) {
        throw this.mException;
      }
    }
    finally {}
    Object localObject2 = this.mRealResult;
    return localObject2;
  }
  
  public Object getResult(long paramLong)
    throws Throwable
  {
    try
    {
      if (!this.mIsReady) {
        waitAndDealInterrupted(paramLong);
      }
      if (this.mException != null) {
        throw this.mException;
      }
    }
    finally {}
    Object localObject2 = this.mRealResult;
    return localObject2;
  }
  
  public void setException(Throwable paramThrowable)
  {
    if (paramThrowable != null) {}
    try
    {
      this.mException = paramThrowable;
      this.mIsReady = true;
      notifyAll();
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  /* Error */
  public void setResult(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/thumbplayer/utils/TPFutureResult:mIsReady	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 23	com/tencent/thumbplayer/utils/TPFutureResult:mRealResult	Ljava/lang/Object;
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 25	com/tencent/thumbplayer/utils/TPFutureResult:mIsReady	Z
    //   24: aload_0
    //   25: invokevirtual 94	java/lang/Object:notifyAll	()V
    //   28: goto -17 -> 11
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	TPFutureResult
    //   0	36	1	paramObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   14	28	31	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPFutureResult
 * JD-Core Version:    0.7.0.1
 */