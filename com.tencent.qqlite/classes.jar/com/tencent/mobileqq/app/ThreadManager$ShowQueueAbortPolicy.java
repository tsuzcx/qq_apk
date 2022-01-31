package com.tencent.mobileqq.app;

import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class ThreadManager$ShowQueueAbortPolicy
  extends ThreadPoolExecutor.AbortPolicy
{
  /* Error */
  public void rejectedExecution(java.lang.Runnable paramRunnable, java.util.concurrent.ThreadPoolExecutor paramThreadPoolExecutor)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 23	java/util/concurrent/ThreadPoolExecutor:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +96 -> 102
    //   9: aload_3
    //   10: invokeinterface 29 1 0
    //   15: ifne +87 -> 102
    //   18: aload_3
    //   19: invokeinterface 33 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 38 1 0
    //   31: ifeq +71 -> 102
    //   34: aload_3
    //   35: invokeinterface 42 1 0
    //   40: checkcast 44	java/lang/Runnable
    //   43: astore 4
    //   45: aload 4
    //   47: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: ldc 52
    //   52: invokevirtual 58	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   55: astore 5
    //   57: aload 5
    //   59: iconst_1
    //   60: invokevirtual 64	java/lang/reflect/Field:setAccessible	(Z)V
    //   63: new 66	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   70: ldc 69
    //   72: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 5
    //   77: aload 4
    //   79: invokevirtual 77	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   85: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 90	com/tencent/widget/TraceUtils:a	(Ljava/lang/String;)V
    //   94: goto -69 -> 25
    //   97: astore_3
    //   98: aload_3
    //   99: invokevirtual 93	java/lang/NoSuchFieldException:printStackTrace	()V
    //   102: aload_0
    //   103: aload_1
    //   104: aload_2
    //   105: invokespecial 95	java/util/concurrent/ThreadPoolExecutor$AbortPolicy:rejectedExecution	(Ljava/lang/Runnable;Ljava/util/concurrent/ThreadPoolExecutor;)V
    //   108: return
    //   109: astore_3
    //   110: aload_3
    //   111: invokevirtual 96	java/lang/IllegalArgumentException:printStackTrace	()V
    //   114: goto -12 -> 102
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 97	java/lang/IllegalAccessException:printStackTrace	()V
    //   122: goto -20 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ShowQueueAbortPolicy
    //   0	125	1	paramRunnable	java.lang.Runnable
    //   0	125	2	paramThreadPoolExecutor	java.util.concurrent.ThreadPoolExecutor
    //   4	31	3	localObject	java.lang.Object
    //   97	2	3	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   109	2	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   117	2	3	localIllegalAccessException	java.lang.IllegalAccessException
    //   43	35	4	localRunnable	java.lang.Runnable
    //   55	21	5	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   18	25	97	java/lang/NoSuchFieldException
    //   25	94	97	java/lang/NoSuchFieldException
    //   18	25	109	java/lang/IllegalArgumentException
    //   25	94	109	java/lang/IllegalArgumentException
    //   18	25	117	java/lang/IllegalAccessException
    //   25	94	117	java/lang/IllegalAccessException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager.ShowQueueAbortPolicy
 * JD-Core Version:    0.7.0.1
 */