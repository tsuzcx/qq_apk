package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Beta
@GwtCompatible(emulated=true)
public final class Uninterruptibles
{
  /* Error */
  @GwtIncompatible
  public static void awaitUninterruptibly(java.util.concurrent.CountDownLatch paramCountDownLatch)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 23	java/util/concurrent/CountDownLatch:await	()V
    //   6: iload_1
    //   7: ifeq +9 -> 16
    //   10: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   16: return
    //   17: astore_2
    //   18: iconst_1
    //   19: istore_1
    //   20: goto -18 -> 2
    //   23: astore_0
    //   24: iload_1
    //   25: ifeq +9 -> 34
    //   28: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   31: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   34: aload_0
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramCountDownLatch	java.util.concurrent.CountDownLatch
    //   1	24	1	i	int
    //   17	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	6	17	java/lang/InterruptedException
    //   2	6	23	finally
  }
  
  /* Error */
  @GwtIncompatible
  @com.google.errorprone.annotations.CanIgnoreReturnValue
  public static boolean awaitUninterruptibly(java.util.concurrent.CountDownLatch paramCountDownLatch, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: iload 6
    //   8: istore 4
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 41	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   15: lstore 7
    //   17: iload 6
    //   19: istore 4
    //   21: invokestatic 47	java/lang/System:nanoTime	()J
    //   24: lstore 9
    //   26: lload 7
    //   28: lstore_1
    //   29: iload 5
    //   31: istore 4
    //   33: aload_0
    //   34: lload_1
    //   35: getstatic 51	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   38: invokevirtual 54	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   41: istore 11
    //   43: iload 5
    //   45: ifeq +9 -> 54
    //   48: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   51: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   54: iload 11
    //   56: ireturn
    //   57: astore_3
    //   58: iconst_1
    //   59: istore 4
    //   61: iconst_1
    //   62: istore 5
    //   64: invokestatic 47	java/lang/System:nanoTime	()J
    //   67: lstore_1
    //   68: lload 9
    //   70: lload 7
    //   72: ladd
    //   73: lload_1
    //   74: lsub
    //   75: lstore_1
    //   76: goto -47 -> 29
    //   79: astore_0
    //   80: iload 4
    //   82: ifeq +9 -> 91
    //   85: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   88: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramCountDownLatch	java.util.concurrent.CountDownLatch
    //   0	93	1	paramLong	long
    //   0	93	3	paramTimeUnit	TimeUnit
    //   8	73	4	i	int
    //   4	59	5	j	int
    //   1	17	6	k	int
    //   15	56	7	l1	long
    //   24	45	9	l2	long
    //   41	14	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	43	57	java/lang/InterruptedException
    //   10	17	79	finally
    //   21	26	79	finally
    //   33	43	79	finally
    //   64	68	79	finally
  }
  
  /* Error */
  @com.google.errorprone.annotations.CanIgnoreReturnValue
  public static <V> V getUninterruptibly(java.util.concurrent.Future<V> paramFuture)
    throws java.util.concurrent.ExecutionException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokeinterface 64 1 0
    //   8: astore_2
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   19: aload_2
    //   20: areturn
    //   21: astore_2
    //   22: iconst_1
    //   23: istore_1
    //   24: goto -22 -> 2
    //   27: astore_0
    //   28: iload_1
    //   29: ifeq +9 -> 38
    //   32: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramFuture	java.util.concurrent.Future<V>
    //   1	28	1	i	int
    //   8	12	2	localObject	Object
    //   21	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	21	java/lang/InterruptedException
    //   2	9	27	finally
  }
  
  /* Error */
  @GwtIncompatible
  @com.google.errorprone.annotations.CanIgnoreReturnValue
  public static <V> V getUninterruptibly(java.util.concurrent.Future<V> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    throws java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: iload 6
    //   8: istore 4
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 41	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   15: lstore 7
    //   17: iload 6
    //   19: istore 4
    //   21: invokestatic 47	java/lang/System:nanoTime	()J
    //   24: lstore 9
    //   26: lload 7
    //   28: lstore_1
    //   29: iload 5
    //   31: istore 4
    //   33: aload_0
    //   34: lload_1
    //   35: getstatic 51	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   38: invokeinterface 73 4 0
    //   43: astore_3
    //   44: iload 5
    //   46: ifeq +9 -> 55
    //   49: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   55: aload_3
    //   56: areturn
    //   57: astore_3
    //   58: iconst_1
    //   59: istore 4
    //   61: iconst_1
    //   62: istore 5
    //   64: invokestatic 47	java/lang/System:nanoTime	()J
    //   67: lstore_1
    //   68: lload 9
    //   70: lload 7
    //   72: ladd
    //   73: lload_1
    //   74: lsub
    //   75: lstore_1
    //   76: goto -47 -> 29
    //   79: astore_0
    //   80: iload 4
    //   82: ifeq +9 -> 91
    //   85: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   88: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramFuture	java.util.concurrent.Future<V>
    //   0	93	1	paramLong	long
    //   0	93	3	paramTimeUnit	TimeUnit
    //   8	73	4	i	int
    //   4	59	5	j	int
    //   1	17	6	k	int
    //   15	56	7	l1	long
    //   24	45	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   33	44	57	java/lang/InterruptedException
    //   10	17	79	finally
    //   21	26	79	finally
    //   33	44	79	finally
    //   64	68	79	finally
  }
  
  /* Error */
  @GwtIncompatible
  public static void joinUninterruptibly(java.lang.Thread paramThread)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 79	java/lang/Thread:join	()V
    //   6: iload_1
    //   7: ifeq +9 -> 16
    //   10: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   16: return
    //   17: astore_2
    //   18: iconst_1
    //   19: istore_1
    //   20: goto -18 -> 2
    //   23: astore_0
    //   24: iload_1
    //   25: ifeq +9 -> 34
    //   28: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   31: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   34: aload_0
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramThread	java.lang.Thread
    //   1	24	1	i	int
    //   17	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	6	17	java/lang/InterruptedException
    //   2	6	23	finally
  }
  
  /* Error */
  @GwtIncompatible
  public static void joinUninterruptibly(java.lang.Thread paramThread, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 86	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: iconst_0
    //   6: istore 6
    //   8: iconst_0
    //   9: istore 5
    //   11: iload 6
    //   13: istore 4
    //   15: aload_3
    //   16: lload_1
    //   17: invokevirtual 41	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   20: lstore 7
    //   22: iload 6
    //   24: istore 4
    //   26: invokestatic 47	java/lang/System:nanoTime	()J
    //   29: lstore 9
    //   31: lload 7
    //   33: lstore_1
    //   34: iload 5
    //   36: istore 4
    //   38: getstatic 51	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   41: aload_0
    //   42: lload_1
    //   43: invokevirtual 90	java/util/concurrent/TimeUnit:timedJoin	(Ljava/lang/Thread;J)V
    //   46: iload 5
    //   48: ifeq +9 -> 57
    //   51: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   54: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   57: return
    //   58: astore_3
    //   59: iconst_1
    //   60: istore 4
    //   62: iconst_1
    //   63: istore 5
    //   65: invokestatic 47	java/lang/System:nanoTime	()J
    //   68: lstore_1
    //   69: lload 9
    //   71: lload 7
    //   73: ladd
    //   74: lload_1
    //   75: lsub
    //   76: lstore_1
    //   77: goto -43 -> 34
    //   80: astore_0
    //   81: iload 4
    //   83: ifeq +9 -> 92
    //   86: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   89: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramThread	java.lang.Thread
    //   0	94	1	paramLong	long
    //   0	94	3	paramTimeUnit	TimeUnit
    //   13	69	4	i	int
    //   9	55	5	j	int
    //   6	17	6	k	int
    //   20	52	7	l1	long
    //   29	41	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   38	46	58	java/lang/InterruptedException
    //   15	22	80	finally
    //   26	31	80	finally
    //   38	46	80	finally
    //   65	69	80	finally
  }
  
  /* Error */
  @GwtIncompatible
  public static <E> void putUninterruptibly(java.util.concurrent.BlockingQueue<E> paramBlockingQueue, E paramE)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokeinterface 98 2 0
    //   9: iload_2
    //   10: ifeq +9 -> 19
    //   13: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   19: return
    //   20: astore_3
    //   21: iconst_1
    //   22: istore_2
    //   23: goto -21 -> 2
    //   26: astore_0
    //   27: iload_2
    //   28: ifeq +9 -> 37
    //   31: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   34: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	paramBlockingQueue	java.util.concurrent.BlockingQueue<E>
    //   0	39	1	paramE	E
    //   1	27	2	i	int
    //   20	1	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	20	java/lang/InterruptedException
    //   2	9	26	finally
  }
  
  /* Error */
  @GwtIncompatible
  public static void sleepUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iload 5
    //   8: istore_3
    //   9: aload_2
    //   10: lload_0
    //   11: invokevirtual 41	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   14: lstore 6
    //   16: iload 5
    //   18: istore_3
    //   19: invokestatic 47	java/lang/System:nanoTime	()J
    //   22: lstore 8
    //   24: lload 6
    //   26: lstore_0
    //   27: iload 4
    //   29: istore_3
    //   30: getstatic 51	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   33: lload_0
    //   34: invokevirtual 105	java/util/concurrent/TimeUnit:sleep	(J)V
    //   37: iload 4
    //   39: ifeq +9 -> 48
    //   42: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   45: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   48: return
    //   49: astore_2
    //   50: iconst_1
    //   51: istore_3
    //   52: iconst_1
    //   53: istore 4
    //   55: invokestatic 47	java/lang/System:nanoTime	()J
    //   58: lstore_0
    //   59: lload 8
    //   61: lload 6
    //   63: ladd
    //   64: lload_0
    //   65: lsub
    //   66: lstore_0
    //   67: goto -40 -> 27
    //   70: astore_2
    //   71: iload_3
    //   72: ifeq +9 -> 81
    //   75: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   78: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramLong	long
    //   0	83	2	paramTimeUnit	TimeUnit
    //   8	64	3	i	int
    //   4	50	4	j	int
    //   1	16	5	k	int
    //   14	48	6	l1	long
    //   22	38	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   30	37	49	java/lang/InterruptedException
    //   9	16	70	finally
    //   19	24	70	finally
    //   30	37	70	finally
    //   55	59	70	finally
  }
  
  /* Error */
  @GwtIncompatible
  public static <E> E takeUninterruptibly(java.util.concurrent.BlockingQueue<E> paramBlockingQueue)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokeinterface 110 1 0
    //   8: astore_2
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   19: aload_2
    //   20: areturn
    //   21: astore_2
    //   22: iconst_1
    //   23: istore_1
    //   24: goto -22 -> 2
    //   27: astore_0
    //   28: iload_1
    //   29: ifeq +9 -> 38
    //   32: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramBlockingQueue	java.util.concurrent.BlockingQueue<E>
    //   1	28	1	i	int
    //   8	12	2	localObject	Object
    //   21	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	21	java/lang/InterruptedException
    //   2	9	27	finally
  }
  
  /* Error */
  @GwtIncompatible
  public static boolean tryAcquireUninterruptibly(Semaphore paramSemaphore, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: iload 7
    //   8: istore 5
    //   10: aload 4
    //   12: lload_2
    //   13: invokevirtual 41	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   16: lstore 8
    //   18: iload 7
    //   20: istore 5
    //   22: invokestatic 47	java/lang/System:nanoTime	()J
    //   25: lstore 10
    //   27: lload 8
    //   29: lstore_2
    //   30: iload 6
    //   32: istore 5
    //   34: aload_0
    //   35: iload_1
    //   36: lload_2
    //   37: getstatic 51	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   40: invokevirtual 119	java/util/concurrent/Semaphore:tryAcquire	(IJLjava/util/concurrent/TimeUnit;)Z
    //   43: istore 12
    //   45: iload 6
    //   47: ifeq +9 -> 56
    //   50: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   53: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   56: iload 12
    //   58: ireturn
    //   59: astore 4
    //   61: iconst_1
    //   62: istore 5
    //   64: iconst_1
    //   65: istore 6
    //   67: invokestatic 47	java/lang/System:nanoTime	()J
    //   70: lstore_2
    //   71: lload 10
    //   73: lload 8
    //   75: ladd
    //   76: lload_2
    //   77: lsub
    //   78: lstore_2
    //   79: goto -49 -> 30
    //   82: astore_0
    //   83: iload 5
    //   85: ifeq +9 -> 94
    //   88: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   91: invokevirtual 32	java/lang/Thread:interrupt	()V
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramSemaphore	Semaphore
    //   0	96	1	paramInt	int
    //   0	96	2	paramLong	long
    //   0	96	4	paramTimeUnit	TimeUnit
    //   8	76	5	i	int
    //   4	62	6	j	int
    //   1	18	7	k	int
    //   16	58	8	l1	long
    //   25	47	10	l2	long
    //   43	14	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   34	45	59	java/lang/InterruptedException
    //   10	18	82	finally
    //   22	27	82	finally
    //   34	45	82	finally
    //   67	71	82	finally
  }
  
  @GwtIncompatible
  public static boolean tryAcquireUninterruptibly(Semaphore paramSemaphore, long paramLong, TimeUnit paramTimeUnit)
  {
    return tryAcquireUninterruptibly(paramSemaphore, 1, paramLong, paramTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Uninterruptibles
 * JD-Core Version:    0.7.0.1
 */