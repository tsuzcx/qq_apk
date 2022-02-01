import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;

public class vjt
  implements CompoundButton.OnCheckedChangeListener
{
  public vjt(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBooleanAsync(this.this$0.getString(2131718976) + this.this$0.currentUin, paramBoolean);
    if (AppSetting.enableTalkBack) {
      NotifyPushSettingActivity.e(this.this$0).setContentDescription(acfp.m(2131709191));
    }
    QQAppInterface localQQAppInterface = this.this$0.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (String str = "1";; str = "0")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_about_me", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjt
 * JD-Core Version:    0.7.0.1
 */