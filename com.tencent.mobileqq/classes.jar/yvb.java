import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class yvb
  implements Application.ActivityLifecycleCallbacks
{
  yvb(yuw paramyuw) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == yuw.a(this.a)) {
      yuw.a(this.a).g();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == yuw.a(this.a)) {
      yuw.a(this.a).e();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == yuw.a(this.a)) {
      yuw.a(this.a).f();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvb
 * JD-Core Version:    0.7.0.1
 */