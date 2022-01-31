package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueWorkerThread
{
  private LinkedBlockingQueue aQ = new LinkedBlockingQueue();
  private boolean aR = false;
  private int aS = 1;
  private Vector aT = new Vector();
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
  
  public int add(QueueWorkerThread.ThreadObject paramThreadObject)
  {
    int j = 0;
    int i;
    if (paramThreadObject == null)
    {
      Log.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      i = -1;
    }
    do
    {
      do
      {
        return i;
        try
        {
          if (!this.aQ.offer(paramThreadObject, 1L, TimeUnit.MILLISECONDS))
          {
            Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
            return -2;
          }
        }
        catch (Exception paramThreadObject)
        {
          Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + paramThreadObject.getMessage());
          paramThreadObject.printStackTrace();
          return -3;
        }
        if (this.aT.size() == 0) {
          break;
        }
        i = j;
      } while (this.aQ.size() <= 0);
      i = j;
    } while (this.aS <= this.aT.size());
    new QueueWorkerThread.WorkerThread(this, (byte)0).start();
    return 0;
  }
  
  public int getQueueSize()
  {
    return this.aQ.size();
  }
  
  public boolean isDead()
  {
    return (this.aT == null) || (this.aT.size() == 0);
  }
  
  public void pause(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      this.aR = paramBoolean;
      if (!paramBoolean) {}
      synchronized (this.lock)
      {
        this.lock.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread
 * JD-Core Version:    0.7.0.1
 */