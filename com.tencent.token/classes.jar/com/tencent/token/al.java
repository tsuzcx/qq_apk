package com.tencent.token;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class al
  implements ThreadFactory
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private final ThreadGroup b;
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d;
  
  al(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.b = ((ThreadGroup)localObject);
      this.d = (paramString + "-" + a.getAndIncrement() + "-thread-");
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    try
    {
      paramRunnable.setPriority(h.d);
      return paramRunnable;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.al
 * JD-Core Version:    0.7.0.1
 */