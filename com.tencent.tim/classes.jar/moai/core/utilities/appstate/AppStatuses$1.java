package moai.core.utilities.appstate;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;

final class AppStatuses$1
  implements Application.ActivityLifecycleCallbacks
{
  private int mActiveCount = 0;
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.mActiveCount += 1;
    if (this.mActiveCount == 1)
    {
      AppStatuses.didGotoForeground();
      Log.d("AppStatuses", "didGotoForeground, activity:" + paramActivity.getClass().getSimpleName());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.mActiveCount -= 1;
    if (this.mActiveCount == 0)
    {
      AppStatuses.didGotoBackground(paramActivity);
      Log.d("AppStatuses", "did goto background, activity:" + paramActivity.getClass().getSimpleName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.appstate.AppStatuses.1
 * JD-Core Version:    0.7.0.1
 */