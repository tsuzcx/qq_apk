import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class yve
  implements Application.ActivityLifecycleCallbacks
{
  yve(yuz paramyuz) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == yuz.a(this.a)) {
      yuz.a(this.a).g();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == yuz.a(this.a)) {
      yuz.a(this.a).e();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == yuz.a(this.a)) {
      yuz.a(this.a).f();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yve
 * JD-Core Version:    0.7.0.1
 */