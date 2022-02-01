package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
final class SerializingExecutor
  implements Executor
{
  private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
  private final Executor executor;
  private final Object internalLock = new Object();
  @GuardedBy("internalLock")
  private boolean isWorkerRunning = false;
  @GuardedBy("internalLock")
  private final Deque<Runnable> queue = new ArrayDeque();
  @GuardedBy("internalLock")
  private int suspensions = 0;
  
  public SerializingExecutor(Executor paramExecutor)
  {
    this.executor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }
  
  /* Error */
  private void startQueueWorker()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/google/common/util/concurrent/SerializingExecutor:internalLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 53	com/google/common/util/concurrent/SerializingExecutor:queue	Ljava/util/Deque;
    //   11: invokeinterface 84 1 0
    //   16: ifnonnull +6 -> 22
    //   19: aload_1
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 57	com/google/common/util/concurrent/SerializingExecutor:suspensions	I
    //   26: ifle +11 -> 37
    //   29: aload_1
    //   30: monitorexit
    //   31: return
    //   32: astore_2
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    //   37: aload_0
    //   38: getfield 55	com/google/common/util/concurrent/SerializingExecutor:isWorkerRunning	Z
    //   41: ifeq +6 -> 47
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 55	com/google/common/util/concurrent/SerializingExecutor:isWorkerRunning	Z
    //   52: aload_1
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 67	com/google/common/util/concurrent/SerializingExecutor:executor	Ljava/util/concurrent/Executor;
    //   58: new 10	com/google/common/util/concurrent/SerializingExecutor$QueueWorker
    //   61: dup
    //   62: aload_0
    //   63: aconst_null
    //   64: invokespecial 87	com/google/common/util/concurrent/SerializingExecutor$QueueWorker:<init>	(Lcom/google/common/util/concurrent/SerializingExecutor;Lcom/google/common/util/concurrent/SerializingExecutor$1;)V
    //   67: invokeinterface 91 2 0
    //   72: return
    //   73: astore_2
    //   74: aload_0
    //   75: getfield 59	com/google/common/util/concurrent/SerializingExecutor:internalLock	Ljava/lang/Object;
    //   78: astore_1
    //   79: aload_1
    //   80: monitorenter
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 55	com/google/common/util/concurrent/SerializingExecutor:isWorkerRunning	Z
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	SerializingExecutor
    //   4	88	1	localObject1	Object
    //   32	4	2	localObject2	Object
    //   73	16	2	localObject3	Object
    //   90	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	32	finally
    //   22	31	32	finally
    //   33	35	32	finally
    //   37	46	32	finally
    //   47	54	32	finally
    //   54	72	73	finally
    //   81	88	90	finally
    //   91	93	90	finally
  }
  
  public void execute(Runnable paramRunnable)
  {
    synchronized (this.internalLock)
    {
      this.queue.add(paramRunnable);
      startQueueWorker();
      return;
    }
  }
  
  public void executeFirst(Runnable paramRunnable)
  {
    synchronized (this.internalLock)
    {
      this.queue.addFirst(paramRunnable);
      startQueueWorker();
      return;
    }
  }
  
  public void resume()
  {
    synchronized (this.internalLock)
    {
      if (this.suspensions > 0)
      {
        bool = true;
        Preconditions.checkState(bool);
        this.suspensions -= 1;
        startQueueWorker();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void suspend()
  {
    synchronized (this.internalLock)
    {
      this.suspensions += 1;
      return;
    }
  }
  
  final class QueueWorker
    implements Runnable
  {
    private QueueWorker() {}
    
    private void workOnQueue()
    {
      for (;;)
      {
        Runnable localRunnable = null;
        synchronized (SerializingExecutor.this.internalLock)
        {
          if (SerializingExecutor.this.suspensions == 0) {
            localRunnable = (Runnable)SerializingExecutor.this.queue.poll();
          }
          if (localRunnable == null)
          {
            SerializingExecutor.access$202(SerializingExecutor.this, false);
            return;
          }
          try
          {
            localRunnable.run();
          }
          catch (RuntimeException localRuntimeException)
          {
            SerializingExecutor.log.log(Level.SEVERE, "Exception while executing runnable " + localRunnable, localRuntimeException);
          }
        }
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 86	com/google/common/util/concurrent/SerializingExecutor$QueueWorker:workOnQueue	()V
      //   4: return
      //   5: astore_2
      //   6: aload_0
      //   7: getfield 15	com/google/common/util/concurrent/SerializingExecutor$QueueWorker:this$0	Lcom/google/common/util/concurrent/SerializingExecutor;
      //   10: invokestatic 29	com/google/common/util/concurrent/SerializingExecutor:access$100	(Lcom/google/common/util/concurrent/SerializingExecutor;)Ljava/lang/Object;
      //   13: astore_1
      //   14: aload_1
      //   15: monitorenter
      //   16: aload_0
      //   17: getfield 15	com/google/common/util/concurrent/SerializingExecutor$QueueWorker:this$0	Lcom/google/common/util/concurrent/SerializingExecutor;
      //   20: iconst_0
      //   21: invokestatic 47	com/google/common/util/concurrent/SerializingExecutor:access$202	(Lcom/google/common/util/concurrent/SerializingExecutor;Z)Z
      //   24: pop
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      //   29: astore_2
      //   30: aload_1
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	QueueWorker
      //   13	18	1	localObject1	Object
      //   5	23	2	localError	java.lang.Error
      //   29	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   0	4	5	java/lang/Error
      //   16	27	29	finally
      //   30	32	29	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.SerializingExecutor
 * JD-Core Version:    0.7.0.1
 */