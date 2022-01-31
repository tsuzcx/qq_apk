import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;

class yxg
  implements Runnable
{
  yxg(yxf paramyxf, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("screen_shot", 4).getString("currentactivity", null);
      bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName().equals(localObject);
    }
    if ((bool) && (SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433564), "qqsetting_screenshot_key", false)) && (ReflectionUtil.a(BaseApplicationImpl.sApplication)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isSupportScreenShot()) {
        break label98;
      }
      ScreenShot.a("MyShakeListener - not support screen shot");
    }
    for (;;)
    {
      return;
      label98:
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot == null) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) {
          break label182;
        }
      }
      label182:
      for (localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();; localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot = new ScreenShot((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot.a()) {
          break;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot.b();
        if (!bool) {
          break label190;
        }
        ScreenShot.a("MyShakeListener - screenshot is showing");
        return;
      }
      label190:
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.screenShot.c())
      {
        ScreenShot.a("MyShakeListener - screenshot cant activate");
        BaseActivity.access$000(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseActivity", 2, "snapshot activate " + bool);
        return;
        if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
          KapalaiAdapterUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yxg
 * JD-Core Version:    0.7.0.1
 */