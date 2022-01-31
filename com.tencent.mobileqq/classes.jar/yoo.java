import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class yoo
  extends Handler
{
  yoo(yom paramyom) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + this.a.jdField_a_of_type_Bbnp + ", mTroopNotifyAd = " + this.a.jdField_a_of_type_Bbnq);
    }
    if (this.a.jdField_a_of_type_Bbnq != null) {
      this.a.a(this.a.jdField_a_of_type_Bbnq);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoo
 * JD-Core Version:    0.7.0.1
 */