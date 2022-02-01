package com.tencent.token.global.taiji;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  implements h, ThreadFactory
{
  private final ThreadGroup b = new ThreadGroup("TMS-COMMON");
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d;
  
  a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CTPl-");
    localStringBuilder.append(a.getAndIncrement());
    localStringBuilder.append("-Td-");
    this.d = localStringBuilder.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
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
 * Qualified Name:     com.tencent.token.global.taiji.a
 * JD-Core Version:    0.7.0.1
 */