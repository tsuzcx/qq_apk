package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueWorkerThread
{
  private LinkedBlockingQueue<ThreadObject> aQ = new LinkedBlockingQueue();
  private boolean aR = false;
  private int aS = 1;
  private Vector<WorkerThread> aT = new Vector();
  private Handler aU = new QueueWorkerThread.1(this);
  private Object lock = new byte[0];
  private String name = "";
  private int priority = 1;
  
  public QueueWorkerThread(int paramInt, String paramString)
  {
    this(paramInt, paramString, 1);
  }
  
  public QueueWorkerThread(int paramInt1, String paramString, int paramInt2)
  {
    this.aS = paramInt2;
    this.name = paramString;
    this.priority = paramInt1;
  }
  
  public int add(ThreadObject paramThreadObject)
  {
    if (paramThreadObject == null)
    {
      Log.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      return -1;
    }
    try
    {
      if (!this.aQ.offer(paramThreadObject, 1L, TimeUnit.MILLISECONDS))
      {
        Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
        return -2;
      }
      if ((this.aT.size() == 0) || ((this.aQ.size() > 0) && (this.aS > this.aT.size()))) {
        new WorkerThread((byte)0).start();
      }
      return 0;
    }
    catch (Exception paramThreadObject)
    {
      StringBuilder localStringBuilder = new StringBuilder("add To Queue failed :");
      localStringBuilder.append(paramThreadObject.getMessage());
      Log.e("QueueWorkerThread.QueueWorkerThread", localStringBuilder.toString());
      paramThreadObject.printStackTrace();
    }
    return -3;
  }
  
  public int getQueueSize()
  {
    return this.aQ.size();
  }
  
  public boolean isDead()
  {
    Vector localVector = this.aT;
    return (localVector == null) || (localVector.size() == 0);
  }
  
  public void pause(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      this.aR = paramBoolean;
      if (!paramBoolean) {
        synchronized (this.lock)
        {
          this.lock.notifyAll();
        }
      }
      return;
    }
  }
  
  public static abstract interface ThreadObject
  {
    public abstract boolean doInBackground();
    
    public abstract boolean onPostExecute();
  }
  
  final class WorkerThread
    extends Thread
  {
    private int aW = 60;
    
    private WorkerThread()
    {
      super();
      setPriority(QueueWorkerThread.b(QueueWorkerThread.this));
      QueueWorkerThread.c(QueueWorkerThread.this).add(this);
    }
    
    public final void run()
    {
      while (this.aW > 0)
      {
        try
        {
          synchronized (QueueWorkerThread.d(QueueWorkerThread.this))
          {
            if (QueueWorkerThread.e(QueueWorkerThread.this)) {
              QueueWorkerThread.d(QueueWorkerThread.this).wait();
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          try
          {
            ??? = (QueueWorkerThread.ThreadObject)QueueWorkerThread.f(QueueWorkerThread.this).poll(2000L, TimeUnit.MILLISECONDS);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            localObject2 = null;
          }
          if (localObject2 == null)
          {
            this.aW -= 1;
            continue;
          }
          this.aW = 60;
        }
        if (((QueueWorkerThread.ThreadObject)localObject2).doInBackground())
        {
          QueueWorkerThread.g(QueueWorkerThread.this).sendMessage(QueueWorkerThread.g(QueueWorkerThread.this).obtainMessage(0, localObject2));
          continue;
          throw localException2;
        }
      }
      QueueWorkerThread.c(QueueWorkerThread.this).remove(this);
      Object localObject2 = new StringBuilder("dktest Finish queueToReqSize:");
      ((StringBuilder)localObject2).append(QueueWorkerThread.f(QueueWorkerThread.this).size());
      ((StringBuilder)localObject2).append(" ThreadSize:");
      ((StringBuilder)localObject2).append(QueueWorkerThread.c(QueueWorkerThread.this).size());
      Log.d("QueueWorkerThread.QueueWorkerThread", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread
 * JD-Core Version:    0.7.0.1
 */