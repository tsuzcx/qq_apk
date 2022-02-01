package com.tencent.qqmail.network.filter;

import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashMap;

public class TaskFilter
{
  private static HashMap<String, WrapRunnable> taskCache = new HashMap();
  
  public static void replaceTaskInBackground(String paramString, Runnable paramRunnable)
  {
    try
    {
      WrapRunnable localWrapRunnable2 = (WrapRunnable)taskCache.get(paramString);
      WrapRunnable localWrapRunnable1 = localWrapRunnable2;
      if (localWrapRunnable2 == null)
      {
        localWrapRunnable1 = new WrapRunnable(paramString);
        taskCache.put(paramString, localWrapRunnable1);
      }
      localWrapRunnable1.replace(paramRunnable);
      return;
    }
    finally {}
  }
  
  static class WrapRunnable
    implements Runnable
  {
    private volatile Runnable task;
    private volatile String taskId;
    
    public WrapRunnable(String paramString)
    {
      this.taskId = paramString;
    }
    
    private void replace(Runnable paramRunnable)
    {
      try
      {
        this.task = paramRunnable;
        Threads.replaceCallbackInBackground(this, 100L);
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 29	com/tencent/qqmail/network/filter/TaskFilter$WrapRunnable:task	Ljava/lang/Runnable;
      //   6: astore_1
      //   7: aload_0
      //   8: aconst_null
      //   9: putfield 29	com/tencent/qqmail/network/filter/TaskFilter$WrapRunnable:task	Ljava/lang/Runnable;
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_1
      //   19: invokeinterface 40 1 0
      //   24: ldc 8
      //   26: monitorenter
      //   27: aload_0
      //   28: monitorenter
      //   29: aload_0
      //   30: getfield 29	com/tencent/qqmail/network/filter/TaskFilter$WrapRunnable:task	Ljava/lang/Runnable;
      //   33: ifnonnull +14 -> 47
      //   36: invokestatic 44	com/tencent/qqmail/network/filter/TaskFilter:access$100	()Ljava/util/HashMap;
      //   39: aload_0
      //   40: getfield 20	com/tencent/qqmail/network/filter/TaskFilter$WrapRunnable:taskId	Ljava/lang/String;
      //   43: invokevirtual 50	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   46: pop
      //   47: aload_0
      //   48: monitorexit
      //   49: ldc 8
      //   51: monitorexit
      //   52: return
      //   53: astore_1
      //   54: aload_0
      //   55: monitorexit
      //   56: aload_1
      //   57: athrow
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      //   63: astore_1
      //   64: ldc 8
      //   66: monitorexit
      //   67: aload_1
      //   68: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	69	0	this	WrapRunnable
      //   6	13	1	localRunnable	Runnable
      //   53	4	1	localObject1	Object
      //   58	4	1	localObject2	Object
      //   63	5	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	14	53	finally
      //   54	56	53	finally
      //   29	47	58	finally
      //   47	49	58	finally
      //   59	61	58	finally
      //   27	29	63	finally
      //   49	52	63	finally
      //   61	63	63	finally
      //   64	67	63	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.network.filter.TaskFilter
 * JD-Core Version:    0.7.0.1
 */