import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.mobileqq.utils.QQLSSensor.ProximitySensorChangeListener;
import com.tencent.qphone.base.util.QLog;

public class exv
  extends Handler
{
  public exv(QQLSSensor paramQQLSSensor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QQLSSensor.a(this.a) != null) {
      QQLSSensor.a(this.a).a(QQLSSensor.a(this.a));
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "QQLSSensor handler callback=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     exv
 * JD-Core Version:    0.7.0.1
 */