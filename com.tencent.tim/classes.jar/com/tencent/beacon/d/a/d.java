package com.tencent.beacon.d.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class d
  implements Application.ActivityLifecycleCallbacks
{
  private long a = System.currentTimeMillis();
  private Map<Activity, Long> b = new HashMap(3);
  private StatModule c;
  
  public d(StatModule paramStatModule)
  {
    this.c = paramStatModule;
  }
  
  private void a(Activity paramActivity)
  {
    Long localLong = (Long)this.b.get(paramActivity);
    if (localLong == null) {
      localLong = Long.valueOf(this.a);
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      String str = paramActivity.getLocalClassName();
      this.c.b(str, l - localLong.longValue(), l);
      this.b.remove(paramActivity);
      return;
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.b.put(paramActivity, Long.valueOf(System.currentTimeMillis()));
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.d.a.d
 * JD-Core Version:    0.7.0.1
 */