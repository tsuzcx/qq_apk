import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkl
  implements CompoundButton.OnCheckedChangeListener
{
  public vkl(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, new Object[] { "avCallOnCheckedChangeListener::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!NotifyPushSettingActivity.a(this.this$0).age())
    {
      NotifyPushSettingActivity.a(this.this$0).u(this.this$0);
      NotifyPushSettingActivity.a(this.this$0).setOnCheckedChangeListener(null);
      FormSwitchItem localFormSwitchItem = NotifyPushSettingActivity.a(this.this$0);
      if (!NotifyPushSettingActivity.a(this.this$0).isChecked()) {
        bool = true;
      }
      localFormSwitchItem.setChecked(bool);
      NotifyPushSettingActivity.a(this.this$0).setOnCheckedChangeListener(this.this$0.s);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      jjc.ab(this.this$0.app.getCurrentAccountUin(), paramBoolean);
      if (!paramBoolean) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X800A33D", "0X800A33D", 0, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isChecked[" + paramBoolean + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkl
 * JD-Core Version:    0.7.0.1
 */