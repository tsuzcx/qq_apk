import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;

public class ddd
  extends BroadcastReceiver
{
  public ddd(QQSettingMe paramQQSettingMe) {}
  
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
      QQSettingMe.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddd
 * JD-Core Version:    0.7.0.1
 */