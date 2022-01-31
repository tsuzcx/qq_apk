import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class cqe
  extends ShakeListener
{
  public void a()
  {
    if (BaseActivity.sTopActivity == null) {}
    label209:
    label217:
    label244:
    for (;;)
    {
      return;
      int i = Build.VERSION.SDK_INT;
      Object localObject = BaseActivity.sTopActivity;
      boolean bool1;
      if (i > 10)
      {
        i = 4;
        localObject = ((BaseActivity)localObject).getSharedPreferences("screen_shot", i).getString("currentactivity", null);
        if (!BaseActivity.sTopActivity.getClass().getName().equals(localObject)) {
          continue;
        }
        bool1 = SettingCloneUtil.readValue(BaseActivity.sTopActivity, null, BaseActivity.sTopActivity.getString(2131363054), "qqsetting_screenshot_key", false);
        boolean bool2 = ReflectionUtil.a(BaseApplication.getContext());
        if ((!bool1) || (!bool2)) {
          continue;
        }
        if (BaseActivity.sTopActivity.a == null)
        {
          if (BaseActivity.sTopActivity.isResume()) {
            break label209;
          }
          localObject = BaseActivity.sTopActivity.getApplicationContext();
          label119:
          BaseActivity.sTopActivity.a = new ScreenShot((Context)localObject, BaseActivity.sTopActivity.getWindow());
        }
        bool1 = BaseActivity.sTopActivity.a.a();
        if (bool1) {
          continue;
        }
        if (BaseActivity.sTopActivity.a.b()) {
          break label217;
        }
        BaseActivity.a(BaseActivity.sTopActivity);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label244;
        }
        QLog.d("BaseActivity", 2, "snapshot activate " + bool1);
        return;
        i = 0;
        break;
        localObject = BaseActivity.sTopActivity;
        break label119;
        if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
          KapalaiAdapterUtil.a().a(BaseActivity.sTopActivity.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cqe
 * JD-Core Version:    0.7.0.1
 */