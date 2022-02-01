import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class smb
  extends Handler
{
  smb(slz paramslz) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + this.this$0.jdField_a_of_type_Apbo$b + ", mTroopNotifyAd = " + this.this$0.jdField_a_of_type_Apbo$c);
    }
    if (this.this$0.jdField_a_of_type_Apbo$c != null) {
      this.this$0.a(this.this$0.jdField_a_of_type_Apbo$c);
    }
    this.this$0.bzu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smb
 * JD-Core Version:    0.7.0.1
 */