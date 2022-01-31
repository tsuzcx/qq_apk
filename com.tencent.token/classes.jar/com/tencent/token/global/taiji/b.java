package com.tencent.token.global.taiji;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b
  extends ThreadPoolExecutor
{
  private c a = null;
  
  public b(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, new a(), paramRejectedExecutionHandler);
  }
  
  public void a(c paramc)
  {
    this.a = paramc;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (this.a != null) {
      this.a.a(paramRunnable, paramThrowable);
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    if (this.a != null) {
      this.a.a(paramThread, paramRunnable);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.b
 * JD-Core Version:    0.7.0.1
 */