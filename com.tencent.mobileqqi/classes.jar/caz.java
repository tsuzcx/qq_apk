import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class caz
  implements CompoundButton.OnCheckedChangeListener
{
  public caz(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.b(this.a).setContentDescription("2G/3G/4G下自动接收图片");
    SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131563423), "qqsetting_auto_receive_pic_key", paramBoolean);
    paramCompoundButton = this.a.b;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_auto_receive_pic", 0, i, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     caz
 * JD-Core Version:    0.7.0.1
 */