package com.tencent.token.utils;

import com.tencent.token.global.e;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class UserTask
{
  private static final BlockingQueue a = new LinkedBlockingQueue(10);
  private static final ThreadFactory b = new v();
  private static final ThreadPoolExecutor c = new ThreadPoolExecutor(1, 10, 2L, TimeUnit.SECONDS, a, b);
  private static z d;
  private final ab e;
  private final FutureTask f;
  private volatile UserTask.Status g = UserTask.Status.PENDING;
  
  public UserTask()
  {
    try
    {
      if (d == null) {
        d = new z();
      }
      label27:
      this.e = new w(this);
      this.f = new x(this, this.e);
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public final UserTask a(Object... paramVarArgs)
  {
    if (this.g != UserTask.Status.PENDING) {}
    switch (y.a[this.g.ordinal()])
    {
    default: 
      this.g = UserTask.Status.RUNNING;
      this.e.b = paramVarArgs;
    }
    try
    {
      c.execute(this.f);
      return this;
    }
    catch (Exception paramVarArgs)
    {
      e.c("exception: " + paramVarArgs.getMessage());
      a();
      this.g = UserTask.Status.FINISHED;
    }
    throw new IllegalStateException("Cannot execute task: the task is already running.");
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    return this;
  }
  
  public void a() {}
  
  public void a(Object paramObject) {}
  
  public abstract Object b();
  
  public final UserTask.Status c()
  {
    return this.g;
  }
  
  public final boolean d()
  {
    return this.f.cancel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.UserTask
 * JD-Core Version:    0.7.0.1
 */