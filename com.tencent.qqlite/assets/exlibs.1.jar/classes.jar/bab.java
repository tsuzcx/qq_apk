import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bab
  implements CompoundButton.OnCheckedChangeListener
{
  public bab(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    NotifyPushSettingActivity.c(this.a).setContentDescription("通知时指示灯闪烁");
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131363279), "qqsetting_notify_blncontrol_key", paramBoolean);
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.a(), "LED_light", 1);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label138;
      }
      label80:
      if (!paramBoolean) {
        break label143;
      }
    }
    label138:
    label143:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Led_blinking", 0, i, paramCompoundButton, "", "", "");
      return;
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.a(), "LED_light", 0);
      break;
      i = 0;
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bab
 * JD-Core Version:    0.7.0.1
 */