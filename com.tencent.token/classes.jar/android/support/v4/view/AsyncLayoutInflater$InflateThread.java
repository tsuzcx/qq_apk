package android.support.v4.view;

import android.support.v4.util.Pools.SynchronizedPool;
import java.util.concurrent.ArrayBlockingQueue;

class AsyncLayoutInflater$InflateThread
  extends Thread
{
  private static final InflateThread sInstance = new InflateThread();
  private ArrayBlockingQueue mQueue = new ArrayBlockingQueue(10);
  private Pools.SynchronizedPool mRequestPool = new Pools.SynchronizedPool(10);
  
  static
  {
    sInstance.start();
  }
  
  public static InflateThread getInstance()
  {
    return sInstance;
  }
  
  public void enqueue(AsyncLayoutInflater.InflateRequest paramInflateRequest)
  {
    try
    {
      this.mQueue.put(paramInflateRequest);
      return;
    }
    catch (InterruptedException paramInflateRequest)
    {
      throw new RuntimeException("Failed to enqueue async inflate request", paramInflateRequest);
    }
  }
  
  public AsyncLayoutInflater.InflateRequest obtainRequest()
  {
    AsyncLayoutInflater.InflateRequest localInflateRequest2 = (AsyncLayoutInflater.InflateRequest)this.mRequestPool.acquire();
    AsyncLayoutInflater.InflateRequest localInflateRequest1 = localInflateRequest2;
    if (localInflateRequest2 == null) {
      localInflateRequest1 = new AsyncLayoutInflater.InflateRequest();
    }
    return localInflateRequest1;
  }
  
  public void releaseRequest(AsyncLayoutInflater.InflateRequest paramInflateRequest)
  {
    paramInflateRequest.callback = null;
    paramInflateRequest.inflater = null;
    paramInflateRequest.parent = null;
    paramInflateRequest.resid = 0;
    paramInflateRequest.view = null;
    this.mRequestPool.release(paramInflateRequest);
  }
  
  public void run()
  {
    for (;;)
    {
      runInner();
    }
  }
  
  /* Error */
  public void runInner()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	android/support/v4/view/AsyncLayoutInflater$InflateThread:mQueue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   4: invokevirtual 92	java/util/concurrent/ArrayBlockingQueue:take	()Ljava/lang/Object;
    //   7: checkcast 59	android/support/v4/view/AsyncLayoutInflater$InflateRequest
    //   10: astore_1
    //   11: aload_1
    //   12: aload_1
    //   13: getfield 69	android/support/v4/view/AsyncLayoutInflater$InflateRequest:inflater	Landroid/support/v4/view/AsyncLayoutInflater;
    //   16: getfield 98	android/support/v4/view/AsyncLayoutInflater:mInflater	Landroid/view/LayoutInflater;
    //   19: aload_1
    //   20: getfield 77	android/support/v4/view/AsyncLayoutInflater$InflateRequest:resid	I
    //   23: aload_1
    //   24: getfield 73	android/support/v4/view/AsyncLayoutInflater$InflateRequest:parent	Landroid/view/ViewGroup;
    //   27: iconst_0
    //   28: invokevirtual 104	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   31: putfield 81	android/support/v4/view/AsyncLayoutInflater$InflateRequest:view	Landroid/view/View;
    //   34: aload_1
    //   35: getfield 69	android/support/v4/view/AsyncLayoutInflater$InflateRequest:inflater	Landroid/support/v4/view/AsyncLayoutInflater;
    //   38: getfield 108	android/support/v4/view/AsyncLayoutInflater:mHandler	Landroid/os/Handler;
    //   41: iconst_0
    //   42: aload_1
    //   43: invokestatic 114	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 117	android/os/Message:sendToTarget	()V
    //   49: return
    //   50: astore_1
    //   51: ldc 119
    //   53: aload_1
    //   54: invokestatic 125	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   57: pop
    //   58: return
    //   59: astore_2
    //   60: ldc 119
    //   62: ldc 127
    //   64: aload_2
    //   65: invokestatic 130	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: goto -35 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	InflateThread
    //   10	33	1	localInflateRequest	AsyncLayoutInflater.InflateRequest
    //   50	4	1	localInterruptedException	InterruptedException
    //   59	6	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   0	11	50	java/lang/InterruptedException
    //   11	34	59	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.AsyncLayoutInflater.InflateThread
 * JD-Core Version:    0.7.0.1
 */