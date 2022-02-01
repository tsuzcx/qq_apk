package com.huawei.hianalytics.ab.bc.ik.cd;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class bc
{
  private static bc bc = new bc();
  private static bc cd = new bc();
  private static bc de;
  private static bc ef = new bc();
  private ThreadPoolExecutor ab;
  
  static
  {
    de = new bc();
  }
  
  private bc()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(5000);
    this.ab = new ThreadPoolExecutor(0, 1, 60000L, TimeUnit.MILLISECONDS, localLinkedBlockingQueue);
  }
  
  public static bc ab()
  {
    return bc;
  }
  
  public static bc bc()
  {
    return cd;
  }
  
  public void ab(ab paramab)
  {
    try
    {
      this.ab.execute(new ab(paramab));
      return;
    }
    catch (RejectedExecutionException paramab)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("TaskThread", "addToQueue() Exception has happened!Form rejected execution");
    }
  }
  
  static class ab
    implements Runnable
  {
    private Runnable ab;
    
    public ab(Runnable paramRunnable)
    {
      this.ab = paramRunnable;
    }
    
    public void run()
    {
      if (this.ab != null) {}
      try
      {
        this.ab.run();
        return;
      }
      catch (Exception localException)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("TaskThread", "InnerTask : Exception has happened,From internal operations!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ik.cd.bc
 * JD-Core Version:    0.7.0.1
 */