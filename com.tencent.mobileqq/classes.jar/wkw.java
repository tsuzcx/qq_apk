import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class wkw
  extends Handler
{
  wkw(wku paramwku) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + this.a.jdField_a_of_type_Ayoo + ", mTroopNotifyAd = " + this.a.jdField_a_of_type_Ayop);
    }
    if (this.a.jdField_a_of_type_Ayop != null) {
      this.a.a(this.a.jdField_a_of_type_Ayop);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wkw
 * JD-Core Version:    0.7.0.1
 */