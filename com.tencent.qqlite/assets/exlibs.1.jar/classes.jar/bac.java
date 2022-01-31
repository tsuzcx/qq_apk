import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bac
  implements CompoundButton.OnCheckedChangeListener
{
  public bac(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NotifyPushSettingActivity.a(this.a).setVisibility(0);
      SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131363291), "qqsetting_notify_showcontent_key", paramBoolean);
      if (!paramBoolean) {
        break label95;
      }
    }
    label95:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      return;
      NotifyPushSettingActivity.a(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bac
 * JD-Core Version:    0.7.0.1
 */