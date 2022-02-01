package com.tencent.shadow.proguard;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks
{
  private List a = new LinkedList();
  
  public final void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Activity)localIterator.next()).finish();
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.a.add(paramActivity);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.a.remove(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.proguard.d
 * JD-Core Version:    0.7.0.1
 */