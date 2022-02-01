import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkh
  implements View.OnClickListener
{
  public vkh(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (NotifyPushSettingActivity.a(this.this$0) == null)
    {
      NotifyPushSettingActivity.a(this.this$0, new NotifyPushSettingActivity.a(this.this$0, this.this$0.app, NotifyPushSettingActivity.a(this.this$0), NotifyPushSettingActivity.a(this.this$0), NotifyPushSettingActivity.a(this.this$0)));
      NotifyPushSettingActivity.a.a(NotifyPushSettingActivity.a(this.this$0), NotifyPushSettingActivity.a(this.this$0));
    }
    if (NotifyPushSettingActivity.a(this.this$0))
    {
      int i = (int)NetConnInfoCenter.getServerTime();
      int j = SettingCloneUtil.readValueForInt(this.this$0.getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      NotifyPushSettingActivity.a(this.this$0).setTime(j - i);
    }
    NotifyPushSettingActivity.a(this.this$0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkh
 * JD-Core Version:    0.7.0.1
 */