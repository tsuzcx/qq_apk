import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajce
  implements CompoundButton.OnCheckedChangeListener
{
  ajce(ajcd paramajcd, NotifyPushSettingActivity paramNotifyPushSettingActivity, FormSwitchItem paramFormSwitchItem) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "NEW_MSG_NOTIFICATION_KEY::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!this.b.age())
    {
      this.b.u(this.a);
      this.bs.setOnCheckedChangeListener(null);
      FormSwitchItem localFormSwitchItem = this.bs;
      if (!this.bs.isChecked()) {
        bool = true;
      }
      localFormSwitchItem.setChecked(bool);
      this.bs.setOnCheckedChangeListener(this.b.a);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    SettingCloneUtil.writeValue(this.b.mApp.getApp(), this.b.mApp.getCurrentUin(), null, "new_msg_notification_key", paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A511", "0X800A511", i, 0, "", "", "", "");
      ((auqd)this.b.mApp.getBusinessHandler(184)).VX(paramBoolean);
      break;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajce
 * JD-Core Version:    0.7.0.1
 */