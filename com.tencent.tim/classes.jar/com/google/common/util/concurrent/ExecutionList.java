package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
public final class ExecutionList
{
  private static final Logger log = Logger.getLogger(ExecutionList.class.getName());
  @GuardedBy("this")
  private boolean executed;
  @GuardedBy("this")
  private RunnableExecutorPair runnables;
  
  private static void executeListener(Runnable paramRunnable, Executor paramExecutor)
  {
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.log(Level.SEVERE, "RuntimeException while executing runnable " + paramRunnable + " with executor " + paramExecutor, localRuntimeException);
    }
  }
  
  public void add(Runnable paramRunnable, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
    Preconditions.checkNotNull(paramExecutor, "Executor was null.");
    try
    {
      if (!this.executed)
      {
        this.runnables = new RunnableExecutorPair(paramRunnable, paramExecutor, this.runnables);
        return;
      }
      executeListener(paramRunnable, paramExecutor);
      return;
    }
    finally {}
  }
  
  public void execute()
  {
    Object localObject4;
    try
    {
      if (this.executed) {
        return;
      }
      this.executed = true;
      Object localObject3 = this.runnables;
      this.runnables = null;
      Object localObject1 = null;
      for (;;)
      {
        localObject4 = localObject1;
        if (localObject3 == null) {
          break;
        }
        localObject4 = ((RunnableExecutorPair)localObject3).next;
        ((RunnableExecutorPair)localObject3).next = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      if (localObject4 == null) {
        return;
      }
    }
    finally {}
    for (;;)
    {
      executeListener(((RunnableExecutorPair)localObject4).runnable, ((RunnableExecutorPair)localObject4).executor);
      localObject4 = ((RunnableExecutorPair)localObject4).next;
    }
  }
  
  static final class RunnableExecutorPair
  {
    final Executor executor;
    @Nullable
    RunnableExecutorPair next;
    final Runnable runnable;
    
    RunnableExecutorPair(Runnable paramRunnable, Executor paramExecutor, RunnableExecutorPair paramRunnableExecutorPair)
    {
      this.runnable = paramRunnable;
      this.executor = paramExecutor;
      this.next = paramRunnableExecutorPair;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ExecutionList
 * JD-Core Version:    0.7.0.1
 */