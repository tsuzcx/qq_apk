package com.facebook.stetho.common.android;

import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

public final class HandlerUtil
{
  public static boolean checkThreadAccess(Handler paramHandler)
  {
    return Looper.myLooper() == paramHandler.getLooper();
  }
  
  public static <V> V postAndWait(Handler paramHandler, UncheckedCallable<V> paramUncheckedCallable)
  {
    if (checkThreadAccess(paramHandler)) {
      try
      {
        paramHandler = paramUncheckedCallable.call();
        return paramHandler;
      }
      catch (Exception paramHandler)
      {
        throw new RuntimeException(paramHandler);
      }
    }
    return new HandlerUtil.1(paramUncheckedCallable).invoke(paramHandler);
  }
  
  public static void postAndWait(Handler paramHandler, Runnable paramRunnable)
  {
    if (checkThreadAccess(paramHandler)) {
      try
      {
        paramRunnable.run();
        return;
      }
      catch (RuntimeException paramHandler)
      {
        throw new RuntimeException(paramHandler);
      }
    }
    new HandlerUtil.2(paramRunnable).invoke(paramHandler);
  }
  
  public static void verifyThreadAccess(Handler paramHandler)
  {
    Util.throwIfNot(checkThreadAccess(paramHandler));
  }
  
  static abstract class WaitableRunnable<V>
    implements Runnable
  {
    private Exception mException;
    private boolean mIsDone;
    private V mValue;
    
    private void join()
    {
      try
      {
        for (;;)
        {
          boolean bool = this.mIsDone;
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
    
    public V invoke(Handler paramHandler)
    {
      if (!paramHandler.post(this)) {
        throw new RuntimeException("Handler.post() returned false");
      }
      join();
      if (this.mException != null) {
        throw new RuntimeException(this.mException);
      }
      return this.mValue;
    }
    
    protected abstract V onRun();
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_0
      //   2: invokevirtual 63	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:onRun	()Ljava/lang/Object;
      //   5: putfield 54	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mValue	Ljava/lang/Object;
      //   8: aload_0
      //   9: aconst_null
      //   10: putfield 49	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mException	Ljava/lang/Exception;
      //   13: aload_0
      //   14: monitorenter
      //   15: aload_0
      //   16: iconst_1
      //   17: putfield 27	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mIsDone	Z
      //   20: aload_0
      //   21: invokevirtual 66	java/lang/Object:notifyAll	()V
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      //   32: astore_1
      //   33: aload_0
      //   34: aconst_null
      //   35: putfield 54	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mValue	Ljava/lang/Object;
      //   38: aload_0
      //   39: aload_1
      //   40: putfield 49	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mException	Ljava/lang/Exception;
      //   43: aload_0
      //   44: monitorenter
      //   45: aload_0
      //   46: iconst_1
      //   47: putfield 27	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mIsDone	Z
      //   50: aload_0
      //   51: invokevirtual 66	java/lang/Object:notifyAll	()V
      //   54: aload_0
      //   55: monitorexit
      //   56: return
      //   57: astore_1
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_1
      //   61: athrow
      //   62: astore_1
      //   63: aload_0
      //   64: monitorenter
      //   65: aload_0
      //   66: iconst_1
      //   67: putfield 27	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mIsDone	Z
      //   70: aload_0
      //   71: invokevirtual 66	java/lang/Object:notifyAll	()V
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_1
      //   77: athrow
      //   78: astore_1
      //   79: aload_0
      //   80: monitorexit
      //   81: aload_1
      //   82: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	WaitableRunnable
      //   27	4	1	localObject1	Object
      //   32	8	1	localException	Exception
      //   57	4	1	localObject2	Object
      //   62	15	1	localObject3	Object
      //   78	4	1	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   15	26	27	finally
      //   28	30	27	finally
      //   0	13	32	java/lang/Exception
      //   45	56	57	finally
      //   58	60	57	finally
      //   0	13	62	finally
      //   33	43	62	finally
      //   65	76	78	finally
      //   79	81	78	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.HandlerUtil
 * JD-Core Version:    0.7.0.1
 */