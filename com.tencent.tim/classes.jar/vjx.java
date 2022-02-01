import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class vjx
  implements CompoundButton.OnCheckedChangeListener
{
  public vjx(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((aqiw.isNetworkAvailable(this.this$0.getApplicationContext())) && (NotifyPushSettingActivity.e(this.this$0)))
    {
      this.b.Eu(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    NotifyPushSettingActivity.c(this.this$0, false);
    FormSwitchItem localFormSwitchItem = NotifyPushSettingActivity.i(this.this$0);
    if (!NotifyPushSettingActivity.i(this.this$0).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localFormSwitchItem.setChecked(bool);
      NotifyPushSettingActivity.c(this.this$0, true);
      QQToast.a(this.this$0, this.this$0.app.getApplication().getString(2131696743), 0).show(5);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjx
 * JD-Core Version:    0.7.0.1
 */