package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class MethodRoadie
{
  private final Description description;
  private final RunNotifier notifier;
  private final Object test;
  private TestMethod testMethod;
  
  public MethodRoadie(Object paramObject, TestMethod paramTestMethod, RunNotifier paramRunNotifier, Description paramDescription)
  {
    this.test = paramObject;
    this.notifier = paramRunNotifier;
    this.description = paramDescription;
    this.testMethod = paramTestMethod;
  }
  
  private void runAfters()
  {
    Iterator localIterator = this.testMethod.getAfters().iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      try
      {
        localMethod.invoke(this.test, new Object[0]);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        addFailure(localInvocationTargetException.getTargetException());
      }
      catch (Throwable localThrowable)
      {
        addFailure(localThrowable);
      }
    }
  }
  
  private void runBefores()
    throws FailedBefore
  {
    try
    {
      Iterator localIterator = this.testMethod.getBefores().iterator();
      while (localIterator.hasNext()) {
        ((Method)localIterator.next()).invoke(this.test, new Object[0]);
      }
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw localInvocationTargetException.getTargetException();
    }
    catch (AssumptionViolatedException localAssumptionViolatedException)
    {
      throw new FailedBefore();
    }
    catch (Throwable localThrowable)
    {
      addFailure(localThrowable);
      throw new FailedBefore();
    }
  }
  
  private void runWithTimeout(long paramLong)
  {
    runBeforesThenTestThenAfters(new MethodRoadie.1(this, paramLong));
  }
  
  protected void addFailure(Throwable paramThrowable)
  {
    this.notifier.fireTestFailure(new Failure(this.description, paramThrowable));
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   4: invokevirtual 104	org/junit/internal/runners/TestMethod:isIgnored	()Z
    //   7: ifeq +15 -> 22
    //   10: aload_0
    //   11: getfield 22	org/junit/internal/runners/MethodRoadie:notifier	Lorg/junit/runner/notification/RunNotifier;
    //   14: aload_0
    //   15: getfield 24	org/junit/internal/runners/MethodRoadie:description	Lorg/junit/runner/Description;
    //   18: invokevirtual 108	org/junit/runner/notification/RunNotifier:fireTestIgnored	(Lorg/junit/runner/Description;)V
    //   21: return
    //   22: aload_0
    //   23: getfield 22	org/junit/internal/runners/MethodRoadie:notifier	Lorg/junit/runner/notification/RunNotifier;
    //   26: aload_0
    //   27: getfield 24	org/junit/internal/runners/MethodRoadie:description	Lorg/junit/runner/Description;
    //   30: invokevirtual 111	org/junit/runner/notification/RunNotifier:fireTestStarted	(Lorg/junit/runner/Description;)V
    //   33: aload_0
    //   34: getfield 26	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   37: invokevirtual 115	org/junit/internal/runners/TestMethod:getTimeout	()J
    //   40: lstore_1
    //   41: lload_1
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle +20 -> 64
    //   47: aload_0
    //   48: lload_1
    //   49: invokespecial 117	org/junit/internal/runners/MethodRoadie:runWithTimeout	(J)V
    //   52: aload_0
    //   53: getfield 22	org/junit/internal/runners/MethodRoadie:notifier	Lorg/junit/runner/notification/RunNotifier;
    //   56: aload_0
    //   57: getfield 24	org/junit/internal/runners/MethodRoadie:description	Lorg/junit/runner/Description;
    //   60: invokevirtual 120	org/junit/runner/notification/RunNotifier:fireTestFinished	(Lorg/junit/runner/Description;)V
    //   63: return
    //   64: aload_0
    //   65: invokevirtual 123	org/junit/internal/runners/MethodRoadie:runTest	()V
    //   68: goto -16 -> 52
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 22	org/junit/internal/runners/MethodRoadie:notifier	Lorg/junit/runner/notification/RunNotifier;
    //   76: aload_0
    //   77: getfield 24	org/junit/internal/runners/MethodRoadie:description	Lorg/junit/runner/Description;
    //   80: invokevirtual 120	org/junit/runner/notification/RunNotifier:fireTestFinished	(Lorg/junit/runner/Description;)V
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	MethodRoadie
    //   40	9	1	l	long
    //   71	13	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	41	71	finally
    //   47	52	71	finally
    //   64	68	71	finally
  }
  
  public void runBeforesThenTestThenAfters(Runnable paramRunnable)
  {
    try
    {
      runBefores();
      paramRunnable.run();
      return;
    }
    catch (FailedBefore paramRunnable) {}catch (Exception paramRunnable)
    {
      throw new RuntimeException("test should never throw an exception to this level");
    }
    finally
    {
      runAfters();
    }
  }
  
  public void runTest()
  {
    runBeforesThenTestThenAfters(new MethodRoadie.2(this));
  }
  
  protected void runTestMethod()
  {
    try
    {
      this.testMethod.invoke(this.test);
      if (this.testMethod.expectsException()) {
        addFailure(new AssertionError("Expected exception: " + this.testMethod.getExpectedException().getName()));
      }
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable1;
      do
      {
        do
        {
          localThrowable1 = localInvocationTargetException.getTargetException();
        } while ((localThrowable1 instanceof AssumptionViolatedException));
        if (!this.testMethod.expectsException())
        {
          addFailure(localThrowable1);
          return;
        }
      } while (!this.testMethod.isUnexpected(localThrowable1));
      addFailure(new Exception("Unexpected exception, expected<" + this.testMethod.getExpectedException().getName() + "> but was<" + localThrowable1.getClass().getName() + ">", localThrowable1));
      return;
    }
    catch (Throwable localThrowable2)
    {
      addFailure(localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.runners.MethodRoadie
 * JD-Core Version:    0.7.0.1
 */