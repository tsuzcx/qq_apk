import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class cur
  implements CompoundButton.OnCheckedChangeListener
{
  public cur(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    if (paramCompoundButton == LoginInfoActivity.a(this.a).a())
    {
      paramCompoundButton = this.a.b;
      if (paramBoolean)
      {
        ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
        SettingCloneUtil.writeValue(this.a, this.a.b.a(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
        this.a.b.m();
      }
    }
    while (paramCompoundButton != LoginInfoActivity.b(this.a).a()) {
      for (;;)
      {
        return;
        i = 0;
      }
    }
    paramCompoundButton = this.a.b;
    if (paramBoolean) {}
    for (i = j;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Security_check", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, "security_scan_key", "qqsetting_security_scan_key", paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cur
 * JD-Core Version:    0.7.0.1
 */