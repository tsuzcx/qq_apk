import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class arme
  implements Application.ActivityLifecycleCallbacks
{
  public arme(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == this.this$0.V)
    {
      ShareActionSheetV2.a(this.this$0);
      ShareActionSheetV2.b(this.this$0);
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arme
 * JD-Core Version:    0.7.0.1
 */