package com.tencent.mm.sdk.platformtools;

import java.util.Vector;

final class QueueWorkerThread$WorkerThread
  extends Thread
{
  private int aW = 60;
  
  private QueueWorkerThread$WorkerThread(QueueWorkerThread paramQueueWorkerThread)
  {
    super(QueueWorkerThread.a(paramQueueWorkerThread));
    setPriority(QueueWorkerThread.b(paramQueueWorkerThread));
    QueueWorkerThread.c(paramQueueWorkerThread).add(this);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
    //   4: ifle +136 -> 140
    //   7: aload_0
    //   8: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   11: invokestatic 53	com/tencent/mm/sdk/platformtools/QueueWorkerThread:d	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
    //   14: astore_1
    //   15: aload_1
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   21: invokestatic 57	com/tencent/mm/sdk/platformtools/QueueWorkerThread:e	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   31: invokestatic 53	com/tencent/mm/sdk/platformtools/QueueWorkerThread:d	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
    //   34: invokevirtual 62	java/lang/Object:wait	()V
    //   37: aload_1
    //   38: monitorexit
    //   39: aload_0
    //   40: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   43: invokestatic 66	com/tencent/mm/sdk/platformtools/QueueWorkerThread:f	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
    //   46: ldc2_w 67
    //   49: getstatic 74	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   52: invokevirtual 80	java/util/concurrent/LinkedBlockingQueue:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   55: checkcast 82	com/tencent/mm/sdk/platformtools/QueueWorkerThread$ThreadObject
    //   58: astore_1
    //   59: aload_1
    //   60: ifnonnull +39 -> 99
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 23	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
    //   68: iconst_1
    //   69: isub
    //   70: putfield 23	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
    //   73: goto -73 -> 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   81: goto -44 -> 37
    //   84: astore_2
    //   85: aload_1
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   94: aconst_null
    //   95: astore_1
    //   96: goto -37 -> 59
    //   99: aload_0
    //   100: bipush 60
    //   102: putfield 23	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aW	I
    //   105: aload_1
    //   106: invokeinterface 89 1 0
    //   111: ifeq -111 -> 0
    //   114: aload_0
    //   115: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   118: invokestatic 93	com/tencent/mm/sdk/platformtools/QueueWorkerThread:g	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Landroid/os/Handler;
    //   121: aload_0
    //   122: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   125: invokestatic 93	com/tencent/mm/sdk/platformtools/QueueWorkerThread:g	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Landroid/os/Handler;
    //   128: iconst_0
    //   129: aload_1
    //   130: invokevirtual 99	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   133: invokevirtual 103	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   136: pop
    //   137: goto -137 -> 0
    //   140: aload_0
    //   141: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   144: invokestatic 35	com/tencent/mm/sdk/platformtools/QueueWorkerThread:c	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
    //   147: aload_0
    //   148: invokevirtual 106	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: ldc 108
    //   154: new 110	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 112
    //   160: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   167: invokestatic 66	com/tencent/mm/sdk/platformtools/QueueWorkerThread:f	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
    //   170: invokevirtual 117	java/util/concurrent/LinkedBlockingQueue:size	()I
    //   173: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 123
    //   178: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_0
    //   182: getfield 12	com/tencent/mm/sdk/platformtools/QueueWorkerThread$WorkerThread:aV	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   185: invokestatic 35	com/tencent/mm/sdk/platformtools/QueueWorkerThread:c	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
    //   188: invokevirtual 127	java/util/Vector:size	()I
    //   191: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	WorkerThread
    //   14	72	1	localObject1	java.lang.Object
    //   89	2	1	localException1	java.lang.Exception
    //   95	35	1	localObject2	java.lang.Object
    //   76	2	2	localException2	java.lang.Exception
    //   84	4	2	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   17	37	76	java/lang/Exception
    //   17	37	84	finally
    //   37	39	84	finally
    //   77	81	84	finally
    //   39	59	89	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread.WorkerThread
 * JD-Core Version:    0.7.0.1
 */