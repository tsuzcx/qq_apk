import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abbd
  extends acfd
{
  public abbd(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_global isSuccess: " + paramBoolean + ",isFromForwardFriendActivity=" + QQSpecialFriendSettingActivity.a(this.a));
    }
    if (QQSpecialFriendSettingActivity.a(this.a)) {
      return;
    }
    this.a.mHandler.sendEmptyMessage(8194);
    paramArrayOfObject = this.a.mHandler.obtainMessage(8195);
    if (paramBoolean)
    {
      label91:
      paramArrayOfObject.arg1 = i;
      if (!paramBoolean) {
        break label137;
      }
    }
    label137:
    for (i = 2131693297;; i = 2131701717)
    {
      paramArrayOfObject.arg2 = i;
      this.a.mHandler.sendMessage(paramArrayOfObject);
      if (!paramBoolean) {
        break;
      }
      this.a.finish();
      return;
      i = 1;
      break label91;
    }
  }
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_qzone isSuccess: " + paramBoolean);
    }
    if (QQSpecialFriendSettingActivity.a(this.a)) {}
    while (paramBoolean) {
      return;
    }
    paramArrayOfObject = this.a;
    FormSwitchItem localFormSwitchItem = QQSpecialFriendSettingActivity.b(this.a);
    if (!QQSpecialFriendSettingActivity.b(this.a).isChecked()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArrayOfObject.b(localFormSwitchItem, paramBoolean);
      return;
    }
  }
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_specialRing isSuccess: " + paramBoolean);
    }
    if (QQSpecialFriendSettingActivity.a(this.a)) {
      return;
    }
    QQSpecialFriendSettingActivity.b(this.a);
  }
  
  protected void onSetSpecialCareSwitchesOfAPerson(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int j = ((Integer)paramArrayOfObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwitchesOfAPerson isSuccess: " + paramBoolean + ",isFromForwardFriendActivity=" + QQSpecialFriendSettingActivity.a(this.a) + ",result=" + j);
    }
    if (!QQSpecialFriendSettingActivity.a(this.a)) {
      return;
    }
    this.a.mHandler.sendEmptyMessage(8194);
    paramArrayOfObject = this.a.mHandler.obtainMessage(8195);
    if ((paramBoolean) && (j == 0))
    {
      i = 2;
      label117:
      paramArrayOfObject.arg1 = i;
      if ((!paramBoolean) || (j != 0)) {
        break label233;
      }
    }
    label233:
    for (int i = 2131693297;; i = 2131701714)
    {
      paramArrayOfObject.arg2 = i;
      this.a.mHandler.sendMessage(paramArrayOfObject);
      if ((!paramBoolean) || (j != 0)) {
        break;
      }
      if (!QQSpecialFriendSettingActivity.b(this.a)) {
        break label239;
      }
      paramArrayOfObject = new Intent();
      paramArrayOfObject.setClass(this.a, SpecailCareListActivity.class);
      paramArrayOfObject.addFlags(67108864);
      paramArrayOfObject.putExtra("selfSet_leftViewText", this.a.getString(2131697396));
      this.a.startActivity(paramArrayOfObject);
      this.a.finish();
      return;
      i = 1;
      break label117;
    }
    label239:
    QQSpecialFriendSettingActivity.a(this.a, true);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onUpdateDelFriend isSuccess: " + paramBoolean + ", uin: " + paramObject);
    }
    if ((paramBoolean) && (QQSpecialFriendSettingActivity.a(this.a).equals(String.valueOf(paramObject)))) {
      this.a.finish();
    }
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onUpdateSpecialCareList isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2);
    }
    QQSpecialFriendSettingActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbd
 * JD-Core Version:    0.7.0.1
 */