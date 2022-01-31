import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.PhoneUnityBannerData;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class tsk
  extends SecSvcObserver
{
  public tsk(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void a(Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSetting2Activity", 4, String.format(Locale.getDefault(), "onGetPhoneUnityLocalData data: %s, create: %s, count: %s", new Object[] { paramObject, Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Integer.valueOf(this.a.jdField_a_of_type_Int) }));
    }
    boolean bool1;
    if (paramObject == null)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if ((paramObject instanceof PhoneUnityBannerData)) {
          bool2 = ((PhoneUnityBannerData)paramObject).b;
        }
      }
      paramObject = this.a.findViewById(2131369169);
      if (paramObject != null)
      {
        if (!bool2) {
          break label159;
        }
        paramObject.setVisibility(0);
        if (!this.a.jdField_a_of_type_Boolean) {
          break label138;
        }
        this.a.a(true);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      label138:
      if (this.a.jdField_a_of_type_Int == 0)
      {
        this.a.a(false);
        continue;
        label159:
        paramObject.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {}
    do
    {
      return;
      if (paramBoolean)
      {
        paramString = this.a;
        if (paramInt == 1) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          QQSettingSettingActivity.a(paramString, paramBoolean);
          return;
        }
      }
    } while (!this.a.isResume());
    paramString = this.a.getString(2131436611);
    QQToast.a(this.a.getApplicationContext(), paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      QQSettingSettingActivity.a(this.a, paramBoolean, paramBundle);
      QQSettingSettingActivity localQQSettingSettingActivity = this.a;
      localQQSettingSettingActivity.jdField_a_of_type_Int -= 1;
    } while (!QLog.isDevelopLevel());
    QLog.i("QQSetting2Activity", 4, String.format(Locale.getDefault(), "onGetPhoneUnityInfo isSuccess: %s, data: %s, count: %s", new Object[] { Boolean.valueOf(paramBoolean), paramBundle, Integer.valueOf(this.a.jdField_a_of_type_Int) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsk
 * JD-Core Version:    0.7.0.1
 */