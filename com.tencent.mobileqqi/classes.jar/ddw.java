import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ddw
  implements CompoundButton.OnCheckedChangeListener
{
  public ddw(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    NotifyPushSettingActivity.f(this.a).setContentDescription("消息列表显示共享相册助手");
    paramCompoundButton = this.a.b;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "0X800403D", "0X800403D", 0, i, "", "", "", "");
      QZoneShareAlbumAssistantManager.a().a(this.a.b, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddw
 * JD-Core Version:    0.7.0.1
 */