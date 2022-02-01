package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import junit.framework.Assert;

public class MMHandlerThread
{
  public static long mainThreadID = -1L;
  private HandlerThread ao = null;
  private Handler ap = null;
  
  public MMHandlerThread()
  {
    c();
  }
  
  private void c()
  {
    Log.d("MicroMsg.MMHandlerThread", "MMHandlerThread init [%s]", new Object[] { Util.getStack() });
    this.ap = null;
    this.ao = new HandlerThread("MMHandlerThread", 1);
    this.ao.start();
  }
  
  public static boolean isMainThread()
  {
    if (mainThreadID == -1L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertFalse("mainThreadID not init ", bool);
      if (Thread.currentThread().getId() != mainThreadID) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void postToMainThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  public static void postToMainThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
  }
  
  public static void setMainThreadID(long paramLong)
  {
    if ((mainThreadID < 0L) && (paramLong > 0L)) {
      mainThreadID = paramLong;
    }
  }
  
  public Looper getLooper()
  {
    return this.ao.getLooper();
  }
  
  public Handler getWorkerHandler()
  {
    if (this.ap == null) {
      this.ap = new Handler(this.ao.getLooper());
    }
    return this.ap;
  }
  
  public int postAtFrontOfWorker(IWaitWorkThread paramIWaitWorkThread)
  {
    if (paramIWaitWorkThread == null) {
      return -1;
    }
    if (new Handler(getLooper()).postAtFrontOfQueue(new MMHandlerThread.3(this, paramIWaitWorkThread))) {
      return 0;
    }
    return -2;
  }
  
  public int postToWorker(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return -1;
    }
    getWorkerHandler().post(paramRunnable);
    return 0;
  }
  
  public int reset(IWaitWorkThread paramIWaitWorkThread)
  {
    return postAtFrontOfWorker(new MMHandlerThread.1(this, paramIWaitWorkThread));
  }
  
  /* Error */
  public int syncReset(ResetCallback paramResetCallback)
  {
    // Byte code:
    //   0: ldc 140
    //   2: invokestatic 142	com/tencent/mm/sdk/platformtools/MMHandlerThread:isMainThread	()Z
    //   5: invokestatic 145	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   8: iconst_0
    //   9: newarray byte
    //   11: astore_3
    //   12: new 147	com/tencent/mm/sdk/platformtools/MMHandlerThread$2
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: aload_3
    //   19: invokespecial 150	com/tencent/mm/sdk/platformtools/MMHandlerThread$2:<init>	(Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$ResetCallback;Ljava/lang/Object;)V
    //   22: astore_1
    //   23: aload_3
    //   24: monitorenter
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 134	com/tencent/mm/sdk/platformtools/MMHandlerThread:postAtFrontOfWorker	(Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;)I
    //   30: istore_2
    //   31: iload_2
    //   32: ifne +7 -> 39
    //   35: aload_3
    //   36: invokevirtual 153	java/lang/Object:wait	()V
    //   39: aload_3
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: astore_1
    //   44: aload_3
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: goto -10 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	MMHandlerThread
    //   0	52	1	paramResetCallback	ResetCallback
    //   30	12	2	i	int
    //   11	34	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	31	43	finally
    //   35	39	43	finally
    //   39	41	43	finally
    //   35	39	48	java/lang/Exception
  }
  
  public static abstract interface IWaitWorkThread
  {
    public abstract boolean doInBackground();
    
    public abstract boolean onPostExecute();
  }
  
  public static abstract interface ResetCallback
  {
    public abstract void callback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMHandlerThread
 * JD-Core Version:    0.7.0.1
 */