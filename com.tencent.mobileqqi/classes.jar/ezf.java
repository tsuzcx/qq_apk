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

public class ezf
  extends ShakeListener
{
  public void a()
  {
    if (BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    label209:
    label217:
    label244:
    for (;;)
    {
      return;
      int i = Build.VERSION.SDK_INT;
      Object localObject = BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      boolean bool1;
      if (i > 10)
      {
        i = 4;
        localObject = ((BaseActivity)localObject).getSharedPreferences("screen_shot", i).getString("currentactivity", null);
        if (!BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName().equals(localObject)) {
          continue;
        }
        bool1 = SettingCloneUtil.readValue(BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563437), "qqsetting_screenshot_key", false);
        boolean bool2 = ReflectionUtil.a(BaseApplication.getContext());
        if ((!bool1) || (!bool2)) {
          continue;
        }
        if (BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.jdField_a_of_type_ComTencentMobileqqAppScreenShot == null)
        {
          if (BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) {
            break label209;
          }
          localObject = BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
          label119:
          BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.jdField_a_of_type_ComTencentMobileqqAppScreenShot = new ScreenShot((Context)localObject, BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
        bool1 = BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
        if (bool1) {
          continue;
        }
        if (BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.jdField_a_of_type_ComTencentMobileqqAppScreenShot.b()) {
          break label217;
        }
        BaseActivity.a(BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
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
        localObject = BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        break label119;
        if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
          KapalaiAdapterUtil.a().a(BaseActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezf
 * JD-Core Version:    0.7.0.1
 */