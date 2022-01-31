import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.qphone.base.util.QLog;

public class bma
  extends BroadcastReceiver
{
  public bma(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, "onReceive NEW_OUTGOING_CALL");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "onReceive PHONE_STATE");
          }
          if ((!this.a.jdField_a_of_type_Boolean) || (PhoneStatusTools.e(this.a.jdField_a_of_type_AndroidContentContext))) {
            break;
          }
          this.a.jdField_a_of_type_Boolean = false;
        } while (this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener == null);
        this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(false);
        return;
      } while ((this.a.jdField_a_of_type_Boolean) || (!PhoneStatusTools.e(this.a.jdField_a_of_type_AndroidContentContext)));
      this.a.jdField_a_of_type_Boolean = true;
    } while (this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener == null);
    this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bma
 * JD-Core Version:    0.7.0.1
 */