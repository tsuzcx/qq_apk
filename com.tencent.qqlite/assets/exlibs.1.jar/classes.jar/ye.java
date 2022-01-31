import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ye
  implements CompoundButton.OnCheckedChangeListener
{
  public ye(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.e(this.a).setContentDescription("WiFi下自动在后台下载新版本");
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ConfigHandler.b(this.a.app, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      UpgradeController.a().a();
      return;
    }
    UpgradeController.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ye
 * JD-Core Version:    0.7.0.1
 */