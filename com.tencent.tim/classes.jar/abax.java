import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abax
  extends acfd
{
  public abax(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_global isSuccess: " + paramBoolean);
    }
    Object localObject;
    boolean bool;
    if (!paramBoolean)
    {
      localObject = this.a;
      FormSwitchItem localFormSwitchItem = QQSpecialCareSettingActivity.a(this.a);
      if (!QQSpecialCareSettingActivity.a(this.a).isChecked())
      {
        bool = true;
        ((QQSpecialCareSettingActivity)localObject).b(localFormSwitchItem, bool);
      }
    }
    else
    {
      this.a.mHandler.sendEmptyMessage(8194);
      localObject = this.a.mHandler.obtainMessage(8195);
      if (paramBoolean) {
        i = 2;
      }
      ((Message)localObject).arg1 = i;
      if (!paramBoolean) {
        break label194;
      }
      if (!Boolean.valueOf(((boolean[])(boolean[])paramArrayOfObject[2])[0]).booleanValue()) {
        break label188;
      }
      i = 2131701722;
    }
    for (;;)
    {
      ((Message)localObject).arg2 = i;
      this.a.mHandler.sendMessage((Message)localObject);
      QQSpecialCareSettingActivity.b(this.a);
      anxk.ef(this.a.app);
      return;
      bool = false;
      break;
      label188:
      i = 2131701721;
      continue;
      label194:
      if (((boolean[])(boolean[])paramArrayOfObject[2])[0] != 0) {
        i = 2131701726;
      } else {
        i = 2131701717;
      }
    }
  }
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_qzone isSuccess: " + paramBoolean);
    }
    FormSwitchItem localFormSwitchItem;
    if (!paramBoolean)
    {
      paramArrayOfObject = this.a;
      localFormSwitchItem = QQSpecialCareSettingActivity.b(this.a);
      if (QQSpecialCareSettingActivity.b(this.a).isChecked()) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArrayOfObject.b(localFormSwitchItem, paramBoolean);
      QQSpecialCareSettingActivity.b(this.a);
      return;
    }
  }
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_specialRing isSuccess: " + paramBoolean);
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onUpdateDelFriend isSuccess: " + paramBoolean + ", uin: " + paramObject);
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onUpdateSpecialCareList isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2);
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abax
 * JD-Core Version:    0.7.0.1
 */