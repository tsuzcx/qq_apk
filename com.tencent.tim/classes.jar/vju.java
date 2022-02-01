import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vju
  implements CompoundButton.OnCheckedChangeListener
{
  public vju(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.enableTalkBack) {
      NotifyPushSettingActivity.f(this.this$0).setContentDescription(acfp.m(2131709183));
    }
    SettingCloneUtil.writeValue(this.this$0, this.this$0.currentUin, this.this$0.getString(2131718627), "qqsetting_receivemsg_whenexit_key", paramBoolean);
    SyncService.A(this.this$0, paramBoolean);
    QQAppInterface localQQAppInterface = this.this$0.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label117;
      }
    }
    label117:
    for (String str = "1";; str = "0")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Logout_msg", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vju
 * JD-Core Version:    0.7.0.1
 */