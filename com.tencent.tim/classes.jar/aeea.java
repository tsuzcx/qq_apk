import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aeea
  implements Application.ActivityLifecycleCallbacks
{
  public aeea(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityDestroyed: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityResumed: " + paramActivity.getClass().getName());
    }
    if (this.this$0.bTd)
    {
      this.this$0.bTd = false;
      this.this$0.Vp = true;
      this.this$0.b().removeCallbacks(this.this$0.gi);
      this.this$0.b().postDelayed(this.this$0.gi, 200L);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityStarted: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityStopped: " + paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeea
 * JD-Core Version:    0.7.0.1
 */