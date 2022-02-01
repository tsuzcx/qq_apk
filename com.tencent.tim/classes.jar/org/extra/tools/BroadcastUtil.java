package org.extra.tools;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BroadcastUtil
  implements ScreenBroadcastReceiver.ScreenStateListener
{
  private static List<WeakReference<ScreenBroadcastReceiver.ScreenStateListener>> mDataList = new ArrayList();
  private final Object mSync = new Object();
  private ScreenBroadcastReceiver receiver = null;
  
  public static BroadcastUtil getInstance()
  {
    return Factory.INSTANCE;
  }
  
  private void removeUnUse()
  {
    Object localObject3;
    synchronized (this.mSync)
    {
      ArrayList localArrayList = new ArrayList();
      localObject3 = mDataList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
        if (localWeakReference.get() == null) {
          localArrayList.add(localWeakReference);
        }
      }
    }
    Iterator localIterator = localObject2.iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (WeakReference)localIterator.next();
      mDataList.remove(localObject3);
    }
  }
  
  public void onScreenOff()
  {
    removeUnUse();
    for (;;)
    {
      int i;
      synchronized (this.mSync)
      {
        i = mDataList.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.ScreenStateListener localScreenStateListener = (ScreenBroadcastReceiver.ScreenStateListener)((WeakReference)mDataList.get(i)).get();
          if (localScreenStateListener != null) {
            localScreenStateListener.onScreenOff();
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public void onScreenOn()
  {
    removeUnUse();
    for (;;)
    {
      int i;
      synchronized (this.mSync)
      {
        i = mDataList.size() - 1;
        if (i >= 0)
        {
          ScreenBroadcastReceiver.ScreenStateListener localScreenStateListener = (ScreenBroadcastReceiver.ScreenStateListener)((WeakReference)mDataList.get(i)).get();
          if (localScreenStateListener != null) {
            localScreenStateListener.onScreenOn();
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public void registerScreenBroadcast()
  {
    if (this.receiver != null) {
      return;
    }
    this.receiver = new ScreenBroadcastReceiver(this);
    this.receiver.register();
  }
  
  public void registerScreenBroadcast(ScreenBroadcastReceiver.ScreenStateListener paramScreenStateListener)
  {
    if (this.receiver == null) {}
    do
    {
      return;
      removeUnUse();
    } while (paramScreenStateListener == null);
    synchronized (this.mSync)
    {
      Iterator localIterator = mDataList.iterator();
      while (localIterator.hasNext()) {
        if (paramScreenStateListener == ((WeakReference)localIterator.next()).get()) {
          return;
        }
      }
    }
    paramScreenStateListener = new WeakReference(paramScreenStateListener);
    mDataList.add(paramScreenStateListener);
  }
  
  public void unregisterScreenBroadcast()
  {
    if (this.receiver != null)
    {
      this.receiver.unregister();
      this.receiver = null;
    }
  }
  
  public void unregisterScreenBroadcast(ScreenBroadcastReceiver.ScreenStateListener paramScreenStateListener)
  {
    if (this.receiver == null) {}
    do
    {
      return;
      removeUnUse();
    } while (paramScreenStateListener == null);
    Object localObject2 = this.mSync;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = mDataList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if (paramScreenStateListener == localWeakReference.get()) {
            localObject1 = localWeakReference;
          }
        }
        else
        {
          if (localObject1 != null) {
            mDataList.remove(localObject1);
          }
          return;
        }
      }
      finally {}
    }
  }
  
  static class Factory
  {
    private static final BroadcastUtil INSTANCE = new BroadcastUtil();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.extra.tools.BroadcastUtil
 * JD-Core Version:    0.7.0.1
 */