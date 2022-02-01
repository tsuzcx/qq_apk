import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vuw
  implements CompoundButton.OnCheckedChangeListener
{
  public vuw(SoundAndVibrateActivity paramSoundAndVibrateActivity, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingActivity.Ql())
    {
      SoundAndVibrateActivity.a(this.a).setChecked(false);
      SoundAndVibrateActivity.a(this.a).setVisibility(8);
      SettingCloneUtil.writeValue(this.a, this.aOy, this.a.getString(2131718988), "qqsetting_notify_showcontent_key", paramBoolean);
      aqlz.af(this.a.app, paramBoolean);
      if (!paramBoolean) {
        break label143;
      }
    }
    label143:
    for (int i = 1;; i = 0)
    {
      anot.a(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        SoundAndVibrateActivity.a(this.a).setVisibility(0);
        break;
      }
      SoundAndVibrateActivity.a(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vuw
 * JD-Core Version:    0.7.0.1
 */