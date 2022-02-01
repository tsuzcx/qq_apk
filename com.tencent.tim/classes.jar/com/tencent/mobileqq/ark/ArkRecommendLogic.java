package com.tencent.mobileqq.ark;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class ArkRecommendLogic
{
  private static final ArkWordSegmentThread a = new ArkWordSegmentThread();
  private static volatile boolean bQA = false;
  
  public static ArkWordSegmentThread a()
  {
    return a;
  }
  
  public static Handler u()
  {
    try
    {
      if (!bQA)
      {
        bQA = true;
        a().getHandler().post(new ArkRecommendLogic.1());
      }
      Handler localHandler = a.getHandler();
      return localHandler;
    }
    finally {}
  }
  
  public static class ArkWordSegmentThread
  {
    private Handler mHandler;
    private HandlerThread mThread;
    
    public void ae(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        return;
      }
      if (afy())
      {
        paramRunnable.run();
        return;
      }
      new BlockingRunnable(this, paramRunnable).send();
    }
    
    public boolean afy()
    {
      return Looper.myLooper() == getHandler().getLooper();
    }
    
    public Handler getHandler()
    {
      try
      {
        if (this.mThread == null)
        {
          this.mThread = ThreadManager.newFreeHandlerThread("ArkAnalyseThread", -1);
          this.mThread.start();
          this.mHandler = new Handler(this.mThread.getLooper());
        }
        Handler localHandler = this.mHandler;
        return localHandler;
      }
      finally {}
    }
    
    static final class BlockingRunnable
      implements Runnable
    {
      private final ArkRecommendLogic.ArkWordSegmentThread b;
      private volatile boolean mDone = false;
      private final Runnable mTask;
      
      public BlockingRunnable(ArkRecommendLogic.ArkWordSegmentThread paramArkWordSegmentThread, Runnable paramRunnable)
      {
        this.mTask = paramRunnable;
        this.b = paramArkWordSegmentThread;
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 27	com/tencent/mobileqq/ark/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:mTask	Ljava/lang/Runnable;
        //   4: invokeinterface 33 1 0
        //   9: aload_0
        //   10: monitorenter
        //   11: aload_0
        //   12: iconst_1
        //   13: putfield 25	com/tencent/mobileqq/ark/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:mDone	Z
        //   16: aload_0
        //   17: invokevirtual 36	java/lang/Object:notifyAll	()V
        //   20: aload_0
        //   21: monitorexit
        //   22: return
        //   23: astore_1
        //   24: aload_0
        //   25: monitorexit
        //   26: aload_1
        //   27: athrow
        //   28: astore_1
        //   29: aload_0
        //   30: monitorenter
        //   31: aload_0
        //   32: iconst_1
        //   33: putfield 25	com/tencent/mobileqq/ark/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:mDone	Z
        //   36: aload_0
        //   37: invokevirtual 36	java/lang/Object:notifyAll	()V
        //   40: aload_0
        //   41: monitorexit
        //   42: aload_1
        //   43: athrow
        //   44: astore_1
        //   45: aload_0
        //   46: monitorexit
        //   47: aload_1
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	BlockingRunnable
        //   23	4	1	localObject1	Object
        //   28	15	1	localObject2	Object
        //   44	4	1	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   11	22	23	finally
        //   24	26	23	finally
        //   0	9	28	finally
        //   31	42	44	finally
        //   45	47	44	finally
      }
      
      public void send()
      {
        try
        {
          this.b.getHandler().post(this);
          for (;;)
          {
            boolean bool = this.mDone;
            if (bool) {
              break;
            }
            try
            {
              wait();
            }
            catch (InterruptedException localInterruptedException) {}
          }
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendLogic
 * JD-Core Version:    0.7.0.1
 */