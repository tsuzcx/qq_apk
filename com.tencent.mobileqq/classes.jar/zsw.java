import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

public final class zsw
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS", 2, "msg_stop_location.");
      }
      SosoInterface.b();
      SosoInterface.c();
      SosoInterface.a(false);
      return false;
    } while (!SosoInterface.a().hasMessages(1001));
    SosoInterface.a().removeMessages(1001);
    SosoInterface.a().sendEmptyMessageDelayed(1001, 3000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsw
 * JD-Core Version:    0.7.0.1
 */