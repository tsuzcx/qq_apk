import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vki
  implements CompoundButton.OnCheckedChangeListener
{
  public vki(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.this$0, this.this$0.currentUin, this.this$0.getString(2131717468), "qqsetting_special_care_bar", paramBoolean);
    this.e.Es(paramBoolean);
    ausb.Wb(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "onCheckedChanged: invoked. care bar  isChecked: " + paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vki
 * JD-Core Version:    0.7.0.1
 */