import android.telephony.PhoneStateListener;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.qphone.base.util.QLog;

public class bmb
  extends PhoneStateListener
{
  public bmb(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_IDLE");
      }
      if ((this.a.jdField_a_of_type_Boolean) && (!PhoneStatusTools.e(this.a.jdField_a_of_type_AndroidContentContext)))
      {
        this.a.jdField_a_of_type_Boolean = false;
        if (this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(false);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_RINGING or CALL_STATE_OFFHOOK");
          }
          if (!this.a.jdField_a_of_type_Boolean)
          {
            this.a.jdField_a_of_type_Boolean = true;
            if (this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null) {
              this.a.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(true);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmb
 * JD-Core Version:    0.7.0.1
 */