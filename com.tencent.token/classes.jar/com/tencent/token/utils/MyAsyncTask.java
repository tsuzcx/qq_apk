package com.tencent.token.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MyAsyncTask
{
  public static final Executor a = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, d, c, new ThreadPoolExecutor.DiscardOldestPolicy());
  public static final Executor b = new r(null);
  private static final ThreadFactory c = new o();
  private static final BlockingQueue d = new LinkedBlockingQueue(10);
  private static final q e = new q(null);
  private static volatile Executor f = b;
  private volatile MyAsyncTask.Status g;
  private final AtomicBoolean h;
  
  private void c(Object paramObject)
  {
    if (b()) {
      b(paramObject);
    }
    for (;;)
    {
      this.g = MyAsyncTask.Status.FINISHED;
      return;
      a(paramObject);
    }
  }
  
  protected void a() {}
  
  protected void a(Object paramObject) {}
  
  protected void a(Object... paramVarArgs) {}
  
  protected void b(Object paramObject)
  {
    a();
  }
  
  public final boolean b()
  {
    return this.h.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.MyAsyncTask
 * JD-Core Version:    0.7.0.1
 */