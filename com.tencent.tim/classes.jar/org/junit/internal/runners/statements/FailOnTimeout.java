package org.junit.internal.runners.statements;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;

public class FailOnTimeout
  extends Statement
{
  private final boolean lookForStuckThread;
  private final Statement originalStatement;
  private volatile ThreadGroup threadGroup = null;
  private final TimeUnit timeUnit;
  private final long timeout;
  
  private FailOnTimeout(Builder paramBuilder, Statement paramStatement)
  {
    this.originalStatement = paramStatement;
    this.timeout = paramBuilder.timeout;
    this.timeUnit = paramBuilder.unit;
    this.lookForStuckThread = paramBuilder.lookForStuckThread;
  }
  
  @Deprecated
  public FailOnTimeout(Statement paramStatement, long paramLong)
  {
    this(builder().withTimeout(paramLong, TimeUnit.MILLISECONDS), paramStatement);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private Thread[] copyThreads(Thread[] paramArrayOfThread, int paramInt)
  {
    int i = Math.min(paramInt, paramArrayOfThread.length);
    Thread[] arrayOfThread = new Thread[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfThread[paramInt] = paramArrayOfThread[paramInt];
      paramInt += 1;
    }
    return arrayOfThread;
  }
  
  private long cpuTime(Thread paramThread)
  {
    ThreadMXBean localThreadMXBean = ManagementFactory.getThreadMXBean();
    if (localThreadMXBean.isThreadCpuTimeSupported()) {
      try
      {
        long l = localThreadMXBean.getThreadCpuTime(paramThread.getId());
        return l;
      }
      catch (UnsupportedOperationException paramThread) {}
    }
    return 0L;
  }
  
  private Exception createTimeoutException(Thread paramThread)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThread.getStackTrace();
    if (this.lookForStuckThread) {}
    TestTimedOutException localTestTimedOutException;
    for (Thread localThread = getStuckThread(paramThread);; localThread = null)
    {
      localTestTimedOutException = new TestTimedOutException(this.timeout, this.timeUnit);
      if (arrayOfStackTraceElement != null)
      {
        localTestTimedOutException.setStackTrace(arrayOfStackTraceElement);
        paramThread.interrupt();
      }
      if (localThread == null) {
        break;
      }
      paramThread = new Exception("Appears to be stuck in thread " + localThread.getName());
      paramThread.setStackTrace(getStackTrace(localThread));
      return new MultipleFailureException(Arrays.asList(new Throwable[] { localTestTimedOutException, paramThread }));
    }
    return localTestTimedOutException;
  }
  
  private Throwable getResult(FutureTask<Throwable> paramFutureTask, Thread paramThread)
  {
    try
    {
      if (this.timeout > 0L) {
        return (Throwable)paramFutureTask.get(this.timeout, this.timeUnit);
      }
      paramFutureTask = (Throwable)paramFutureTask.get();
      return paramFutureTask;
    }
    catch (ExecutionException paramFutureTask)
    {
      return paramFutureTask.getCause();
    }
    catch (TimeoutException paramFutureTask)
    {
      return createTimeoutException(paramThread);
    }
    catch (InterruptedException paramFutureTask) {}
    return paramFutureTask;
  }
  
  private StackTraceElement[] getStackTrace(Thread paramThread)
  {
    try
    {
      paramThread = paramThread.getStackTrace();
      return paramThread;
    }
    catch (SecurityException paramThread) {}
    return new StackTraceElement[0];
  }
  
  private Thread getStuckThread(Thread paramThread)
  {
    if (this.threadGroup == null) {}
    Thread[] arrayOfThread;
    do
    {
      return null;
      arrayOfThread = getThreadArray(this.threadGroup);
    } while (arrayOfThread == null);
    int j = arrayOfThread.length;
    int i = 0;
    Object localObject1 = null;
    long l1 = 0L;
    Object localObject2;
    if (i < j)
    {
      localObject2 = arrayOfThread[i];
      if (((Thread)localObject2).getState() != Thread.State.RUNNABLE) {
        break label110;
      }
      long l2 = cpuTime((Thread)localObject2);
      if ((localObject1 != null) && (l2 <= l1)) {
        break label110;
      }
      l1 = l2;
      localObject1 = localObject2;
    }
    label110:
    for (;;)
    {
      i += 1;
      break;
      localObject2 = localObject1;
      if (localObject1 == paramThread) {
        localObject2 = null;
      }
      return localObject2;
    }
  }
  
  private Thread[] getThreadArray(ThreadGroup paramThreadGroup)
  {
    int j = Math.max(paramThreadGroup.activeCount() * 2, 100);
    int i = 0;
    int k;
    do
    {
      Thread[] arrayOfThread = new Thread[j];
      k = paramThreadGroup.enumerate(arrayOfThread);
      if (k < j) {
        return copyThreads(arrayOfThread, k);
      }
      j += 100;
      k = i + 1;
      i = k;
    } while (k < 5);
    return null;
  }
  
  public void evaluate()
    throws Throwable
  {
    Object localObject = new CallableStatement(null);
    FutureTask localFutureTask = new FutureTask((Callable)localObject);
    this.threadGroup = new ThreadGroup("FailOnTimeoutGroup");
    Thread localThread = new Thread(this.threadGroup, localFutureTask, "Time-limited test");
    localThread.setDaemon(true);
    localThread.start();
    ((CallableStatement)localObject).awaitStarted();
    localObject = getResult(localFutureTask, localThread);
    if (localObject != null) {
      throw ((Throwable)localObject);
    }
  }
  
  public static class Builder
  {
    private boolean lookForStuckThread = false;
    private long timeout = 0L;
    private TimeUnit unit = TimeUnit.SECONDS;
    
    public FailOnTimeout build(Statement paramStatement)
    {
      if (paramStatement == null) {
        throw new NullPointerException("statement cannot be null");
      }
      return new FailOnTimeout(this, paramStatement, null);
    }
    
    public Builder withLookingForStuckThread(boolean paramBoolean)
    {
      this.lookForStuckThread = paramBoolean;
      return this;
    }
    
    public Builder withTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("timeout must be non-negative");
      }
      if (paramTimeUnit == null) {
        throw new NullPointerException("TimeUnit cannot be null");
      }
      this.timeout = paramLong;
      this.unit = paramTimeUnit;
      return this;
    }
  }
  
  class CallableStatement
    implements Callable<Throwable>
  {
    private final CountDownLatch startLatch = new CountDownLatch(1);
    
    private CallableStatement() {}
    
    public void awaitStarted()
      throws InterruptedException
    {
      this.startLatch.await();
    }
    
    public Throwable call()
      throws Exception
    {
      try
      {
        this.startLatch.countDown();
        FailOnTimeout.this.originalStatement.evaluate();
        return null;
      }
      catch (Exception localException)
      {
        throw localException;
      }
      catch (Throwable localThrowable)
      {
        return localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.runners.statements.FailOnTimeout
 * JD-Core Version:    0.7.0.1
 */