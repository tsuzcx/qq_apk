package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.content.Intent;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ActivityLifecycle
{
  private static ReferenceQueue<ActivityLifecycleCallback> mCallbackReferenceQueue = new ReferenceQueue();
  private static ArrayList<WeakReference<ActivityLifecycleCallback>> mWeakCallbackArrayList = new ArrayList();
  
  public static void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("ActivityLifecycle onNewIntent");
    }
    synchronized (mWeakCallbackArrayList)
    {
      try
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        while (localIterator.hasNext())
        {
          ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycleCallback)((WeakReference)localIterator.next()).get();
          if (localActivityLifecycleCallback != null) {
            try
            {
              localActivityLifecycleCallback.onNewIntent(paramActivity, paramIntent);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        paramActivity = finally;
      }
      catch (ConcurrentModificationException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
  }
  
  public static void onPause(Activity paramActivity)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("ActivityLifecycle onPause");
    }
    synchronized (mWeakCallbackArrayList)
    {
      try
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        while (localIterator.hasNext())
        {
          ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycleCallback)((WeakReference)localIterator.next()).get();
          if (localActivityLifecycleCallback != null) {
            try
            {
              localActivityLifecycleCallback.onPause(paramActivity);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        paramActivity = finally;
      }
      catch (ConcurrentModificationException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
  }
  
  public static void onResume(Activity paramActivity)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("ActivityLifecycle onResume");
    }
    synchronized (mWeakCallbackArrayList)
    {
      try
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        while (localIterator.hasNext())
        {
          ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycleCallback)((WeakReference)localIterator.next()).get();
          if (localActivityLifecycleCallback != null) {
            try
            {
              localActivityLifecycleCallback.onResume(paramActivity);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        paramActivity = finally;
      }
      catch (ConcurrentModificationException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
  }
  
  public static void registerNFCEventCallback(ActivityLifecycleCallback paramActivityLifecycleCallback)
  {
    if (paramActivityLifecycleCallback == null) {
      return;
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("ActivityLifecycle registerNFCEventCallback;callback=" + paramActivityLifecycleCallback.getClass().getName());
    }
    Object localObject;
    synchronized (mWeakCallbackArrayList)
    {
      localObject = mCallbackReferenceQueue.poll();
      if (localObject != null) {
        mWeakCallbackArrayList.remove(localObject);
      }
    }
    try
    {
      localObject = mWeakCallbackArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityLifecycleCallback localActivityLifecycleCallback = (ActivityLifecycleCallback)((WeakReference)((Iterator)localObject).next()).get();
        if (localActivityLifecycleCallback == paramActivityLifecycleCallback) {
          return;
        }
      }
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      label112:
      break label112;
    }
    paramActivityLifecycleCallback = new WeakReference(paramActivityLifecycleCallback, mCallbackReferenceQueue);
    mWeakCallbackArrayList.add(paramActivityLifecycleCallback);
  }
  
  public void unregister(ActivityLifecycleCallback paramActivityLifecycleCallback)
  {
    if (paramActivityLifecycleCallback == null) {
      return;
    }
    try
    {
      synchronized (mWeakCallbackArrayList)
      {
        Iterator localIterator = mWeakCallbackArrayList.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((ActivityLifecycleCallback)localWeakReference.get() == paramActivityLifecycleCallback)
          {
            mWeakCallbackArrayList.remove(localWeakReference);
            return;
          }
        }
      }
      return;
    }
    catch (ConcurrentModificationException paramActivityLifecycleCallback) {}
  }
  
  public static abstract interface ActivityLifecycleCallback
  {
    public abstract void onNewIntent(Activity paramActivity, Intent paramIntent);
    
    public abstract void onPause(Activity paramActivity);
    
    public abstract void onResume(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ActivityLifecycle
 * JD-Core Version:    0.7.0.1
 */