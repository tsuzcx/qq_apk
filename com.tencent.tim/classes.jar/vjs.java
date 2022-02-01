import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vjs
  implements CompoundButton.OnCheckedChangeListener
{
  public vjs(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      auqw.ewn();
      localQQAppInterface = this.this$0.app;
      if (!paramBoolean) {
        break label91;
      }
      str1 = "0X8004BE7";
      label23:
      if (!paramBoolean) {
        break label97;
      }
    }
    label91:
    label97:
    for (String str2 = "0X8004BE7";; str2 = "0X8004BE6")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "1", "", "", "");
      if (AppSetting.enableTalkBack) {
        NotifyPushSettingActivity.d(this.this$0).setContentDescription(acfp.m(2131709172));
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      auqw.ewo();
      break;
      str1 = "0X8004BE6";
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjs
 * JD-Core Version:    0.7.0.1
 */