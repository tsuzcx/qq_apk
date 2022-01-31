import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ezi
  extends ShakeListener
{
  public void a()
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplicationImpl.a;
    boolean bool1;
    if (i > 10)
    {
      i = 4;
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("screen_shot", i).getString("currentactivity", null);
      if ((BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 != null) && (BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.getClass().getName().equals(localObject)))
      {
        bool1 = SettingCloneUtil.readValue(BaseApplicationImpl.a, null, BaseApplicationImpl.a.getString(2131563437), "qqsetting_screenshot_key", false);
        boolean bool2 = ReflectionUtil.a(BaseApplication.getContext());
        if ((bool1) && (bool2))
        {
          if (BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.jdField_a_of_type_ComTencentMobileqqAppScreenShot == null)
          {
            if (!BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.f) {
              break label159;
            }
            localObject = BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.getApplicationContext();
            label118:
            BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.jdField_a_of_type_ComTencentMobileqqAppScreenShot = new ScreenShot((Context)localObject, BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.getWindow());
          }
          bool1 = BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
          if (!bool1) {
            break label167;
          }
        }
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label159:
      localObject = BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2;
      break label118;
      label167:
      if (!BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.jdField_a_of_type_ComTencentMobileqqAppScreenShot.b()) {
        BaseActivity2.a(BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseActivity", 2, "snapshot activate " + bool1);
        return;
        if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
          KapalaiAdapterUtil.a().a(BaseActivity2.jdField_a_of_type_ComTencentMobileqqAppBaseActivity2.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezi
 * JD-Core Version:    0.7.0.1
 */