package com.tencent.token.global.taiji;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b
  extends ThreadPoolExecutor
{
  private a a = null;
  
  public b(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, new a(), paramRejectedExecutionHandler);
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    a locala = this.a;
    if (locala != null) {
      locala.a(paramRunnable, paramThrowable);
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    a locala = this.a;
    if (locala != null) {
      locala.a(paramThread, paramRunnable);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
  }
  
  public static abstract interface a
  {
    public abstract void a(Runnable paramRunnable, Throwable paramThrowable);
    
    public abstract void a(Thread paramThread, Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.b
 * JD-Core Version:    0.7.0.1
 */