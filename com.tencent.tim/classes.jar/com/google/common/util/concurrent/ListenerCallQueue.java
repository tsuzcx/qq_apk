package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
final class ListenerCallQueue<L>
  implements Runnable
{
  private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
  private final Executor executor;
  @GuardedBy("this")
  private boolean isThreadScheduled;
  private final L listener;
  @GuardedBy("this")
  private final Queue<Callback<L>> waitQueue = Queues.newArrayDeque();
  
  ListenerCallQueue(L paramL, Executor paramExecutor)
  {
    this.listener = Preconditions.checkNotNull(paramL);
    this.executor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }
  
  void add(Callback<L> paramCallback)
  {
    try
    {
      this.waitQueue.add(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  void execute()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        if (!this.isThreadScheduled)
        {
          this.isThreadScheduled = true;
          if (i == 0) {}
        }
        i = 0;
      }
      finally
      {
        try
        {
          this.executor.execute(this);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          try
          {
            this.isThreadScheduled = false;
            logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, localRuntimeException);
            throw localRuntimeException;
          }
          finally {}
        }
        localObject1 = finally;
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 82	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   10: invokestatic 117	com/google/common/base/Preconditions:checkState	(Z)V
    //   13: aload_0
    //   14: getfield 55	com/google/common/util/concurrent/ListenerCallQueue:waitQueue	Ljava/util/Queue;
    //   17: invokeinterface 121 1 0
    //   22: checkcast 9	com/google/common/util/concurrent/ListenerCallQueue$Callback
    //   25: astore_3
    //   26: aload_3
    //   27: ifnonnull +11 -> 38
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 82	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 63	com/google/common/util/concurrent/ListenerCallQueue:listener	Ljava/lang/Object;
    //   45: invokevirtual 125	com/google/common/util/concurrent/ListenerCallQueue$Callback:call	(Ljava/lang/Object;)V
    //   48: goto -44 -> 4
    //   51: astore 4
    //   53: getstatic 42	com/google/common/util/concurrent/ListenerCallQueue:logger	Ljava/util/logging/Logger;
    //   56: getstatic 91	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   59: new 93	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   66: ldc 127
    //   68: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: getfield 63	com/google/common/util/concurrent/ListenerCallQueue:listener	Ljava/lang/Object;
    //   75: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: ldc 129
    //   80: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_3
    //   84: invokestatic 133	com/google/common/util/concurrent/ListenerCallQueue$Callback:access$000	(Lcom/google/common/util/concurrent/ListenerCallQueue$Callback;)Ljava/lang/String;
    //   87: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: aload 4
    //   95: invokevirtual 112	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: goto -94 -> 4
    //   101: astore_3
    //   102: iload_1
    //   103: ifeq +12 -> 115
    //   106: aload_0
    //   107: monitorenter
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 82	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_3
    //   116: athrow
    //   117: astore_3
    //   118: iconst_1
    //   119: istore_1
    //   120: iload_1
    //   121: istore_2
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_3
    //   125: athrow
    //   126: astore_3
    //   127: goto -25 -> 102
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: iload_2
    //   137: istore_1
    //   138: goto -18 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	ListenerCallQueue
    //   3	135	1	i	int
    //   1	136	2	j	int
    //   25	59	3	localCallback	Callback
    //   101	15	3	localObject1	Object
    //   117	8	3	localObject2	Object
    //   126	1	3	localObject3	Object
    //   130	4	3	localObject4	Object
    //   135	1	3	localObject5	Object
    //   51	43	4	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   40	48	51	java/lang/RuntimeException
    //   4	6	101	finally
    //   40	48	101	finally
    //   53	98	101	finally
    //   6	26	117	finally
    //   30	35	117	finally
    //   38	40	117	finally
    //   124	126	126	finally
    //   108	115	130	finally
    //   131	133	130	finally
    //   35	37	135	finally
    //   122	124	135	finally
  }
  
  static abstract class Callback<L>
  {
    private final String methodCall;
    
    Callback(String paramString)
    {
      this.methodCall = paramString;
    }
    
    abstract void call(L paramL);
    
    void enqueueOn(Iterable<ListenerCallQueue<L>> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        ((ListenerCallQueue)paramIterable.next()).add(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ListenerCallQueue
 * JD-Core Version:    0.7.0.1
 */