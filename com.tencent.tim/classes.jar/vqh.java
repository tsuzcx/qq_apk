import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class vqh
  extends aclm
{
  public vqh(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void az(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "onGetPhoneUnityLocalData data: %s, create: %s, count: %s", new Object[] { paramObject, Boolean.valueOf(this.this$0.avH), Integer.valueOf(this.this$0.bKg) }));
    }
    boolean bool1;
    if (paramObject == null)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if ((paramObject instanceof yut)) {
          bool2 = ((yut)paramObject).bpa;
        }
      }
      paramObject = this.this$0.findViewById(2131375077);
      if (paramObject != null)
      {
        if (!bool2) {
          break label190;
        }
        paramObject.setVisibility(0);
        if (!this.this$0.avH) {
          break label138;
        }
        this.this$0.xT(true);
      }
    }
    for (;;)
    {
      this.this$0.avH = false;
      return;
      bool1 = false;
      break;
      label138:
      if (this.this$0.bKg == 0)
      {
        this.this$0.xT(false);
      }
      else
      {
        paramObject = (yuu)this.this$0.app.getManager(102);
        QQSettingSettingActivity.a(this.this$0, true, paramObject.aj);
        continue;
        label190:
        paramObject.setVisibility(8);
      }
    }
  }
  
  public void f(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = true;
    if (this.this$0.isFinishing()) {}
    do
    {
      return;
      if (paramBoolean)
      {
        paramString = this.this$0;
        if (paramInt == 1) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          QQSettingSettingActivity.a(paramString, paramBoolean);
          return;
        }
      }
    } while (!this.this$0.isResume());
    paramString = this.this$0.getString(2131693229);
    QQToast.a(this.this$0.getApplicationContext(), paramString, 0).show(this.this$0.getTitleBarHeight());
  }
  
  public void v(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSetting2Activity", 2, "onGetPhoneUnityInfo isSuc: " + paramBoolean);
    }
    if (this.this$0.isFinishing()) {}
    do
    {
      return;
      QQSettingSettingActivity.a(this.this$0, paramBoolean, paramBundle);
    } while (!this.this$0.isResume());
    paramBundle = this.this$0;
    paramBundle.bKg -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqh
 * JD-Core Version:    0.7.0.1
 */