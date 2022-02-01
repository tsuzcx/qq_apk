import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vjr
  implements CompoundButton.OnCheckedChangeListener
{
  public vjr(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (AppSetting.enableTalkBack) {
      NotifyPushSettingActivity.c(this.this$0).setContentDescription(acfp.m(2131718980));
    }
    SettingCloneUtil.writeValue(this.this$0, this.this$0.currentUin, this.this$0.getString(2131718980), "qqsetting_notify_blncontrol_key", paramBoolean);
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      NotifyPushSettingActivity.d(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin(), "LED_light", 1);
      localQQAppInterface = this.this$0.app;
      if (!paramBoolean) {
        break label157;
      }
      label89:
      if (!paramBoolean) {
        break label162;
      }
    }
    label157:
    label162:
    for (String str = "1";; str = "0")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Led_blinking", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      NotifyPushSettingActivity.d(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin(), "LED_light", 0);
      break;
      i = 0;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjr
 * JD-Core Version:    0.7.0.1
 */