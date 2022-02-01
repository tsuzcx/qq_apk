package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Looper;
import com.facebook.stetho.common.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public final class ActivityTracker
{
  private static final ActivityTracker sInstance = new ActivityTracker();
  @GuardedBy("Looper.getMainLooper()")
  private final ArrayList<Activity> mActivities = new ArrayList();
  private final List<Activity> mActivitiesUnmodifiable = Collections.unmodifiableList(this.mActivities);
  @Nullable
  private AutomaticTracker mAutomaticTracker;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();
  
  public static ActivityTracker get()
  {
    return sInstance;
  }
  
  public void add(Activity paramActivity)
  {
    Util.throwIfNull(paramActivity);
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      Util.throwIfNot(bool);
      this.mActivities.add(paramActivity);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((Listener)localIterator.next()).onActivityAdded(paramActivity);
      }
    }
  }
  
  public boolean beginTrackingIfPossible(Application paramApplication)
  {
    if (this.mAutomaticTracker == null)
    {
      paramApplication = AutomaticTracker.newInstanceIfPossible(paramApplication, this);
      if (paramApplication != null)
      {
        paramApplication.register();
        this.mAutomaticTracker = paramApplication;
        return true;
      }
    }
    return false;
  }
  
  public boolean endTracking()
  {
    if (this.mAutomaticTracker != null)
    {
      this.mAutomaticTracker.unregister();
      this.mAutomaticTracker = null;
      return true;
    }
    return false;
  }
  
  public List<Activity> getActivitiesView()
  {
    return this.mActivitiesUnmodifiable;
  }
  
  public void registerListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }
  
  public void remove(Activity paramActivity)
  {
    Util.throwIfNull(paramActivity);
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      Util.throwIfNot(bool);
      if (!this.mActivities.remove(paramActivity)) {
        break;
      }
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((Listener)localIterator.next()).onActivityRemoved(paramActivity);
      }
    }
  }
  
  public Activity tryGetTopActivity()
  {
    if (this.mActivitiesUnmodifiable.isEmpty()) {
      return null;
    }
    return (Activity)this.mActivitiesUnmodifiable.get(this.mActivitiesUnmodifiable.size() - 1);
  }
  
  public void unregisterListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }
  
  static abstract class AutomaticTracker
  {
    @Nullable
    public static AutomaticTracker newInstanceIfPossible(Application paramApplication, ActivityTracker paramActivityTracker)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        return new AutomaticTrackerICSAndBeyond(paramApplication, paramActivityTracker);
      }
      return null;
    }
    
    public abstract void register();
    
    public abstract void unregister();
    
    @TargetApi(14)
    static class AutomaticTrackerICSAndBeyond
      extends ActivityTracker.AutomaticTracker
    {
      private final Application mApplication;
      private final Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.1(this);
      private final ActivityTracker mTracker;
      
      public AutomaticTrackerICSAndBeyond(Application paramApplication, ActivityTracker paramActivityTracker)
      {
        super();
        this.mApplication = paramApplication;
        this.mTracker = paramActivityTracker;
      }
      
      public void register()
      {
        this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
      }
      
      public void unregister()
      {
        this.mApplication.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
      }
    }
  }
  
  public static abstract interface Listener
  {
    public abstract void onActivityAdded(Activity paramActivity);
    
    public abstract void onActivityRemoved(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.ActivityTracker
 * JD-Core Version:    0.7.0.1
 */