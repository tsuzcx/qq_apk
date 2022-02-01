import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vgh
  implements CompoundButton.OnCheckedChangeListener
{
  public vgh(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == LoginInfoActivity.a(this.this$0).a())
    {
      localQQAppInterface = this.this$0.app;
      if (paramBoolean)
      {
        i = 1;
        anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
        if (!paramBoolean) {
          break label142;
        }
        anot.a(null, "dc00898", "", "", "0X800A721", "0X800A721", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "帐号安全页点击“允许手机、电脑同时在线”进行开启！0X800A721");
        }
        label96:
        SettingCloneUtil.writeValue(this.this$0, this.this$0.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
        this.this$0.app.cLA();
      }
    }
    label142:
    label219:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i = 0;
        break;
        anot.a(null, "dc00898", "", "", "0X800A722", "0X800A722", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          break label96;
        }
        QLog.d("DevRpt", 2, "帐号安全页点击“允许手机、电脑同时在线”进行关闭！0X800A722");
        break label96;
        if ((LoginInfoActivity.b(this.this$0) == null) || (paramCompoundButton != LoginInfoActivity.b(this.this$0).a())) {
          break label219;
        }
        LoginInfoActivity.a(this.this$0, paramBoolean);
      }
    } while (paramCompoundButton != LoginInfoActivity.c(this.this$0).a());
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Security_check", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.this$0, null, "security_scan_key", "qqsetting_security_scan_key", paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgh
 * JD-Core Version:    0.7.0.1
 */