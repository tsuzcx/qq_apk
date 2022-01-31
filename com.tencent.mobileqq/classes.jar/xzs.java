import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class xzs
  extends MqqHandler
{
  xzs(xzr paramxzr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE2", 2, "QFindGattManager write data timeout bleSN " + (String)paramMessage.obj);
      }
      xzr.a(this.a, paramMessage.arg1);
      this.a.a((String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xzs
 * JD-Core Version:    0.7.0.1
 */