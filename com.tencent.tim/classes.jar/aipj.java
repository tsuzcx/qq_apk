import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class aipj
  implements Application.ActivityLifecycleCallbacks
{
  aipj(aipd paramaipd) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityDestroyed: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityResumed: " + paramActivity.getClass().getName());
    }
    if ((this.this$0.clh) && (!this.this$0.clg))
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.gM);
      ThreadManager.getUIHandlerV2().postDelayed(this.this$0.gM, 1000L);
    }
    while (!aipd.b(this.this$0)) {
      return;
    }
    aipd.a(this.this$0, false);
    this.this$0.mIsForeground = true;
    this.this$0.Ll(true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityStarted: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityStopped: " + paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipj
 * JD-Core Version:    0.7.0.1
 */