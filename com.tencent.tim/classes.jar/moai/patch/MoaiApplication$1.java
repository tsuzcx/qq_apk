package moai.patch;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import moai.patch.log.PatchLog;

class MoaiApplication$1
  implements Application.ActivityLifecycleCallbacks
{
  MoaiApplication$1(MoaiApplication paramMoaiApplication, Application paramApplication) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    MoaiApplication.access$004();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    MoaiApplication.access$006();
    if (MoaiApplication.access$000() == 0)
    {
      PatchLog.d("goto background");
      MoaiApplication.killProcessIfNeed(this.val$application, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.MoaiApplication.1
 * JD-Core Version:    0.7.0.1
 */