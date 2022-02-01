package com.b.a.a;

import com.b.a.o.a;
import com.b.a.o.b;
import com.b.a.t;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class k<T>
  implements o.a, o.b<T>, Future<T>
{
  private boolean a = false;
  private T b;
  private t c;
  
  public static <E> k<E> a()
  {
    return new k();
  }
  
  private T a(Long paramLong)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    try
    {
      if (this.c != null) {
        throw new ExecutionException(this.c);
      }
    }
    finally {}
    if (this.a) {}
    for (paramLong = this.b;; paramLong = this.b)
    {
      return paramLong;
      if (paramLong == null) {
        wait(0L);
      }
      while (this.c != null)
      {
        throw new ExecutionException(this.c);
        if (paramLong.longValue() > 0L) {
          wait(paramLong.longValue());
        }
      }
      if (!this.a) {
        throw new TimeoutException();
      }
    }
  }
  
  public final void a(t paramt)
  {
    try
    {
      this.c = paramt;
      notifyAll();
      return;
    }
    finally
    {
      paramt = finally;
      throw paramt;
    }
  }
  
  public final void a(T paramT)
  {
    try
    {
      this.a = true;
      this.b = paramT;
      notifyAll();
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public final T get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      Object localObject = a(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public final T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  /* Error */
  public final boolean isDone()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/b/a/a/k:a	Z
    //   6: ifne +19 -> 25
    //   9: aload_0
    //   10: getfield 38	com/b/a/a/k:c	Lcom/b/a/t;
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 94	com/b/a/a/k:isCancelled	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +9 -> 31
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_1
    //   33: goto -6 -> 27
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	k
    //   20	13	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	36	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */