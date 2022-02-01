import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vcm
  implements CompoundButton.OnCheckedChangeListener
{
  public vcm(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "System_icon", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.this$0, null, this.this$0.getString(2131719914), "qqsetting_notify_icon_key", paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcm
 * JD-Core Version:    0.7.0.1
 */