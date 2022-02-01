package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;

public class RunNotifier
{
  private final List<RunListener> listeners = new CopyOnWriteArrayList();
  private volatile boolean pleaseStop = false;
  
  private void fireTestFailures(List<RunListener> paramList, List<Failure> paramList1)
  {
    if (!paramList1.isEmpty()) {
      new RunNotifier.4(this, paramList, paramList1).run();
    }
  }
  
  public void addFirstListener(RunListener paramRunListener)
  {
    if (paramRunListener == null) {
      throw new NullPointerException("Cannot add a null listener");
    }
    this.listeners.add(0, wrapIfNotThreadSafe(paramRunListener));
  }
  
  public void addListener(RunListener paramRunListener)
  {
    if (paramRunListener == null) {
      throw new NullPointerException("Cannot add a null listener");
    }
    this.listeners.add(wrapIfNotThreadSafe(paramRunListener));
  }
  
  public void fireTestAssumptionFailed(Failure paramFailure)
  {
    new RunNotifier.5(this, paramFailure).run();
  }
  
  public void fireTestFailure(Failure paramFailure)
  {
    fireTestFailures(this.listeners, Arrays.asList(new Failure[] { paramFailure }));
  }
  
  public void fireTestFinished(Description paramDescription)
  {
    new RunNotifier.7(this, paramDescription).run();
  }
  
  public void fireTestIgnored(Description paramDescription)
  {
    new RunNotifier.6(this, paramDescription).run();
  }
  
  public void fireTestRunFinished(Result paramResult)
  {
    new RunNotifier.2(this, paramResult).run();
  }
  
  public void fireTestRunStarted(Description paramDescription)
  {
    new RunNotifier.1(this, paramDescription).run();
  }
  
  public void fireTestStarted(Description paramDescription)
    throws StoppedByUserException
  {
    if (this.pleaseStop) {
      throw new StoppedByUserException();
    }
    new RunNotifier.3(this, paramDescription).run();
  }
  
  public void pleaseStop()
  {
    this.pleaseStop = true;
  }
  
  public void removeListener(RunListener paramRunListener)
  {
    if (paramRunListener == null) {
      throw new NullPointerException("Cannot remove a null listener");
    }
    this.listeners.remove(wrapIfNotThreadSafe(paramRunListener));
  }
  
  RunListener wrapIfNotThreadSafe(RunListener paramRunListener)
  {
    if (paramRunListener.getClass().isAnnotationPresent(RunListener.ThreadSafe.class)) {
      return paramRunListener;
    }
    return new SynchronizedRunListener(paramRunListener, this);
  }
  
  abstract class SafeNotifier
  {
    private final List<RunListener> currentListeners;
    
    SafeNotifier()
    {
      this(RunNotifier.this.listeners);
    }
    
    SafeNotifier()
    {
      Object localObject;
      this.currentListeners = localObject;
    }
    
    protected abstract void notifyListener(RunListener paramRunListener)
      throws Exception;
    
    void run()
    {
      int i = this.currentListeners.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      Iterator localIterator = this.currentListeners.iterator();
      while (localIterator.hasNext())
      {
        RunListener localRunListener = (RunListener)localIterator.next();
        try
        {
          notifyListener(localRunListener);
          localArrayList1.add(localRunListener);
        }
        catch (Exception localException)
        {
          localArrayList2.add(new Failure(Description.TEST_MECHANISM, localException));
        }
      }
      RunNotifier.this.fireTestFailures(localArrayList1, localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.notification.RunNotifier
 * JD-Core Version:    0.7.0.1
 */