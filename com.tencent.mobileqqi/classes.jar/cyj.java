import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class cyj
  implements CompoundButton.OnCheckedChangeListener
{
  public cyj(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    NotifyPushSettingActivity.c(this.a).setContentDescription("通知时指示灯闪烁");
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131562526), "qqsetting_notify_blncontrol_key", paramBoolean);
    if (paramBoolean)
    {
      NotifyPushSettingActivity.a(this.a.a(), this.a.b.a(), "LED_light", 1);
      paramCompoundButton = this.a.b;
      if (!paramBoolean) {
        break label130;
      }
    }
    for (;;)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Led_blinking", 0, i, "", "", "", "");
      return;
      NotifyPushSettingActivity.a(this.a.a(), this.a.b.a(), "LED_light", 0);
      break;
      label130:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cyj
 * JD-Core Version:    0.7.0.1
 */