package com.tencent.token.global.taiji;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class g
  implements f.a, h
{
  private final ThreadGroup b = new ThreadGroup("TMS_FREE_POOL_" + a.getAndIncrement());
  private final AtomicInteger c = new AtomicInteger(1);
  private HashMap<Thread, i.c> d = new HashMap();
  
  public Thread a(Runnable paramRunnable, String paramString, long paramLong)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = paramRunnable.getClass().getName();
    }
    paramString = "FreeThread-" + this.c.getAndIncrement() + "-" + str;
    paramRunnable = new f(this.b, paramRunnable, paramString, paramLong);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
  
  public void a(Thread paramThread, Runnable paramRunnable) {}
  
  public void b(Thread paramThread, Runnable paramRunnable) {}
  
  public void c(Thread paramThread, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.g
 * JD-Core Version:    0.7.0.1
 */