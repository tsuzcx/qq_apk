package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public abstract class bk
  implements Application.ActivityLifecycleCallbacks
{
  public abstract void a(Activity paramActivity, String paramString);
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity, "onActivityStarted");
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bk
 * JD-Core Version:    0.7.0.1
 */