import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;

public class vph
  extends BroadcastReceiver
{
  public vph(QQSettingMe paramQQSettingMe) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "UpdateVipInfoReceiver: intent=" + paramIntent.toString());
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_pay_action_result", false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "UpdateVipInfoReceiver: need update ");
      }
      this.this$0.bpQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vph
 * JD-Core Version:    0.7.0.1
 */