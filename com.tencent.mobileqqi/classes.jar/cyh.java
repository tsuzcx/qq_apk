import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class cyh
  implements CompoundButton.OnCheckedChangeListener
{
  public cyh(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NotifyPushSettingActivity.a(this.a).setVisibility(0);
      SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131563458), "qqsetting_notify_showcontent_key", paramBoolean);
      if (!paramBoolean) {
        break label95;
      }
    }
    label95:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      return;
      NotifyPushSettingActivity.a(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cyh
 * JD-Core Version:    0.7.0.1
 */