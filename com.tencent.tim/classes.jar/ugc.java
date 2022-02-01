import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ugc
  implements CompoundButton.OnCheckedChangeListener
{
  public ugc(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.enableTalkBack) {
      this.this$0.r.setContentDescription(acfp.m(2131702908));
    }
    QQAppInterface localQQAppInterface = this.this$0.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      anot.a(localQQAppInterface, "CliOper", "", "", "Shake_screenshot", "Shake_screenshot_switch", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.this$0, null, this.this$0.getString(2131697091), "qqsetting_screenshot_key", paramBoolean);
      if (!paramBoolean) {
        break label106;
      }
      this.this$0.turnOnShake();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label106:
      this.this$0.turnOffShake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugc
 * JD-Core Version:    0.7.0.1
 */