import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class zqs
  extends Handler
{
  zqs(zqq paramzqq) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + this.a.jdField_a_of_type_Beba + ", mTroopNotifyAd = " + this.a.jdField_a_of_type_Bebb);
    }
    if (this.a.jdField_a_of_type_Bebb != null) {
      this.a.a(this.a.jdField_a_of_type_Bebb);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqs
 * JD-Core Version:    0.7.0.1
 */