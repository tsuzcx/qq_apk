import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkm
  implements CompoundButton.OnCheckedChangeListener
{
  public vkm(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingActivity.Ql())
    {
      NotifyPushSettingActivity.b(this.this$0).setChecked(false);
      NotifyPushSettingActivity.b(this.this$0).setVisibility(8);
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        NotifyPushSettingActivity.b(this.this$0).setVisibility(0);
        NotifyPushSettingActivity.b(this.this$0).setVisibility(8);
        break;
      }
      NotifyPushSettingActivity.b(this.this$0).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkm
 * JD-Core Version:    0.7.0.1
 */