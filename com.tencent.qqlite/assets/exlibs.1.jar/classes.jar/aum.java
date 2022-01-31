import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class aum
  implements CompoundButton.OnCheckedChangeListener
{
  public aum(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == LoginInfoActivity.a(this.a).a())
    {
      paramCompoundButton = this.a.app;
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, this.a.app.a(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
      this.a.app.l();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aum
 * JD-Core Version:    0.7.0.1
 */