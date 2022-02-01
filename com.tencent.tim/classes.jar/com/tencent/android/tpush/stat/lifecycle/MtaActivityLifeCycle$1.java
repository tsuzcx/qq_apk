package com.tencent.android.tpush.stat.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class MtaActivityLifeCycle$1
  implements Application.ActivityLifecycleCallbacks
{
  MtaActivityLifeCycle$1(a parama) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.a.b(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    this.a.e(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    MtaActivityLifeCycle.a(null);
    this.a.d(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    MtaActivityLifeCycle.a(paramActivity);
    this.a.c(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.a.a(paramActivity, paramBundle);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (MtaActivityLifeCycle.a() == 0) {
      MtaActivityLifeCycle.a(System.currentTimeMillis());
    }
    MtaActivityLifeCycle.a(MtaActivityLifeCycle.a() + 1);
    this.a.b(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    MtaActivityLifeCycle.a(MtaActivityLifeCycle.a() - 1);
    this.a.a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.lifecycle.MtaActivityLifeCycle.1
 * JD-Core Version:    0.7.0.1
 */