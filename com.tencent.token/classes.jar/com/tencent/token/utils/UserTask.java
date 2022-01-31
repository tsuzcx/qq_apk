package com.tencent.token.utils;

import com.tencent.token.global.h;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class UserTask
{
  private static final BlockingQueue a = new LinkedBlockingQueue(10);
  private static final ThreadFactory b = new z();
  private static final ThreadPoolExecutor c = new ThreadPoolExecutor(1, 10, 2L, TimeUnit.SECONDS, a, b);
  private static ad d;
  private final af e;
  private final FutureTask f;
  private volatile UserTask.Status g = UserTask.Status.PENDING;
  
  public UserTask()
  {
    try
    {
      if (d == null) {
        d = new ad(null);
      }
      label28:
      this.e = new aa(this);
      this.f = new ab(this, this.e);
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  private void b(Object paramObject)
  {
    a(paramObject);
    this.g = UserTask.Status.FINISHED;
  }
  
  public abstract Object a(Object... paramVarArgs);
  
  public void a() {}
  
  public void a(Object paramObject) {}
  
  public final boolean a(boolean paramBoolean)
  {
    return this.f.cancel(paramBoolean);
  }
  
  public final UserTask.Status b()
  {
    return this.g;
  }
  
  public void b(Object... paramVarArgs) {}
  
  public final UserTask c(Object... paramVarArgs)
  {
    if (this.g != UserTask.Status.PENDING) {}
    switch (ac.a[this.g.ordinal()])
    {
    default: 
      this.g = UserTask.Status.RUNNING;
      c();
      this.e.b = paramVarArgs;
    }
    try
    {
      c.execute(this.f);
      return this;
    }
    catch (Exception paramVarArgs)
    {
      h.c("exception: " + paramVarArgs.getMessage());
      a();
      this.g = UserTask.Status.FINISHED;
    }
    throw new IllegalStateException("Cannot execute task: the task is already running.");
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    return this;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.UserTask
 * JD-Core Version:    0.7.0.1
 */