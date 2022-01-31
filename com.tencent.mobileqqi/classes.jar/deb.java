import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class deb
  implements CompoundButton.OnCheckedChangeListener
{
  public deb(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131563433), "qqsetting_notify_myfeedpush_key", paramBoolean);
    NotifyPushSettingActivity.d(this.a).setContentDescription("与我相关的动态");
    paramCompoundButton = this.a.b;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_about_me", 0, i, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     deb
 * JD-Core Version:    0.7.0.1
 */