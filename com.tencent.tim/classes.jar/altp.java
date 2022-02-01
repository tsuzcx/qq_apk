import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager;

public class altp
  implements Application.ActivityLifecycleCallbacks
{
  public altp(RedTouchLifeTimeManager paramRedTouchLifeTimeManager) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity.getComponentName() != null)
    {
      RedTouchLifeTimeManager.a(this.this$0, paramActivity.getComponentName().getClassName());
      if ((!TextUtils.isEmpty(RedTouchLifeTimeManager.a(this.this$0))) && (RedTouchLifeTimeManager.a(this.this$0).equals(RedTouchLifeTimeManager.b(this.this$0)))) {
        RedTouchLifeTimeManager.a(this.this$0);
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altp
 * JD-Core Version:    0.7.0.1
 */