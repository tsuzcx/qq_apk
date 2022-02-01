package com.tribe.async.async;

import com.tribe.async.dispatch.SimpleQueue;
import com.tribe.async.log.SLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RunnableQueue
  implements SimpleQueue<Runnable>
{
  private static final String TAG = "async.boss.RunnableQueue";
  private final List<Runnable> mQueue = new LinkedList();
  
  public void dump()
  {
    Iterator localIterator = this.mQueue.iterator();
    Runnable localRunnable;
    for (String str = "["; localIterator.hasNext(); str = str + "," + localRunnable.toString()) {
      localRunnable = (Runnable)localIterator.next();
    }
    SLog.d("async.boss.RunnableQueue", str + "]");
  }
  
  public void enqueue(Runnable paramRunnable)
  {
    this.mQueue.add(paramRunnable);
  }
  
  public Runnable poll()
  {
    if (this.mQueue.size() > 0) {
      return (Runnable)this.mQueue.remove(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.RunnableQueue
 * JD-Core Version:    0.7.0.1
 */