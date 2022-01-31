package com.tencent.qqpimsecure.pg;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;

class t
  implements Application.ActivityLifecycleCallbacks
{
  t(r paramr, Handler paramHandler) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    q.a(r.a(this.b), false);
    this.a.removeCallbacksAndMessages(null);
    this.a.postDelayed(new u(this), 2000L);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    q.a(r.a(this.b), true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.t
 * JD-Core Version:    0.7.0.1
 */