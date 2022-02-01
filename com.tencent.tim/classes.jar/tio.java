import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class tio
  implements Application.ActivityLifecycleCallbacks
{
  tio(tij paramtij) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == tij.a(this.a)) {
      tij.a(this.a).onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == tij.a(this.a)) {
      tij.a(this.a).onPause();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == tij.a(this.a)) {
      tij.a(this.a).onResume();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tio
 * JD-Core Version:    0.7.0.1
 */