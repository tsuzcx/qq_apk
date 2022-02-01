import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class vjv
  implements CompoundButton.OnCheckedChangeListener
{
  public vjv(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.enableTalkBack) {
      NotifyPushSettingActivity.g(this.this$0).setContentDescription("PC离线时自动启动QQ手机版");
    }
    QQAppInterface localQQAppInterface;
    int i;
    if (!NotifyPushSettingActivity.b(this.this$0))
    {
      if (paramBoolean) {
        anot.a(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 1, "", "", "", "");
      }
    }
    else
    {
      if ((!aqiw.isNetworkAvailable(this.this$0.getApplicationContext())) || (!NotifyPushSettingActivity.c(this.this$0))) {
        break label193;
      }
      localQQAppInterface = this.this$0.app;
      if (!paramBoolean) {
        break label181;
      }
      i = 1;
      label94:
      if (!paramBoolean) {
        break label186;
      }
    }
    label181:
    label186:
    for (Object localObject = "1";; localObject = "0")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "PC_active", 0, i, (String)localObject, "", "", "");
      if (!NotifyPushSettingActivity.b(this.this$0)) {
        this.d.Er(paramBoolean);
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      anot.a(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 0, "", "", "", "");
      break;
      i = 0;
      break label94;
    }
    label193:
    NotifyPushSettingActivity.a(this.this$0, false);
    localObject = NotifyPushSettingActivity.g(this.this$0);
    if (!NotifyPushSettingActivity.g(this.this$0).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      NotifyPushSettingActivity.a(this.this$0, true);
      QQToast.a(this.this$0, this.this$0.app.getApplication().getString(2131696743), 0).show(5);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjv
 * JD-Core Version:    0.7.0.1
 */