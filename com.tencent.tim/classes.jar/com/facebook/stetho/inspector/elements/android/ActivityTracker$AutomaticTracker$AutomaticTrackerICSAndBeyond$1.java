package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class ActivityTracker$AutomaticTracker$AutomaticTrackerICSAndBeyond$1
  implements Application.ActivityLifecycleCallbacks
{
  ActivityTracker$AutomaticTracker$AutomaticTrackerICSAndBeyond$1(ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond paramAutomaticTrackerICSAndBeyond) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.access$100(this.this$0).add(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.access$100(this.this$0).remove(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.1
 * JD-Core Version:    0.7.0.1
 */