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
public class ClassRoadie
{
  private Description description;
  private RunNotifier notifier;
  private final Runnable runnable;
  private TestClass testClass;
  
  public ClassRoadie(RunNotifier paramRunNotifier, TestClass paramTestClass, Description paramDescription, Runnable paramRunnable)
  {
    this.notifier = paramRunNotifier;
    this.testClass = paramTestClass;
    this.description = paramDescription;
    this.runnable = paramRunnable;
  }
  
  private void runAfters()
  {
    Iterator localIterator = this.testClass.getAfters().iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      try
      {
        localMethod.invoke(null, new Object[0]);
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
      Iterator localIterator = this.testClass.getBefores().iterator();
      while (localIterator.hasNext()) {
        ((Method)localIterator.next()).invoke(null, new Object[0]);
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
  
  protected void addFailure(Throwable paramThrowable)
  {
    this.notifier.fireTestFailure(new Failure(this.description, paramThrowable));
  }
  
  /* Error */
  public void runProtected()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 92	org/junit/internal/runners/ClassRoadie:runBefores	()V
    //   4: aload_0
    //   5: invokevirtual 95	org/junit/internal/runners/ClassRoadie:runUnprotected	()V
    //   8: aload_0
    //   9: invokespecial 97	org/junit/internal/runners/ClassRoadie:runAfters	()V
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: invokespecial 97	org/junit/internal/runners/ClassRoadie:runAfters	()V
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: invokespecial 97	org/junit/internal/runners/ClassRoadie:runAfters	()V
    //   24: aload_1
    //   25: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	ClassRoadie
    //   13	1	1	localFailedBefore	FailedBefore
    //   19	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	13	org/junit/internal/runners/FailedBefore
    //   0	8	19	finally
  }
  
  protected void runUnprotected()
  {
    this.runnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.runners.ClassRoadie
 * JD-Core Version:    0.7.0.1
 */