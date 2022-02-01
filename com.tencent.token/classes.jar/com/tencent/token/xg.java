package com.tencent.token;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class xg
  implements xj, ThreadFactory
{
  private final ThreadGroup b = new ThreadGroup("TMS-COMMON");
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d;
  
  xg()
  {
    StringBuilder localStringBuilder = new StringBuilder("CTPl-");
    localStringBuilder.append(a.getAndIncrement());
    localStringBuilder.append("-Td-");
    this.d = localStringBuilder.toString();
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.c.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xg
 * JD-Core Version:    0.7.0.1
 */