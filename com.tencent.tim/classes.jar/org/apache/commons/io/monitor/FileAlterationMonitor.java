package org.apache.commons.io.monitor;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

public final class FileAlterationMonitor
  implements Runnable
{
  private final long interval;
  private final List<FileAlterationObserver> observers = new CopyOnWriteArrayList();
  private volatile boolean running = false;
  private Thread thread = null;
  private ThreadFactory threadFactory;
  
  public FileAlterationMonitor()
  {
    this(10000L);
  }
  
  public FileAlterationMonitor(long paramLong)
  {
    this.interval = paramLong;
  }
  
  public FileAlterationMonitor(long paramLong, FileAlterationObserver... paramVarArgs)
  {
    this(paramLong);
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        addObserver(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public void addObserver(FileAlterationObserver paramFileAlterationObserver)
  {
    if (paramFileAlterationObserver != null) {
      this.observers.add(paramFileAlterationObserver);
    }
  }
  
  public long getInterval()
  {
    return this.interval;
  }
  
  public Iterable<FileAlterationObserver> getObservers()
  {
    return this.observers;
  }
  
  public void removeObserver(FileAlterationObserver paramFileAlterationObserver)
  {
    while ((paramFileAlterationObserver != null) && (this.observers.remove(paramFileAlterationObserver))) {}
  }
  
  public void run()
  {
    for (;;)
    {
      if (this.running)
      {
        Iterator localIterator = this.observers.iterator();
        while (localIterator.hasNext()) {
          ((FileAlterationObserver)localIterator.next()).checkAndNotify();
        }
        if (this.running) {}
      }
      else
      {
        return;
      }
      try
      {
        Thread.sleep(this.interval);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void setThreadFactory(ThreadFactory paramThreadFactory)
  {
    try
    {
      this.threadFactory = paramThreadFactory;
      return;
    }
    finally
    {
      paramThreadFactory = finally;
      throw paramThreadFactory;
    }
  }
  
  public void start()
    throws Exception
  {
    try
    {
      if (this.running) {
        throw new IllegalStateException("Monitor is already running");
      }
    }
    finally {}
    Iterator localIterator = this.observers.iterator();
    while (localIterator.hasNext()) {
      ((FileAlterationObserver)localIterator.next()).initialize();
    }
    this.running = true;
    if (this.threadFactory != null) {}
    for (this.thread = this.threadFactory.newThread(this);; this.thread = new Thread(this))
    {
      this.thread.start();
      return;
    }
  }
  
  public void stop()
    throws Exception
  {
    try
    {
      stop(this.interval);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void stop(long paramLong)
    throws Exception
  {
    try
    {
      if (!this.running) {
        throw new IllegalStateException("Monitor is not running");
      }
    }
    finally {}
    this.running = false;
    try
    {
      this.thread.join(paramLong);
      Iterator localIterator = this.observers.iterator();
      while (localIterator.hasNext()) {
        ((FileAlterationObserver)localIterator.next()).destroy();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Thread.currentThread().interrupt();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.monitor.FileAlterationMonitor
 * JD-Core Version:    0.7.0.1
 */