package com.tencent.qqlive.module.videoreport.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListenerMgr<T>
{
  private static boolean isDebug = false;
  private final ConcurrentLinkedQueue<WeakReference<T>> mListenerQueue = new ConcurrentLinkedQueue();
  
  public static void setDebug(boolean paramBoolean)
  {
    isDebug = paramBoolean;
  }
  
  public void clear()
  {
    synchronized (this.mListenerQueue)
    {
      this.mListenerQueue.clear();
      return;
    }
  }
  
  public void register(T paramT)
  {
    if (paramT == null) {
      return;
    }
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.mListenerQueue;
    int i = 0;
    Object localObject;
    try
    {
      Iterator localIterator = this.mListenerQueue.iterator();
      if (localIterator.hasNext())
      {
        localObject = ((WeakReference)localIterator.next()).get();
        if (localObject != null) {
          break label96;
        }
        localIterator.remove();
      }
      else
      {
        if (i == 0)
        {
          paramT = new WeakReference(paramT);
          this.mListenerQueue.add(paramT);
        }
        return;
      }
    }
    finally {}
    for (;;)
    {
      break;
      label96:
      if (localObject == paramT) {
        i = 1;
      }
    }
  }
  
  public int size()
  {
    synchronized (this.mListenerQueue)
    {
      int i = this.mListenerQueue.size();
      return i;
    }
  }
  
  public void startNotify(INotifyCallback<T> paramINotifyCallback)
  {
    Object localObject1 = null;
    synchronized (this.mListenerQueue)
    {
      if (this.mListenerQueue.size() > 0) {
        localObject1 = new ConcurrentLinkedQueue(this.mListenerQueue);
      }
      if (localObject1 != null) {
        try
        {
          localObject1 = ((ConcurrentLinkedQueue)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = ((WeakReference)((Iterator)localObject1).next()).get();
            if (??? != null)
            {
              try
              {
                paramINotifyCallback.onNotify(???);
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
                Log.e("crash", localThrowable.toString(), localThrowable);
              }
              if (isDebug) {
                new Handler(Looper.getMainLooper()).post(new ListenerMgr.1(this, localThrowable));
              }
            }
          }
          return;
        }
        catch (Throwable paramINotifyCallback) {}
      }
    }
  }
  
  public void unregister(T paramT)
  {
    if (paramT == null) {
      return;
    }
    synchronized (this.mListenerQueue)
    {
      Iterator localIterator = this.mListenerQueue.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramT)
        {
          localIterator.remove();
          return;
        }
      }
    }
  }
  
  public static abstract interface INotifyCallback<T>
  {
    public abstract void onNotify(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ListenerMgr
 * JD-Core Version:    0.7.0.1
 */