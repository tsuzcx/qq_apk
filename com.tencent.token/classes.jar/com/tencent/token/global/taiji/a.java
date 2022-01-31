package com.tencent.token.global.taiji;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  implements p, ThreadFactory
{
  private final ThreadGroup b = new ThreadGroup("TMS-COMMON");
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d = "CTPl-" + a.getAndIncrement() + "-Td-";
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
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