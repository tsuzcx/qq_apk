import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ya
  implements CompoundButton.OnCheckedChangeListener
{
  public ya(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.c(this.a).setContentDescription("回车键发送消息");
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Enter_sendmsg", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131363071), "qqsetting_enter_sendmsg_key", paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ya
 * JD-Core Version:    0.7.0.1
 */