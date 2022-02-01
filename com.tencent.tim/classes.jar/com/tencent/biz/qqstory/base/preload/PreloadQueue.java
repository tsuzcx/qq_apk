package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import java.util.LinkedList;
import png;
import ram;

@TargetApi(14)
public class PreloadQueue
  extends LinkedList<png>
{
  public static final String TAG = "Q.qqstory.download.preload.PreloadQueue";
  private final Object dataSafeLock = new Object();
  private int mQueueId;
  private final Object notEmptyLock = new Object();
  
  public void addTask(png parampng, boolean paramBoolean)
  {
    localObject = this.dataSafeLock;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        addFirst(parampng);
        releaseBlock();
        return;
      }
      finally {}
      add(parampng);
    }
  }
  
  public void clearAllTask()
  {
    synchronized (this.dataSafeLock)
    {
      clear();
      return;
    }
  }
  
  public png getFirstAndBlockIfLowestPriority()
  {
    try
    {
      png localpng = pollFirst();
      ??? = localpng;
      if (this.mQueueId == 2)
      {
        ??? = localpng;
        if (localpng == null) {
          ram.d("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " wait");
        }
      }
      synchronized (this.notEmptyLock)
      {
        this.notEmptyLock.wait(90000L);
        ??? = pollFirst();
        return ???;
      }
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      ram.w("Q.qqstory.download.preload.PreloadQueue", "getFirst error , current queue id = " + this.mQueueId);
    }
  }
  
  public int getId()
  {
    return this.mQueueId;
  }
  
  public boolean isBusy()
  {
    for (;;)
    {
      synchronized (this.dataSafeLock)
      {
        if (size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public png pollFirst()
  {
    synchronized (this.dataSafeLock)
    {
      png localpng = (png)super.pollFirst();
      return localpng;
    }
  }
  
  public void releaseBlock()
  {
    synchronized (this.notEmptyLock)
    {
      ram.d("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " releaseBlock");
      this.notEmptyLock.notifyAll();
      return;
    }
  }
  
  public String toString()
  {
    return "PreloadQueue{mQueueId=" + this.mQueueId + '}';
  }
  
  public static final class a
  {
    protected int mQueueId = 0;
    
    public a a(int paramInt)
    {
      this.mQueueId = paramInt;
      return this;
    }
    
    public PreloadQueue a()
    {
      PreloadQueue localPreloadQueue = new PreloadQueue();
      PreloadQueue.access$002(localPreloadQueue, this.mQueueId);
      return localPreloadQueue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadQueue
 * JD-Core Version:    0.7.0.1
 */