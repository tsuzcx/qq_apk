package com.tencent.token;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class xg
  extends ThreadPoolExecutor
{
  a a = null;
  
  public xg(int paramInt, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(0, paramInt, 3L, paramTimeUnit, paramBlockingQueue, new xf(), paramRejectedExecutionHandler);
  }
  
  protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    paramThrowable = this.a;
    if (paramThrowable != null) {
      paramThrowable.a(paramRunnable);
    }
  }
  
  protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    a locala = this.a;
    if (locala != null) {
      locala.a(paramThread, paramRunnable);
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
  }
  
  public static abstract interface a
  {
    public abstract void a(Runnable paramRunnable);
    
    public abstract void a(Thread paramThread, Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xg
 * JD-Core Version:    0.7.0.1
 */