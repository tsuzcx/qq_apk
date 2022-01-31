import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.accessibility.AccessibilityManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.UserGuideWeishiFragment;
import com.tencent.qphone.base.util.QLog;

public class uli
  implements Runnable
{
  public uli(UserGuideWeishiFragment paramUserGuideWeishiFragment) {}
  
  public void run()
  {
    try
    {
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if (localFragmentActivity == null) {
        return;
      }
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      if (AppSetting.b)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UserGuideWeishiFragment", 2, "needAutoFinishForTalkBack|true ");
        }
        localFragmentActivity.finish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)localThrowable.getSystemService("accessibility");
    boolean bool1 = localAccessibilityManager.isEnabled();
    boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      AppSetting.b = bool1;
      if ((!AppSetting.b) || (localThrowable == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UserGuideWeishiFragment", 2, "needAutoFinishForTalkBack:true");
      }
      localThrowable.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uli
 * JD-Core Version:    0.7.0.1
 */