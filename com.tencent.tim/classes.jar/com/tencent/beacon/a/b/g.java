package com.tencent.beacon.a.b;

import android.support.annotation.NonNull;
import com.tencent.beacon.base.util.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public String a()
  {
    return "beacon-thread-" + this.a.getAndIncrement();
  }
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    try
    {
      paramRunnable = new Thread(paramRunnable, a());
      return paramRunnable;
    }
    catch (OutOfMemoryError paramRunnable)
    {
      c.b("[task] memory not enough, create thread failed.", new Object[0]);
      return null;
    }
    catch (Exception paramRunnable)
    {
      for (;;)
      {
        c.a(paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.b.g
 * JD-Core Version:    0.7.0.1
 */