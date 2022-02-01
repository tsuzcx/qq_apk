package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueWorkerThread
{
  private LinkedBlockingQueue<ThreadObject> aQ = new LinkedBlockingQueue();
  private boolean aR = false;
  private int aS = 1;
  private Vector<WorkerThread> aT = new Vector();
  private Handler aU = new QueueWorkerThread.1(this);
  private Object lock = new byte[0];
  private String name = "";
  private int priority = 1;
  
  public QueueWorkerThread(int paramInt, String paramString)
  {
    this(paramInt, paramString, 1);
  }
  
  public QueueWorkerThread(int paramInt1, String paramString, int paramInt2)
  {
    this.aS = paramInt2;
    this.name = paramString;
    this.priority = paramInt1;
  }
  
  public int add(ThreadObject paramThreadObject)
  {
    int j = 0;
    int i;
    if (paramThreadObject == null)
    {
      Log.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      i = -1;
    }
    do
    {
      do
      {
        return i;
        try
        {
          if (!this.aQ.offer(paramThreadObject, 1L, TimeUnit.MILLISECONDS))
          {
            Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
            return -2;
          }
        }
        catch (Exception paramThreadObject)
        {
          Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + paramThreadObject.getMessage());
          paramThreadObject.printStackTrace();
          return -3;
        }
        if (this.aT.size() == 0) {
          break;
        }
        i = j;
      } while (this.aQ.size() <= 0);
      i = j;
    } while (this.aS <= this.aT.size());
    new WorkerThread((byte)0).start();
    return 0;
  }
  
  public int getQueueSize()
  {
    return this.aQ.size();
  }
  
  public boolean isDead()
  {
    return (this.aT == null) || (this.aT.size() == 0);
  }
  
  public void pause(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      this.aR = paramBoolean;
      if (!paramBoolean) {}
      synchronized (this.lock)
      {
        this.lock.notifyAll();
        return;
      }
    }
  }
  
  public static abstract interface ThreadObject
  {
    public abstract boolean doInBackground();
    
    public abstract boolean onPostExecute();
  }
  
  final class WorkerThread
    extends Thread
  {
    private int aW = 60;
    
    private WorkerThread()
    {
      super();
      setPriority(QueueWorkerThread.b(QueueWorkerThread.this));
      QueueWorkerThread.c(QueueWorkerThread.this).add(this);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 24	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
      //   4: ifle +136 -> 140
      //   7: aload_0
      //   8: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   11: invokestatic 54	com/tencent/mm/sdk/platformtools/QueueWorkerThread:d	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
      //   14: astore_1
      //   15: aload_1
      //   16: monitorenter
      //   17: aload_0
      //   18: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   21: invokestatic 58	com/tencent/mm/sdk/platformtools/QueueWorkerThread:e	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Z
      //   24: ifeq +13 -> 37
      //   27: aload_0
      //   28: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   31: invokestatic 54	com/tencent/mm/sdk/platformtools/QueueWorkerThread:d	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
      //   34: invokevirtual 63	java/lang/Object:wait	()V
      //   37: aload_1
      //   38: monitorexit
      //   39: aload_0
      //   40: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   43: invokestatic 67	com/tencent/mm/sdk/platformtools/QueueWorkerThread:f	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
      //   46: ldc2_w 68
      //   49: getstatic 75	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   52: invokevirtual 81	java/util/concurrent/LinkedBlockingQueue:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
      //   55: checkcast 83	com/tencent/mm/sdk/platformtools/QueueWorkerThread$ThreadObject
      //   58: astore_1
      //   59: aload_1
      //   60: ifnonnull +39 -> 99
      //   63: aload_0
      //   64: aload_0
      //   65: getfield 24	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
      //   68: iconst_1
      //   69: isub
      //   70: putfield 24	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
      //   73: goto -73 -> 0
      //   76: astore_2
      //   77: aload_2
      //   78: invokevirtual 86	java/lang/Exception:printStackTrace	()V
      //   81: goto -44 -> 37
      //   84: astore_2
      //   85: aload_1
      //   86: monitorexit
      //   87: aload_2
      //   88: athrow
      //   89: astore_1
      //   90: aload_1
      //   91: invokevirtual 86	java/lang/Exception:printStackTrace	()V
      //   94: aconst_null
      //   95: astore_1
      //   96: goto -37 -> 59
      //   99: aload_0
      //   100: bipush 60
      //   102: putfield 24	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
      //   105: aload_1
      //   106: invokeinterface 90 1 0
      //   111: ifeq -111 -> 0
      //   114: aload_0
      //   115: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   118: invokestatic 94	com/tencent/mm/sdk/platformtools/QueueWorkerThread:g	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Landroid/os/Handler;
      //   121: aload_0
      //   122: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   125: invokestatic 94	com/tencent/mm/sdk/platformtools/QueueWorkerThread:g	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Landroid/os/Handler;
      //   128: iconst_0
      //   129: aload_1
      //   130: invokevirtual 100	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   133: invokevirtual 104	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   136: pop
      //   137: goto -137 -> 0
      //   140: aload_0
      //   141: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   144: invokestatic 36	com/tencent/mm/sdk/platformtools/QueueWorkerThread:c	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
      //   147: aload_0
      //   148: invokevirtual 107	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   151: pop
      //   152: ldc 109
      //   154: new 111	java/lang/StringBuilder
      //   157: dup
      //   158: ldc 113
      //   160: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   163: aload_0
      //   164: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   167: invokestatic 67	com/tencent/mm/sdk/platformtools/QueueWorkerThread:f	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
      //   170: invokevirtual 118	java/util/concurrent/LinkedBlockingQueue:size	()I
      //   173: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   176: ldc 124
      //   178: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   181: aload_0
      //   182: getfield 15	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
      //   185: invokestatic 36	com/tencent/mm/sdk/platformtools/QueueWorkerThread:c	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
      //   188: invokevirtual 128	java/util/Vector:size	()I
      //   191: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   194: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   197: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   200: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	201	0	this	WorkerThread
      //   14	72	1	localObject1	Object
      //   89	2	1	localException1	Exception
      //   95	35	1	localObject2	Object
      //   76	2	2	localException2	Exception
      //   84	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   17	37	76	java/lang/Exception
      //   17	37	84	finally
      //   37	39	84	finally
      //   77	81	84	finally
      //   39	59	89	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread
 * JD-Core Version:    0.7.0.1
 */